package br.com.ricardoianni.broadfactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoianni.broadfactor.domain.company.Empresa;
import br.com.ricardoianni.broadfactor.domain.user.Usuario;
import br.com.ricardoianni.broadfactor.repository.EmpresaRepository;
import br.com.ricardoianni.broadfactor.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;

	public void save(Usuario usuario) {
		usuario.encryptPassword();
		
		Empresa empresa = empresaRepository.findByCnpj(usuario.getEmpresa().getCnpj());
		
		if ( empresa == null ) {
			empresaService.saveEmpresa(usuario.getEmpresa());
		}
		
		usuarioRepository.save(usuario);
	}
}
