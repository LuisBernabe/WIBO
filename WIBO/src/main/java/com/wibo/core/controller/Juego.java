package com.wibo.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/logeado")
public class Juego {
	@GetMapping(value = "aventuras")
	public String aventuras() {
		return "juego/aventuras";
	}
	@GetMapping(value = "menuaventuras")
	public String menuaventuras() {
		return "juego/menuaventuras";
	}
	@GetMapping (value = "/coleccion")
	private String coleccion() {

		return "juego/coleccion";

	}
	
	@GetMapping(value = "juego")
	private String cocina() {
		return "juego";
	}

	
	
	
	//si se quiere hacer referencia en js como en aventuras.js por esto
    //window.location =  "/logeado/menuaventuras";
	//Clonar este metodo con distinto nombre, y cuando se quiere hacer referencia a un archivo html cambiar hrref por
	//th:href="@{/logeado/archivogenerico}"   y cambiar archivogenerico 
	@GetMapping(value = "archivogenerico")//<-aqui
	private String metodoGenerico() {
		return "archivogenerico"; // <- y aqui, donde esta el archivo a partir de la carpeta templates aqui este archivo deberia de estar en la raiz de la carpeta templates
	}
}
