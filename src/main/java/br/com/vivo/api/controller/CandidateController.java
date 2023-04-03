package br.com.vivo.api.controller;

import br.com.vivo.api.dtos.CandidateDTO;
import br.com.vivo.api.service.CandidateService;
import br.com.vivo.api.validator.CandidateValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("candidatos")
public class CandidateController {

    @Autowired
    private CandidateValidator candidateValidator;

    @Autowired
    private CandidateService candidateService;


//    @PostMapping
//    @ResponseBody// chegando requisição do tipo post para url candidatos é para chamar o método cadastrar
//    public CandidateDTO cadastrar(@RequestBody @Valid CandidateDTO date, BindingResult bindingResult) { // Padrão Dto representam os dados que chegam na api e os dados que devolvem na api
//        candidateValidator.validate(date,bindingResult);
//        if(bindingResult.hasErrors()){
//
//        }
//        System.out.println(date);
//        return date;
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CandidateDTO candidate) {

        candidateService.CandidateTest(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }
}
