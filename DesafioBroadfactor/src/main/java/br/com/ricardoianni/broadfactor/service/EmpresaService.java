package br.com.ricardoianni.broadfactor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ricardoianni.broadfactor.domain.company.Atividade;
import br.com.ricardoianni.broadfactor.domain.company.Empresa;
import br.com.ricardoianni.broadfactor.domain.company.Socio;
import br.com.ricardoianni.broadfactor.repository.AtividadeRepository;
import br.com.ricardoianni.broadfactor.repository.EmpresaRepository;
import br.com.ricardoianni.broadfactor.repository.SocioRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private SocioRepository socioRepository;
	
	@Value("${reiceitaws.url}")
	private String endpoint;

	public Empresa buscaDados(String cnpj) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Empresa> response = restTemplate.getForEntity(endpoint + cnpj, Empresa.class);
	
		return response.getBody();
	}
	
	public void saveEmpresa(Empresa empresa) {
		Atividade principal = empresa.getAtividade_principal()[0];
		
		Atividade atividade = atividadeRepository.findByCode(principal.getCode());
		
		if (atividade == null) {
			principal.setPrincipal(List.of(empresa));
			saveAtividade(principal);
		}
		
		List<Atividade> secundarias = empresa.getAtividades_secundarias();
		
		for (Atividade secundaria : secundarias) {
			atividade = atividadeRepository.findByCode(secundaria.getCode());
			
			if (atividade == null) {
				saveAtividade(secundaria);
			}
		}
		
		List<Socio> socios = empresa.getQsa();
		
		for (Socio socio : socios) {
			saveSocio(socio);
		}
		
		empresaRepository.save(empresa);
		
	}
	
	public void saveAtividade(Atividade atividade) {
		atividadeRepository.save(atividade);
	}
	
	public void saveSocio(Socio socio) {
		socioRepository.save(socio);
	}
}
