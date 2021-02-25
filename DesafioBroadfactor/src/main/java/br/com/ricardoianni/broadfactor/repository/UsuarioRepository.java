package br.com.ricardoianni.broadfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.broadfactor.domain.user.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
	
}
