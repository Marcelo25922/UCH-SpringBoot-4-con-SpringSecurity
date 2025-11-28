package com.springboot.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "puesto")
public class Puesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_puesto")
	private Integer idPuesto;
	
	@Column(name = "nombre_puesto")
	private String nombrePuesto;
	
	// Getters y Setters
	public Integer getIdPuesto() {
		return idPuesto;
	}
	
	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}
	
	public String getNombrePuesto() {
		return nombrePuesto;
	}
	
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
}
