package br.com.ricardoianni.broadfactor.domain.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ricardoianni.broadfactor.domain.company.Empresa;
import br.com.ricardoianni.broadfactor.util.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;
	
	public void encryptPassword() {
		senha = StringUtils.encrypt(senha);
	}

}
