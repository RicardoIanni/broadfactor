package br.com.ricardoianni.broadfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.broadfactor.domain.company.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	public Empresa findByCnpj(String cnpj);

}
