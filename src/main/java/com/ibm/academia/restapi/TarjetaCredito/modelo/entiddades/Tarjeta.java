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
public class Tarjeta implements Serializable {
		
	private Long id;
	private String numeroSerie;
	private String nombreUsuario;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	
	public Tarjeta(Long id, String numeroSerie, String nombreUsuario) {
		this.id = id;
		this.numeroSerie = numeroSerie;
		this.nombreUsuario = nombreUsuario;
	}


	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tarjeta [id=");
		builder.append(id);
		builder.append(", numeroSerie=");
		builder.append(numeroSerie);
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
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(id, other.id);
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



	private static final long serialVersionUID = 786761862696140253L;
	
	

}
