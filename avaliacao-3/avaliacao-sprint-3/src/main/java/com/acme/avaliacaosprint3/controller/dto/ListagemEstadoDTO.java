package com.acme.avaliacaosprint3.controller.dto;

import com.acme.avaliacaosprint3.modelo.Estado;
import com.acme.avaliacaosprint3.modelo.RegiaoEnum;

public record ListagemEstadoDTO(Integer id, String nome, RegiaoEnum regiao, Integer populacao, String capital, Double area) {
	
	public ListagemEstadoDTO(Estado estado) {
		this(estado.getId(), estado.getNome(), estado.getRegiao(), estado.getPopulacao(), estado.getCapital(), estado.getArea());
	}
}

