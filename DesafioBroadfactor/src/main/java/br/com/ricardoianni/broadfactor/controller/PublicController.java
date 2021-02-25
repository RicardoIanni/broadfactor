package br.com.ricardoianni.broadfactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ricardoianni.broadfactor.domain.company.Empresa;
import br.com.ricardoianni.broadfactor.domain.user.Usuario;
import br.com.ricardoianni.broadfactor.domain.user.UsuarioDTO;
import br.com.ricardoianni.broadfactor.repository.UsuarioRepository;
import br.com.ricardoianni.broadfactor.service.EmpresaService;
import br.com.ricardoianni.broadfactor.service.UsuarioService;

@Controller
@RequestMapping(path = "/public")
public class PublicController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(path = "/incluir")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new UsuarioDTO());
		
		return "incluir";
	}
	
	@PostMapping(path = "/save")
	public String saveUsuario(@ModelAttribute("usuario") UsuarioDTO usuarioDTO,
								Model model) {
		
		
		Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
				
		if (usuario != null) {
			model.addAttribute("msg", "E-mail já cadastrado");
			
			return "incluir";
			
		} else {
			usuario = new Usuario();
		
		}
		
		Empresa empresa = empresaService.buscaDados(usuarioDTO.getCnpj());
		
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setEmpresa(empresa);
		usuario.setNome(usuarioDTO.getNome());
		usuario.setSenha(usuarioDTO.getSenha());
		
		usuarioService.save(usuario);
		
		model.addAttribute("msg", "Usuário cadastrado com sucesso");
		
		return "login";
	}

}