package co.edu.uniandes.csw.artesanias.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @author ia.salazar
 */
@Entity
public class SalonEntity implements Serializable
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private Integer numero;
	
	private Integer capacidad;
	
        @PodamExclude
	@OneToMany( targetEntity = ConferenciaEntity.class, fetch = FetchType.LAZY )
	private List<ConferenciaEntity> conferencias;
	
        @PodamExclude
	@ManyToOne( targetEntity = PabellonEntity.class, fetch = FetchType.LAZY )
	private PabellonEntity pabellon;
	
	public void setId( Long id )
	{
		this.id = id;
	}
	
	public void setNumero( Integer numero )
	{
		this.numero = numero;
	}
	
	public void setCapacidad( Integer capacidad )
	{
		this.capacidad = capacidad;
	}
	
	public void setConferencia( List<ConferenciaEntity> conferencias )
	{
		this.conferencias = conferencias;
	}
	
	public void setPabellon( PabellonEntity pabellon )
	{
		this.pabellon = pabellon;
	}
	
	public Long getId( )
	{
		return id;
	}
	
	public Integer getNumero( )
	{
		return numero;
	}
	
	public Integer getCapacidad( )
	{
		return capacidad;
	}
	
	public List<ConferenciaEntity> getConferencia( )
	{
		return conferencias;
	}
	
	public PabellonEntity getPabellon( )
	{
		return pabellon;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		if( this.getId( ) != null )
		{
			
			return this.getId( ).equals( ( ( SalonEntity ) obj ).getId( ) );
			
		}
		return super.equals( obj );
	}
	
	public int hashCode( )
	{
		if( this.getId( ) != null )
		{
			return this.getId( ).hashCode( );
		}
		return super.hashCode( );
	}
}