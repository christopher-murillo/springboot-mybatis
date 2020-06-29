package com.mitocode.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.service.EmpleadoService;

@Controller
public class LoginController {

	@Autowired
	private EmpleadoService empleadoService;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam String username, @RequestParam String password, Principal principal) {

//		Empleado empleado = empleadoService.login(username, password);
//
//		if (empleado instanceof Empleado) {
//
//			EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleado);
//
//			model.put("empleado", empleadoDTO);
//
//			return "dashboard";
//		} else {
//			model.put("message", "Credenciales incorrectas");
//			return "login";

		LOGGER.info("user: " + username);
		LOGGER.info("password: " + password);

		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123456")) {
			return "dashboard";
		} else {
			model.put("message", "Credenciales incorrectas");
			return "login";
		}

	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout() {
		return "login";
	}

}
