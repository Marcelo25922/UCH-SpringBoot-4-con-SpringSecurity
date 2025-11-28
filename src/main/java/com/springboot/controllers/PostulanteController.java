package com.springboot.controllers;

import com.springboot.models.entitys.Postulante;
import com.springboot.models.services.PostulanteService;
import com.springboot.models.services.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostulanteController {
	
	@Autowired
	private PostulanteService postulanteService;
	
	@Autowired
	private PuestoService puestoService;
	
	@GetMapping({"/", "/listar"})
	public String listar(Model model) {
		model.addAttribute("postulantes", postulanteService.listar());
		return "listar";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Postulante postulante = new Postulante();
		model.addAttribute("postulante", postulante);
		model.addAttribute("puestos", puestoService.listar());
		return "nuevo";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Postulante postulante) {
		postulanteService.guardar(postulante);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Postulante postulante = postulanteService.buscar(id);
		model.addAttribute("postulante", postulante);
		model.addAttribute("puestos", puestoService.listar());
		return "nuevo";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable Integer id) {
		postulanteService.eliminar(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/errores/403")
	public String error403() {
		return "errores/403";
	}
}
