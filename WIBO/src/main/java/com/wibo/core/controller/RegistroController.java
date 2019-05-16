package com.wibo.core.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wibo.core.model.Jugador;
import com.wibo.core.repo.JugadorRep;

@Controller
public class RegistroController {
	@Autowired
	JugadorRep _jugador;
	


	
	@GetMapping("/algoraropasa")
	public String inicio() {
		return "index";
	}

	@PostMapping("/registraUsuario")
	public String registraUsuario(@RequestParam (name = "username") String nombre,
													@RequestParam(name = "password") String pass,
													@RequestParam (name = "inlineRadioOptions") String genero) {
		
		Jugador nuevo=new Jugador();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		nuevo.setPassword(passwordEncoder.encode(pass));
		nuevo.setEstatus("Activo");
		nuevo.setPower(0);
		nuevo.setNombre(nombre);
		nuevo.setGenero(genero);
		
		_jugador.save(nuevo);

		return "login";
	}

	@RequestMapping(value = {"/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout, HttpServletRequest request) {

		
		if (error != null) {
			model.addAttribute("errorMsg", "Your username or password are invalid.");
			System.out.println(error);
			System.out.println("\nUsuario erroneo-");
		}else {
			System.out.println("\nUsuario logeado-");
		}

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}
		return "login";
	}

	@RequestMapping(value = "/hola", method = RequestMethod.GET)
	public String exampleTableBasic(Model model) {
		return "juego/menuprincipal";
	}
	
	@GetMapping("prueba")
	private String prueba() {
		return "juego";

	}
	
	

}