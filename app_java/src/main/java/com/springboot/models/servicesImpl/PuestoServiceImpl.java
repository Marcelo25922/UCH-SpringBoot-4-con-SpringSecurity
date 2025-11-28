package com.springboot.models.servicesImpl;

import com.springboot.models.entitys.Puesto;
import com.springboot.models.repository.PuestoRepository;
import com.springboot.models.services.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuestoServiceImpl implements PuestoService {
	
	@Autowired
	private PuestoRepository repositorio;
	
	@Override
	public List<Puesto> listar() {
		return repositorio.findAll();
	}
	
	@Override
	public Puesto buscar(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
}
