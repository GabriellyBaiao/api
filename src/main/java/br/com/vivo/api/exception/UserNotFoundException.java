package br.com.vivo.api.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

//Esta classe é uma exceção personalizada que pode ser lançada quando um usuário não é encontrado.
// A classe contém um construtor que recebe uma mensagem de erro, que é passada para o construtor da superclasse.