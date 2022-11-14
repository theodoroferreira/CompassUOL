package com.acme.avaliacaosprint3.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.acme.avaliacaosprint3.modelo.RegiaoEnum;

public record CadastroEstadoDTO(
		
		@NotBlank
		String nome, 
		
		@NotNull
		RegiaoEnum regiao, 
		
		@NotNull
		Integer populacao, 
		
		@NotBlank
		String capital, 
		
		@NotNull
		Double area) {
	
}
