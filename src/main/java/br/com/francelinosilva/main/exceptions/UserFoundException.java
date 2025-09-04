package br.com.francelinosilva.main.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("Usuário já cadastrado");
    }
}
