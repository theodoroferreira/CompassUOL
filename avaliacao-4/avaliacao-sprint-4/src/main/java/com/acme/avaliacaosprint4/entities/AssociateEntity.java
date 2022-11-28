package com.acme.avaliacaosprint4.entities;

import com.acme.avaliacaosprint4.enums.Gender;
import com.acme.avaliacaosprint4.enums.PoliticalOffice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ASSOCIATES")
public class AssociateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false)
    private Long id;

    @Column(name="POLITICIAN_NAME")
    private String politicianName;

    @Enumerated(EnumType.STRING)
    @Column(name="POLITICAL_OFFICE")
    private PoliticalOffice politicalOffice;

    @Column(name="DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER")
    private Gender gender;
}
