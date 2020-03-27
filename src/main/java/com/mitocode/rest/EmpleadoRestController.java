package com.mitocode.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Empleado;
import com.mitocode.model.Skill;
import com.mitocode.service.EmpleadoService;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	List<Empleado> listarEmpleados() {
		return empleadoService.obtenerEmpleados();
	}

	@PostMapping
	ResponseEntity<Integer> crear(@RequestBody Empleado empleado) {
		List<Skill> skills = empleado.getSkills().stream().map(s -> {
			return new Skill(s.getDescripcion(), empleado);
		}).collect(Collectors.toList());
		empleado.setSkills(skills);
		return ResponseEntity.ok(empleadoService.registrar(empleado, null));
	}

	@GetMapping("/{id}")
	Empleado one(@PathVariable(value = "id") Integer idEmpleado) {
		return empleadoService.obtenerPorId(idEmpleado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Integer> actualizar(@PathVariable(value = "id") Integer idEmpleado,
			@RequestBody Empleado empleado) {
		empleado.setIdEmpleado(idEmpleado);
		List<Skill> skills = new ArrayList<>();
		if (empleado.getSkills() != null) {
			skills = empleado.getSkills().stream().map(s -> {
				return new Skill(s.getDescripcion(), empleado);
			}).collect(Collectors.toList());
			empleado.setSkills(skills);
		}
		return ResponseEntity.ok(empleadoService.registrar(empleado, skills));
	}

	@DeleteMapping("/{id}")
	void eliminar(@PathVariable(value = "id") Integer idEmpleado) {
		empleadoService.eliminar(idEmpleado);
	}
}
