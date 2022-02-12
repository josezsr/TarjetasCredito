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
public class Edad implements Serializable{

	private Long Id;
	private Integer Edad;
	private String nombreUsuario;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	
	
	public Edad(Long id, Integer edad, String nombreUsuario) {
		Id = id;
		Edad = edad;
		this.nombreUsuario = nombreUsuario;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Edad [Id=");
		builder.append(Id);
		builder.append(", Edad=");
		builder.append(Edad);
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
		return Objects.hash(Id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edad other = (Edad) obj;
		return Objects.equals(Id, other.Id);
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


	private static final long serialVersionUID = 5700419685139401129L;

}
