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
public class Salario implements Serializable{
	
	private Long Id;
	private double Sueldo;	
	private String nombreUsuario;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	
	public Salario(Long id, double sueldo, String nombreUsuario) {
		Id = id;
		Sueldo = sueldo;
		this.nombreUsuario = nombreUsuario;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Salario [Id=");
		builder.append(Id);
		builder.append(", Sueldo=");
		builder.append(Sueldo);
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
		Salario other = (Salario) obj;
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

	private static final long serialVersionUID = 8673003668901994317L;

}
