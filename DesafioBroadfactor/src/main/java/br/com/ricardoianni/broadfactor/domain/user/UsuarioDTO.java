package br.com.ricardoianni.broadfactor.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	private String nome;
	
	private String email;
	
	private String senha;
	
	private String cnpj;
	
}
