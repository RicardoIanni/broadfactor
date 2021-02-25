package br.com.ricardoianni.broadfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.broadfactor.domain.company.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

	public Atividade findByCode(String code);
	
}
