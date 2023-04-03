package br.com.vivo.api.validator;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionErrors {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> tratarErro400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(ValidationData::new).toList());
    }
    @ExceptionHandler(ExceptionValidator.class)
    public ResponseEntity tratarErro(ExceptionValidator exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    private record ValidationData(String field, String message){
        public ValidationData(FieldError error) {

            this(error.getField(), error.getDefaultMessage());
        }
    }
}
