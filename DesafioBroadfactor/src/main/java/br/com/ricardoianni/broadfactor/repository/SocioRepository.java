package br.com.ricardoianni.broadfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.broadfactor.domain.company.Socio;

public interface SocioRepository extends JpaRepository<Socio, Integer> {

}
