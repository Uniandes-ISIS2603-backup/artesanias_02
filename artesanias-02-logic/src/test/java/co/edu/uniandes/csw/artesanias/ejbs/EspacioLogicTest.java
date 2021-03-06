/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artesanias.ejbs;

import co.edu.uniandes.csw.artesanias.entities.CiudadEntity;
import co.edu.uniandes.csw.artesanias.entities.EspacioEntity;
import co.edu.uniandes.csw.artesanias.entities.FeriaEntity;
import co.edu.uniandes.csw.artesanias.entities.PabellonEntity;
import co.edu.uniandes.csw.artesanias.persistence.EspacioPersistence;
import co.edu.uniandes.csw.artesanias.persistence.PersistenceTest;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Miller
 */
@RunWith(Arquillian.class)
public class EspacioLogicTest extends PersistenceTest<EspacioEntity> {
    
    @Inject
    private EspacioLogic logic;
    
    private CiudadEntity ciudad;
    
    private FeriaEntity feria;
    
    private PabellonEntity pabellon;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EspacioEntity.class.getPackage())
                .addPackage(EspacioLogicTest.class.getPackage())
                .addPackage(EspacioPersistence.class.getPackage())
                .addPackage(CiudadEntity.class.getPackage())
                .addPackage(FeriaEntity.class.getPackage())
                .addPackage(PabellonEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Override
    protected void clearData() {
        em.createQuery("DELETE FROM EspacioEntity").executeUpdate();
        em.createQuery("DELETE FROM CiudadEntity").executeUpdate();
        em.createQuery("DELETE FROM FeriaEntity").executeUpdate();
        em.createQuery("DELETE FROM PabellonEntity").executeUpdate();
    }

    @Override
    protected void insertData() {
        ciudad = factory.manufacturePojo(CiudadEntity.class);
        feria = factory.manufacturePojo(FeriaEntity.class);
        pabellon = factory.manufacturePojo(PabellonEntity.class);;
        em.persist(ciudad);
        em.persist(feria);
        em.persist(pabellon);
        List<FeriaEntity> fs = new LinkedList<>();
        fs.add(feria);
        List<PabellonEntity> ps = new LinkedList<>();
        ps.add(pabellon);
        for (int i = 0; i < 10; i++) {
            EspacioEntity entity = factory.manufacturePojo(EspacioEntity.class);
            entity.setCapacidad(entity.getCapacidad() <= 0 ? 100 : entity.getCapacidad());
            entity.setCiudad(ciudad);
            entity.setFerias(fs);
            entity.setPabellones(ps);
            em.persist(entity);
            data.add(entity);
        }
    }

    //--------------------------------------------------------------------------
    // Métodos de Espacio
    //--------------------------------------------------------------------------
    
    @Test
    public void createEspacio() throws Exception {
        EspacioEntity entity = factory.manufacturePojo(EspacioEntity.class);
        entity.setCiudad(ciudad);
        List<FeriaEntity> fs = new LinkedList<>();
        fs.add(feria);
        entity.setFerias(fs);
        List<PabellonEntity> ps = new LinkedList<>();
        ps.add(pabellon);
        entity.setPabellones(ps);
        entity.setCapacidad(entity.getCapacidad() <= 0 ? 100 : entity.getCapacidad());
        
        org.junit.Assert.assertNotNull(logic.createEspacio(entity));
        EspacioEntity r = em.find(EspacioEntity.class, entity.getId());
        org.junit.Assert.assertNotNull(r);
        org.junit.Assert.assertEquals(entity.getNombre(), r.getNombre());
        org.junit.Assert.assertEquals(entity.getCapacidad(), r.getCapacidad());
        try {
            entity = factory.manufacturePojo(EspacioEntity.class);
            entity.setCapacidad(-1);
            entity = logic.createEspacio(entity);
        } catch (Exception e) {
            // Debe Fallar
            try {
                entity = factory.manufacturePojo(EspacioEntity.class);
                entity.setDireccion(null);
                entity = logic.createEspacio(entity);
            } catch (Exception e1) {
                // Debe Fallar
            }
        }
    }
    
    @Test
    public void getEspacios() throws Exception {
        List<EspacioEntity> fs = logic.getEspacios();
        org.junit.Assert.assertEquals(data.size(), fs.size());
        for (EspacioEntity f : fs) {
            org.junit.Assert.assertTrue(data.contains(f));
        }
    }
    
    @Test
    public void getEspacio() throws Exception {
        EspacioEntity f = data.get(0);
        EspacioEntity r = logic.getEspacio(f.getId());
        org.junit.Assert.assertNotNull(r);
        org.junit.Assert.assertEquals(f.getNombre(), r.getNombre());
        org.junit.Assert.assertEquals(f.getCapacidad(), r.getCapacidad());
    }
    
    @Test
    public void updateEspacio() throws Exception {
        EspacioEntity f = data.get(0);
        EspacioEntity uf = factory.manufacturePojo(EspacioEntity.class);
        uf.setId(f.getId());
        uf.setCapacidad(uf.getCapacidad() <= 0 ? 100 : 
                uf.getCapacidad());
        List<PabellonEntity> ps = new LinkedList<>();
        ps.add(pabellon);
        uf.setPabellones(ps);
        logic.updateEspacio(uf);
        EspacioEntity r = em.find(EspacioEntity.class, uf.getId());
        org.junit.Assert.assertNotNull(r);
        org.junit.Assert.assertEquals(uf.getNombre(), r.getNombre());
        org.junit.Assert.assertEquals(uf.getCapacidad(), r.getCapacidad());
    }
    
    @Test
    public void deleteEspacio() throws Exception {
        EspacioEntity f = data.get(0);
        logic.deleteEspacio(f.getId());
        org.junit.Assert.assertNull(em.find(EspacioEntity.class, f.getId()));
    }
    
    //--------------------------------------------------------------------------
    // Métodos de Feria
    //--------------------------------------------------------------------------
    
    /*@Test
    public void getFeria() throws Exception {
        EspacioEntity f = data.get(0);
        FeriaEntity o = logic.getFeria(f.getId(), f.getFerias()
                .get(0).getId());
        org.junit.Assert.assertNotNull(o);
        org.junit.Assert.assertEquals(o.getNombre(), f.getFerias().get(0)
                .getNombre());
        org.junit.Assert.assertEquals(o.getTotalBoletas(), f.getFerias().get(0)
                .getTotalBoletas());
    }
    
    @Test
    public void getFerias() throws Exception {
        EspacioEntity f = data.get(0);
        List<FeriaEntity> os = logic.getFerias(f.getId());
        org.junit.Assert.assertEquals(f.getFerias().size(), os.size());
        org.junit.Assert.assertEquals(f.getFerias().get(0), os.get(0));
    }

    //--------------------------------------------------------------------------
    // Métodos de Pabellon
    //--------------------------------------------------------------------------
    
    @Test
    public void getPabellon() throws Exception {
        EspacioEntity f = data.get(0);
        PabellonEntity o = logic.getPabellon(f.getId(), f.getPabellones()
                .get(0).getId());
        org.junit.Assert.assertNotNull(o);
        org.junit.Assert.assertEquals(o.getCapacidad(), f.getPabellones().get(0)
                .getCapacidad());
        org.junit.Assert.assertEquals(o.getTipo(), f.getPabellones().get(0)
                .getTipo());
    }
    
    @Test
    public void getPabellones() throws Exception {
        EspacioEntity f = data.get(0);
        List<PabellonEntity> os = logic.getPabellones(f.getId());
        org.junit.Assert.assertEquals(f.getPabellones().size(), os.size());
        org.junit.Assert.assertEquals(f.getPabellones().get(0), os.get(0));
    }*/
}
