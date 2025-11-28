package com.springboot.models.services;

import com.springboot.models.entitys.Postulante;
import java.util.List;

public interface PostulanteService {
	List<Postulante> listar();
	Postulante buscar(Integer id);
	void guardar(Postulante postulante);
	void eliminar(Integer id);
}
