package br.com.ricardoianni.broadfactor.domain.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atividade implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idAtividade;
	
	private String code;
	
	private String text;
	
	@OneToMany(mappedBy = "atividade_principal")
	private List<Empresa> principal = new ArrayList<>(0);

	@ManyToMany(mappedBy = "atividades_secundarias")
	private List<Empresa> secundarias = new ArrayList<>(0);
}
