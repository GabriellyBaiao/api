package br.com.vivo.api.validator;

public class ExceptionValidator extends RuntimeException {

    public ExceptionValidator(String message){
        super(message);
    }
}
