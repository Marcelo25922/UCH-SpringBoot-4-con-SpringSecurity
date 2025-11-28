package com.springboot.models.entitys;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Rol> roles;
	
	// Getters y Setters
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Rol> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
