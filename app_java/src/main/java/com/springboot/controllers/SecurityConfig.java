package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return (HttpServletRequest request, HttpServletResponse response, 
				org.springframework.security.access.AccessDeniedException accessDeniedException) -> {
			response.sendRedirect(request.getContextPath() + "/errores/403");
		};
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/nuevo", "/guardar").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/editar/**").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/borrar/**").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/", "/listar").hasAnyRole("USER", "MANAGER", "ADMIN")
				.requestMatchers("/login", "/errores/**", "/css/**", "/js/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/listar", true)
				.permitAll()
			)
			.logout(logout -> logout
				.permitAll()
			)
			.exceptionHandling(exception -> exception
				.accessDeniedHandler(accessDeniedHandler())
			);
		
		return http.build();
	}
}
