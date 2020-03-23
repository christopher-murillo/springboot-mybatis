package com.mitocode.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.dto.EmpleadoDTO;
import com.mitocode.model.Empleado;
import com.mitocode.service.EmpleadoService;

@Controller
public class LoginController {

	@Autowired
	private EmpleadoService empleadoService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginForm(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam String username, @RequestParam String password, Principal principal) {

		Empleado empleado = empleadoService.login(username, password);

		if (empleado instanceof Empleado) {

			EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleado);

			model.put("empleado", empleadoDTO);

			return "dashboard";
		} else {
			model.put("message", "Credenciales incorrectas");
			return "login";
		}

	}

}
