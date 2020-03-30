package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitocode.model.Empleado;
import com.mitocode.model.Skill;
import com.mitocode.service.EmpleadoService;
import com.mitocode.service.TipoEmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;

	@ModelAttribute("module")
    String module() {
        return "empleados";
    }
	
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
			return "empleados/nuevo";
		}

//		List<Skill> skills = empleado.getSkills();
//		empleadoService.registrar(empleado, skills);
		
		List<Skill> skills = new ArrayList<>();
		if (empleado.getSkills() != null) {
			skills = empleado.getSkills().stream().map(s -> {
				return new Skill(s.getDescripcion(), empleado);
			}).collect(Collectors.toList());
			empleado.setSkills(skills);
		}
		empleadoService.registrar(empleado, skills);


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
//		List<Skill> skills = new ArrayList<>();
//		if (empleado.getSkills() != null) {
//			skills = empleado.getSkills();
//		}
		
		List<Skill> skills = new ArrayList<>();
		if (empleado.getSkills() != null) {
			skills = empleado.getSkills().stream().map(s -> {
				return new Skill(s.getDescripcion(), empleado);
			}).collect(Collectors.toList());
			empleado.setSkills(skills);
		}
		empleadoService.actualizar(empleado, skills);
		return "redirect:/empleados";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idEmpleado) {
		empleadoService.eliminar(idEmpleado);
		return "redirect:/empleados";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {

		CustomCollectionEditor skillsCollector = new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				if (element instanceof String) {
//					Integer id = Integer.parseInt((String) element);
					String selectValue = (String) element;

					Skill skill = new Skill();
					skill.setDescripcion(selectValue);
					return skill;
				}
				throw new RuntimeException("InitBinder error in element: " + element);
			}
		};

		binder.registerCustomEditor(List.class, "skills", skillsCollector);
	}

}
