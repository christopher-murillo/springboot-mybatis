package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.service.DetailConsultationService;


@Controller
@RequestMapping("/detalleconsulta")
public class DetailConsultationController {
	
	@Autowired
	private DetailConsultationService detailConsultationService;
	
	@GetMapping()
	public String listarPacientes(ModelMap model) {
		model.addAttribute("listaDetalleConsulta", detailConsultationService.obtenerDetailConsultation());
		return "detalleconsulta/listar";
	}

}
