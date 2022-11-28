package com.acme.avaliacaosprint4.dto.response;

import com.acme.avaliacaosprint4.enums.Ideology;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PartyResponseDto {

    private Long id;
    private String name;
    private String abbreviation;
    private Ideology ideology;
    private LocalDate foundationDate;
}
