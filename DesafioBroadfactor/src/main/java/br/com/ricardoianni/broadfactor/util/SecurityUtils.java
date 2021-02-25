package br.com.ricardoianni.broadfactor.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ricardoianni.broadfactor.security.LoggedUser;

public class SecurityUtils {
	
	private SecurityUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static LoggedUser loggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication instanceof AnonymousAuthenticationToken) {
			return null;
		}
		
		return (LoggedUser) authentication.getPrincipal();
	}

}
