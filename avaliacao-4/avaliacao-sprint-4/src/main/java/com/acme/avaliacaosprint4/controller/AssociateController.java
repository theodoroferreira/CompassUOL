package com.acme.avaliacaosprint4.controller;

import com.acme.avaliacaosprint4.dto.request.AssociateRequestDto;
import com.acme.avaliacaosprint4.dto.response.AssociateResponseDto;
import com.acme.avaliacaosprint4.enums.PoliticalOffice;
import com.acme.avaliacaosprint4.repositories.AssociateRepository;
import com.acme.avaliacaosprint4.service.AssociateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/associados")
public class AssociateController {

    private final AssociateRepository associateRepository;

    private final AssociateService associateService;

    @PostMapping
    public ResponseEntity<AssociateResponseDto> create(@RequestBody @Valid AssociateRequestDto request) {
        AssociateResponseDto response = associateService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AssociateResponseDto>> listAll(@RequestParam(required = false) PoliticalOffice politicalOffice) {
        List<AssociateResponseDto> response = associateService.listAll(politicalOffice);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<AssociateResponseDto> list(@PathVariable Long id) {
        AssociateResponseDto response = associateService.list(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssociateResponseDto> update(@PathVariable Long id, AssociateRequestDto request) {
        AssociateResponseDto response = associateService.update(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        associateService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
