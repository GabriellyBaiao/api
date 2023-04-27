package br.com.vivo.api.validator;

public class ExceptionValidator extends RuntimeException {

//    Construtor para receber uma mensagem, a partir dessa messagem chamo o super, que vai elevar
//   a um nível e exibir a mensagem que ele recebeu, envia essa mensagem quando chama a classe.

    public ExceptionValidator(String message){
        super(message);
    }
}
