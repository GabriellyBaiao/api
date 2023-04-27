package br.com.vivo.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ProgrammingLanguages name;
    private BigDecimal score;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "candidate_id") // relaciona todas as infos de skills com o candidato;
    private Candidate candidate;
}
