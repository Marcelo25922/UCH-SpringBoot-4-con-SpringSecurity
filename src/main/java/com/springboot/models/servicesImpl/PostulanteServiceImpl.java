package com.springboot.models.servicesImpl;

import com.springboot.models.entitys.Postulante;
import com.springboot.models.repository.PostulanteRepository;
import com.springboot.models.services.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostulanteServiceImpl implements PostulanteService {
	
	@Autowired
	private PostulanteRepository repositorio;
	
	@Override
	@Transactional
	public List<Postulante> listar() {
		return repositorio.verPostulantes();
	}
	
	@Override
	@Transactional
	public Postulante buscar(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void guardar(Postulante postulante) {
		repositorio.save(postulante);
	}
	
	@Override
	@Transactional
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}
}
