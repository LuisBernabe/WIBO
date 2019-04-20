package com.wibo.core.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wibo.core.model.Jugador;
import com.wibo.core.repo.JugadorRep;


@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private JugadorRep _jugadorRep;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Jugador activeUserInfo = _jugadorRep.findByNombre(userName).get(0);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getEstatus());
		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getNombre(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}