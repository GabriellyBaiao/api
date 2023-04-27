package br.com.vivo.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;


// criar anotations para JPA @Entity @Data.. e colocar dependÊncia JPA

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidateDTO {

    @NotBlank(message = "Nome não informado")
    @Size(min = 3, max = 25, message = "Nome não informado")
    @Pattern(message = "Inicie seu nome com letra maiúscula!.", regexp ="^[A-Z]+(.)*")
    private String name;
    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail não informado")
    private String email;
    @Valid
    @NotEmpty(message = "Candidato precisa ter pontuação de seu nível de habilidades.")
    private List<SkillDTO> skills;
}
