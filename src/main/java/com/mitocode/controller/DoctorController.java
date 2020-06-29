package com.mitocode.controller;

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

import com.mitocode.model.Doctor;
import com.mitocode.service.DoctorService;
import com.mitocode.service.SpecialtyService;

@Controller
@RequestMapping("/medicos")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private SpecialtyService specialtyService;

	@GetMapping()
	public String listarPacientes(ModelMap model) {
		model.addAttribute("listaMedicos", doctorService.obtenerDoctor());
		return "medicos/listar";
	}
	
	@GetMapping("/nuevo")
	public String DoctorView(Model model) {
		model.addAttribute("doctor", new Doctor());
		model.addAttribute("listaEspecialidades", specialtyService.obtenerSpecialty());
		return "medicos/nuevo";
	}
	
	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("doctor") Doctor doctor, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("listaEspecialidades", specialtyService.obtenerSpecialty());
			return "especialidades/nuevo";
		}

		doctorService.registrar(doctor);

		return "redirect:/medicos";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idDoctor, Model model) {
		model.addAttribute("doctor", doctorService.obtenerPorId(idDoctor));
		model.addAttribute("listaEspecialidades", specialtyService.obtenerSpecialty());
		return "medicos/editar";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idDoctor, @Validated Doctor doctor,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("listaEspecialidades", specialtyService.obtenerSpecialty());
			return "medicos/editar";
		}
		
		doctorService.actualizar(doctor);
		
		return "redirect:/medicos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idDoctor) {
		doctorService.eliminar(idDoctor);
		return "redirect:/medicos";
	}
}
