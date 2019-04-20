package com.wibo.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.wibo.core.model.Jugador;
import com.wibo.core.repo.JugadorRep;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WiboApplicationTests {
@Autowired
JugadorRep _jugador;
	
	
	@Test
	public void contextLoads() {
	
		Jugador jugador=new Jugador();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        jugador.setPassword(passwordEncoder.encode("hola"));       
        jugador.setNombre("franki4");
        jugador.setEstatus("Activo");
        _jugador.save(jugador);
	}
	

}
