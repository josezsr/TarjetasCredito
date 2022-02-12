package com.ibm.academia.restapi.TarjetaCredito.modelo.entiddades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class Persona implements Serializable{

	private Long Id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String sueldo;
	private String nombreUsuario;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	
	public Persona(Long id, String nombre, String apellido, Integer edad, String sueldo, String nombreUsuario) {
		Id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sueldo = sueldo;
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [Id=");
		builder.append(Id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", edad=");
		builder.append(edad);
		builder.append(", sueldo=");
		builder.append(sueldo);
		builder.append(", nombreUsuario=");
		builder.append(nombreUsuario);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(nombre, other.nombre);
	}

	@PrePersist
	private void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}
	
	@PreUpdate
	private void antesActualizar ()
	{
		 this.fechaModificacion = new Date();
	}


	private static final long serialVersionUID = -4017208301681729568L;

}
