package br.com.ricardoianni.broadfactor.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.ricardoianni.broadfactor.util.SecurityUtils;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Role role = SecurityUtils.loggedUser().getRole();
		
		if (role == Role.USUARIO) {
			response.sendRedirect("usuario/");
		
		} else {
			throw new IllegalStateException("Erro na autenticação");
	
		}
		
	}
	
}
