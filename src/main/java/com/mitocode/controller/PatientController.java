package com.mitocode.controller;

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

import com.mitocode.model.Patient;

import com.mitocode.service.PatientService;


@Controller
@RequestMapping("/pacientes")
public class PatientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpecialtyController.class);

	@Autowired
	private PatientService patientService;

	@GetMapping()
	public String listarPacientes(ModelMap model) {
		model.addAttribute("listaPacientes", patientService.obtenerPatient());
		return "pacientes/listar";
	}
	
	@RequestMapping("/nuevo")
	public String pacientView(Model model) {
		model.addAttribute("patient", new Patient());
		return "pacientes/nuevo";
	}
	
	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("patient") Patient patient, BindingResult result,Model model) {
		patientService.registrar(patient);
		return "redirect:/pacientes";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idPatient, Model model) {
		model.addAttribute("patient", patientService.obtenerPorId(idPatient));
		return "pacientes/editar";
	}
	
	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idPatient, @Validated Patient patient,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			return "pacientes/editar";
		}
		patientService.actualizar(patient);		
		return "redirect:/pacientes";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idPatient) {
		patientService.eliminar(idPatient);
		return "redirect:/especialidades";
	}
}
