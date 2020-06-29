package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitocode.model.Empleado;
import com.mitocode.model.Skill;
import com.mitocode.model.Specialty;
import com.mitocode.service.SpecialtyService;

@Controller
@RequestMapping("/especialidades")
public class SpecialtyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpecialtyController.class);

	@Autowired
	private SpecialtyService specialtyService;

	@GetMapping()
	public String listarEspecialidades(ModelMap model) {
		model.addAttribute("listaEspecialidades", specialtyService.obtenerSpecialty());
		return "especialidades/listar";
	}

	@RequestMapping("/nuevo")
	public String specialtyView(Model model) {
		model.addAttribute("specialty", new Specialty());
		return "especialidades/nuevo";
	}

	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("specialty") Specialty specialty, BindingResult result,Model model) {
		specialtyService.registrar(specialty);
		return "redirect:/especialidades";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idSpecialty, Model model) {
		model.addAttribute("specialty", specialtyService.obtenerPorId(idSpecialty));
		return "especialidades/editar";
	}
	
	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idSpecialty, @Validated Specialty specialty,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			return "especialidades/editar";
		}
		specialtyService.actualizar(specialty);		
		return "redirect:/especialidades";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idSpecialty) {
		specialtyService.eliminar(idSpecialty);
		return "redirect:/especialidades";
	}
	

}
