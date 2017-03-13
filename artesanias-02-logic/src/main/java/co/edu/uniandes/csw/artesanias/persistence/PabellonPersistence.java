/*
 * The MIT License
 *
 * Copyright 2017 ja.espinosa12.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.csw.artesanias.persistence;

import co.edu.uniandes.csw.artesanias.entities.PabellonEntity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author ja.espinosa12
 */
@Stateless
public class PabellonPersistence
{
	@PersistenceContext( unitName = "artesaniasPU" )
	protected EntityManager em;
	
	public PabellonEntity find( Long id )
	{
		return em.find( PabellonEntity.class, id );
	}
	
	public List<PabellonEntity> findAll( )
	{
		TypedQuery<PabellonEntity> q = em.createQuery( "select u from PabellonEntity u", PabellonEntity.class );
		List<PabellonEntity> pabellones = q.getResultList( );
		return pabellones;
	}
	
	public PabellonEntity create( PabellonEntity entity )
	{
		em.persist( entity );
		return entity;
	}
	
	public PabellonEntity update( PabellonEntity entity )
	{
		return em.merge( entity );
	}
	
	public void delete( Long id )
	{
		PabellonEntity entity = em.find( PabellonEntity.class, id );
		em.remove( entity );
	}
}