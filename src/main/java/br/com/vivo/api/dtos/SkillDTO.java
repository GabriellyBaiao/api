package br.com.vivo.api.dtos;

import br.com.vivo.api.model.ProgrammingLanguages;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillDTO {

    @NotNull(message = "Skill é obrigatório")
    private ProgrammingLanguages name;
    @Min(value = 0, message = "Score minímo 0")
    @Max(value = 10, message = "Score máximo 10")
    @NotNull(message = "A pontuação de habilidades é obrigatória!.")
    private BigDecimal score;

}



