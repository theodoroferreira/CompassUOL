package com.acme.avaliacaosprint3.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.acme.avaliacaosprint3.controller.dto.AtualizacaoEstadoDTO;
import com.acme.avaliacaosprint3.controller.dto.CadastroEstadoDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private RegiaoEnum regiao;
	private Integer populacao;
	private String capital;
	private Double area;
	
	public Estado(CadastroEstadoDTO dados) {
		this.nome=dados.nome();
		this.regiao=dados.regiao();
		this.populacao=dados.populacao();
		this.capital=dados.capital();
		this.area=dados.area();
	}

	public void atualizarDados(AtualizacaoEstadoDTO dados) {
		if (dados.nome() != null) {
			this.nome=dados.nome();
		}
		if (dados.populacao() != null) {
			this.populacao=dados.populacao();
		}
		if (dados.capital() != null) {
			this.capital=dados.capital();
		}
		if (dados.area() != null) {
			this.area=dados.area();
		}
	}
}
