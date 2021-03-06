/*
 * The MIT License
 *
 * Copyright 2017 d.narvaez11.
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
package co.edu.uniandes.csw.artesanias.dtos;

import co.edu.uniandes.csw.artesanias.entities.ArtesanoEntity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) basica que representa un Artesano
 *
 * @author d.narvaez11
 * @see ArtesanoEntity
 */
@XmlRootElement
public class ArtesanoDTO implements Serializable
{
	/**
	 * Identificador único de una instancia de Artesano
	 */
	private Long id;
	
	/**
	 * Nombre del Artesano
	 */
	private String nombre;
	
	/**
	 * Identificación del Artesano
	 */
	private String identificacion;
	
	/**
	 * Telefono del Artesano
	 */
	private String telefono;
	
	/**
	 * Imagen del Artesano
	 */
	private String image;
	
	/**
	 * Builds an empty ArtesanoDTO
	 */
	public ArtesanoDTO( )
	{
		// Default Constructor. Mandatory
	}
	
	/**
	 * Builds an ArtesanoDTO by the fields from the ArtesanoEntity given
	 *
	 * @param entity ArtesanoEntity to fill up the ArtesanoDTO
	 */
	public ArtesanoDTO( ArtesanoEntity entity )
	{
		if( entity != null )
		{
			this.id = entity.getId( );
			this.nombre = entity.getNombre( );
			this.identificacion = entity.getIdentificacion( );
			this.telefono = entity.getTelefono( );
			this.image = entity.getImage( );
		}
	}
	
	/**
	 * Retrieves an ArtesanoEntity with the fields of this ArtesanoDTO
	 */
	public ArtesanoEntity toEntity( )
	{
		ArtesanoEntity entity = new ArtesanoEntity( );
		entity.setId( this.id );
		entity.setNombre( this.nombre );
		entity.setIdentificacion( this.identificacion );
		entity.setTelefono( this.telefono );
		entity.setImage( this.image );
		return entity;
	}
	
	/**
	 * Retrieves the image of the ArtesanoDTO
	 *
	 * @return The image of the ArtesanoDTO
	 */
	public String getImage( )
	{
		return image;
	}
	
	/**
	 * Updates the image of the ArtesanoDTO by the one given by parameter
	 *
	 * @param image The new image of the ArtesanoDTO
	 */
	public void setImage( String image )
	{
		this.image = image;
	}
	
	/**
	 * Retrieves the id of the ArtesanoDTO
	 *
	 * @return The id of the ArtesanoDTO
	 */
	public Long getId( )
	{
		return id;
	}
	
	/**
	 * Updates the id of the ArtesanoDTO by the one given by parameter
	 *
	 * @param id The new id of the ArtesanoDTO
	 */
	public void setId( Long id )
	{
		this.id = id;
	}
	
	/**
	 * Retrieves the nombre of the ArtesanoDTO
	 *
	 * @return The nombre of the ArtesanoDTO
	 */
	public String getNombre( )
	{
		return nombre;
	}
	
	/**
	 * Updates the nombre of the ArtesanoDTO by the one given by parameter
	 *
	 * @param nombre The new nombre of the ArtesanoDTO
	 */
	public void setNombre( String nombre )
	{
		this.nombre = nombre;
	}
	
	/**
	 * Retrieves the identificacion of the ArtesanoDTO
	 *
	 * @return The identificacion of the ArtesanoDTO
	 */
	public String getIdentificacion( )
	{
		return identificacion;
	}
	
	/**
	 * Updates the identificacion of the ArtesanoDTO by the one given by parameter
	 *
	 * @param identificacion The new identificacion of the ArtesanoDTO
	 */
	public void setIdentificacion( String identificacion )
	{
		this.identificacion = identificacion;
	}
	
	/**
	 * Retrieves the telefono of the ArtesanoDTO
	 *
	 * @return The telefono of the ArtesanoDTO
	 */
	public String getTelefono( )
	{
		return telefono;
	}
	
	/**
	 * Updates the telefono of the ArtesanoDTO by the one given by parameter
	 *
	 * @param telefono The new telefono of the ArtesanoDTO
	 */
	public void setTelefono( String telefono )
	{
		this.telefono = telefono;
	}
}