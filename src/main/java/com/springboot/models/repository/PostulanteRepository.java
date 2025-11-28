package com.springboot.models.repository;

import com.springboot.models.entitys.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante, Integer> {
	
	@Procedure(name = "SP_VER_POSTULANTES")
	List<Postulante> verPostulantes();
}
