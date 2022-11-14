package com.acme.avaliacaosprint3.controller;


import java.util.Optional;

import javax.validation.Valid;

import com.acme.avaliacaosprint3.controller.dto.AtualizacaoEstadoDTO;
import com.acme.avaliacaosprint3.controller.dto.ListagemEstadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.acme.avaliacaosprint3.controller.dto.CadastroEstadoDTO;
import com.acme.avaliacaosprint3.modelo.Estado;
import com.acme.avaliacaosprint3.repository.EstadoRepository;

@RestController
@RequestMapping(value = "/api/states")
public class EstadosController {

	@Autowired
	private EstadoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CadastroEstadoDTO dados) {
		repository.save(new Estado(dados));
	}
	
	@GetMapping
	public Page<ListagemEstadoDTO> listarTodos(@PageableDefault(sort = {"regiao"}) Pageable paginacao) {
		return repository.findAll(paginacao).map(ListagemEstadoDTO::new);
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<ListagemEstadoDTO> listar(@PathVariable Integer id) {
		Optional<Estado> optional = repository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new ListagemEstadoDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ListagemEstadoDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoEstadoDTO dados) {
		Optional<Estado> optional = repository.findById(id);
		if (optional.isPresent()) {
			var estado = repository.getReferenceById(id);
			estado.atualizarDados(dados);
			return ResponseEntity.ok(new ListagemEstadoDTO(estado));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		Optional<Estado> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
