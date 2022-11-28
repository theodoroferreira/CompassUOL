package com.acme.avaliacaosprint4.dto.request;
import com.acme.avaliacaosprint4.enums.Ideology;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyRequestDto {

        @NotBlank
        private String partyName;

        @NotBlank
        private String abbreviation;

        @NotNull
        @Enumerated(EnumType.STRING)
        private Ideology ideology;

        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        private LocalDate foundationDate;
}
