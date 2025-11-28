package com.springboot.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "postulante")
public class Postulante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_postulante")
	private Integer idPostulante;
	
	private String nombres;
	private String apellidos;
	private String direccion;
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "id_puesto")
	private Puesto puesto;
	
	// Getters y Setters
	public Integer getIdPostulante() {
		return idPostulante;
	}
	
	public void setIdPostulante(Integer idPostulante) {
		this.idPostulante = idPostulante;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Puesto getPuesto() {
		return puesto;
	}
	
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
}
