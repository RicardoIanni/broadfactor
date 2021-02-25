package br.com.ricardoianni.broadfactor.domain.company;

import lombok.Getter;

@Getter
public enum TipoCNPJ {

	MATRIZ("Matriz"),
	FILIAL("Filial");
	
	private String descricao;

	private TipoCNPJ(String descricao) {
		this.descricao = descricao;
	}

}
