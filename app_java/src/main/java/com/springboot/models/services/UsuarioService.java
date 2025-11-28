package com.springboot.models.services;

import com.springboot.models.entitys.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.models.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		usuario.getRoles().forEach(rol -> {
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		return new User(usuario.getUsername(), usuario.getPassword(), authorities);
	}
}
