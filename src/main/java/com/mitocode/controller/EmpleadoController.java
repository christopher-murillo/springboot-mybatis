package com.mitocode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitocode.model.Empleado;
import com.mitocode.service.EmpleadoService;
import com.mitocode.service.TipoEmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoController.class);

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;

	@GetMapping()
	public String listarEmpleados(Model model) {
		model.addAttribute("listaEmpleados", empleadoService.obtenerEmpleados());
		return "empleados/listar";
	}

	@GetMapping("/nuevo")
	public String empleadoView(Model model) {

		model.addAttribute("empleado", new Empleado());
		model.addAttribute("listaTipos", tipoEmpleadoService.obtenerTipos());

		return "empleados/nuevo";
	}

	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("empleado") Empleado empleado, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("listaTipos", tipoEmpleadoService.obtenerTipos());
			return "/empleados/nuevo";
		}
		empleadoService.registrar(empleado);

		return "redirect:/empleados";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idEmpleado, Model model) {
		model.addAttribute("empleado", empleadoService.obtenerPorId(idEmpleado));
		model.addAttribute("listaTipos", tipoEmpleadoService.obtenerTipos());
		return "empleados/editar";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idEmpleado, @Validated Empleado empleado,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("listaTipos", tipoEmpleadoService.obtenerTipos());
			return "empleados/editar";
		}
		empleadoService.actualizar(empleado);
		return "redirect:/empleados";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idEmpleado) {
		empleadoService.eliminar(idEmpleado);
		return "redirect:/empleados";
	}
}
