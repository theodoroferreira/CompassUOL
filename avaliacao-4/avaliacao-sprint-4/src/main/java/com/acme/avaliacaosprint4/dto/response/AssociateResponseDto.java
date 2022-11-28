package com.acme.avaliacaosprint4.dto.response;

import com.acme.avaliacaosprint4.enums.Gender;
import com.acme.avaliacaosprint4.enums.PoliticalOffice;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AssociateResponseDto {

    private Long id;
    private String politicianName;
    private PoliticalOffice politicalOffice;
    private LocalDate dateOfBirth;
    private Gender gender;
}
