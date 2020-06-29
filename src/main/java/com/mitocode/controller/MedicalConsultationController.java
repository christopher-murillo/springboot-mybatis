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
import com.mitocode.model.MedicalConsultation;
import com.mitocode.service.DoctorService;
import com.mitocode.service.MedicalConsultationService;
import com.mitocode.service.PatientService;

@Controller
@RequestMapping("/consultamedicas")
public class MedicalConsultationController {

	@Autowired
	private MedicalConsultationService medicalConsultationService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;

	@GetMapping()
	public String listarPacientes(ModelMap model) {
		model.addAttribute("listaConsultaMedicas", medicalConsultationService.obtenerMedicalConsultation());
		return "consultamedicas/listar";
	}
	
	@GetMapping("/nuevo")
	public String ConsultaMedicasView(Model model) {
		model.addAttribute("medicalConsultation", new MedicalConsultation());
		model.addAttribute("listaDoctor", doctorService.obtenerDoctor());
		model.addAttribute("listaPatient", patientService.obtenerPatient());
		return "consultamedicas/nuevo";
	}
	
	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("medicalConsultation") MedicalConsultation medicalConsultation, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("listaDoctor", doctorService.obtenerDoctor());
			model.addAttribute("listaPatient", patientService.obtenerPatient());
			return "consultamedicas/nuevo";
		}

		medicalConsultationService.registrar(medicalConsultation);

		return "redirect:/consultamedicas";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idMedicalConsultation, Model model) {
		model.addAttribute("medicalConsultation", medicalConsultationService.obtenerPorId(idMedicalConsultation));
		model.addAttribute("listaDoctor", doctorService.obtenerDoctor());
		model.addAttribute("listaPatient", patientService.obtenerPatient());
		return "consultamedicas/editar";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idMedicalConsultation, @Validated MedicalConsultation medicalConsultation,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("listaDoctor", doctorService.obtenerDoctor());
			model.addAttribute("listaPatient", patientService.obtenerPatient());
			return "consultamedicas/editar";
		}
		
		medicalConsultationService.actualizar(medicalConsultation);
		
		return "redirect:/consultamedicas";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idMedicalConsultation) {
		medicalConsultationService.eliminar(idMedicalConsultation);
		return "redirect:/consultamedicas";
	}
	
}
