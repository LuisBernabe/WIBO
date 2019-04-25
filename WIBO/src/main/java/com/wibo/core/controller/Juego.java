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
}
