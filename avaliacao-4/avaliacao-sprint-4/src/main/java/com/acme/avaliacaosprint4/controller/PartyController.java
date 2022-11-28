package com.acme.avaliacaosprint4.controller;
import com.acme.avaliacaosprint4.dto.request.PartyRequestDto;
import com.acme.avaliacaosprint4.dto.response.PartyResponseDto;
import com.acme.avaliacaosprint4.enums.Ideology;
import com.acme.avaliacaosprint4.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/partidos")
public class PartyController {

    private final PartyService partyService;

    @PostMapping
    public ResponseEntity<PartyResponseDto> create(@RequestBody @Valid PartyRequestDto request) {
        PartyResponseDto response = partyService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PartyResponseDto>> listAll(@RequestParam(required = false) Ideology ideology) {
        List<PartyResponseDto> response = partyService.listAll(ideology);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<PartyResponseDto> list(@PathVariable Long id) {
        PartyResponseDto response = partyService.list(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PartyResponseDto> update(@PathVariable Long id, @RequestBody PartyRequestDto request){
        PartyResponseDto response = partyService.update(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        partyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
