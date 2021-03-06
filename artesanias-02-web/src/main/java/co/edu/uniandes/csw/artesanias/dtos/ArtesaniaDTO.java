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

import co.edu.uniandes.csw.artesanias.entities.ArtesaniaEntity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) basica que representa una Artesania
 *
 * @author d.narvaez11
 * @see ArtesaniaEntity
 */
@XmlRootElement
public class ArtesaniaDTO implements Serializable
{
	/**
	 * Identificador único de cada instancia de Artesania
	 */
	private Long id;
	
	/**
	 * Nomrbe de la Artesnia
	 */
	private String nombre;
	
	/**
	 * Descripcion de la Artesania
	 */
	private String imagen;
	
	/**
	 * Builds and empty ArtesaniaDTO
	 */
	public ArtesaniaDTO( )
	{
		// Default Constructor. Mandatory
	}
	
	/**
	 * Builds an ArtesaniaDTO by the fields from the ArtesaniaEntity given
	 *
	 * @param entity ArtesaniaEntity to fill up the ArtesaniaDTO
	 */
	public ArtesaniaDTO( ArtesaniaEntity entity )
	{
		if( entity != null )
		{
			this.id = entity.getId( );
			this.nombre = entity.getNombre( );
			this.imagen = entity.getImagen( );
		}
	}
	
	/**
	 * Retrieves an ArtesaniaEntity with the fields of this ArtesaniaDTO
	 */
	public ArtesaniaEntity toEntity( )
	{
		ArtesaniaEntity entity = new ArtesaniaEntity( );
		entity.setId( this.id );
		entity.setNombre( this.nombre );
		entity.setImagen( this.imagen );
		return entity;
	}
	
	/**
	 * Retrieves the id of the ArtesaniaDTO
	 *
	 * @return The id of the ArtesaniaDTO
	 */
	public Long getId( )
	{
		return id;
	}
	
	/**
	 * Updates the id of the ArtesaniaDTO by the one given by parameter
	 *
	 * @param id The new id of the ArtesaniaDTO
	 */
	public void setId( Long id )
	{
		this.id = id;
	}
	
	/**
	 * Retrieves the nombre of the ArtesaniaDTO
	 *
	 * @return The nombre of the ArtesaniaDTO
	 */
	public String getNombre( )
	{
		return nombre;
	}
	
	/**
	 * Updates the nombre of the ArtesaniaDTO by the one given by parameter
	 *
	 * @param nombre The new nombre of the ArtesaniaDTO
	 */
	public void setNombre( String nombre )
	{
		this.nombre = nombre;
	}
	
	/**
	 * Retrieves the descripcion of the ArtesaniaDTO
	 *
	 * @return The descripcion of the ArtesaniaDTO
	 */
	public String getImagen( )
	{
		return imagen;
	}
	
	/**
	 * Updates the descripcion of the ArtesaniaDTO by the one given by parameter
	 *
	 * @param imagen The new descripcion of the ArtesaniaDTO
	 */
	public void setImagen( String imagen )
	{
		this.imagen = imagen;
	}
}