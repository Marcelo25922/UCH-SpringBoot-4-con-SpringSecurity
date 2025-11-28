package com.springboot.models.services;

import com.springboot.models.entitys.Puesto;
import java.util.List;

public interface PuestoService {
	List<Puesto> listar();
	Puesto buscar(Integer id);
}
