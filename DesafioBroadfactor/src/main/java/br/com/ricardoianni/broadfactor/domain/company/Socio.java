package br.com.ricardoianni.broadfactor.domain.company;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Socio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idSocio;
	
	private String nome;
	
	private String qual;
	
	private String pais_origem;
	
	private String nome_rep_legal;
	
	private String qual_rep_legal;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;

}
