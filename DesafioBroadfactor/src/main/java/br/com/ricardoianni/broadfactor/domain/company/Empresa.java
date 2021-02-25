package br.com.ricardoianni.broadfactor.domain.company;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ricardoianni.broadfactor.domain.user.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpresa;

	@OneToMany(mappedBy = "empresa")
	private List<Usuario> usuarios = new ArrayList<>(0);
	
	private String cnpj;
	
	private TipoCNPJ tipo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate abertura;
	
	private String nome;
	
	private String fantasia;
	
	private String porte;
	
	@ManyToOne
	@JoinColumn(name = "idAtividade")
	private Atividade[] atividade_principal = new Atividade[1];
	
	@ManyToMany
	@JoinTable(	name = "atividade_empresa",
				joinColumns = @JoinColumn(name = "idEmpresa"),
				inverseJoinColumns = @JoinColumn(name = "idAtividade") )
	private List<Atividade> atividades_secundarias = new ArrayList<>(0);
	
	private String natureza_juridica;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String municipio;
	
	private String uf;
	
	private String cep;
	
	private String email;
	
	private String telefone;
	
	private String efr;
	
	private String situacao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime ultima_atualizacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_situacao;
	
	private String motivo_situacao;
	
	private String situacao_especial;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_situacao_especial;
	
	private BigDecimal capital_social;

	@OneToMany(mappedBy = "empresa")
	private List<Socio> qsa = new ArrayList<>(0);
	
}
