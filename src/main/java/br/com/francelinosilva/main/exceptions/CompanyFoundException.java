package br.com.francelinosilva.main.exceptions;

import br.com.francelinosilva.main.modules.company.entities.CompanyEntity;

public class CompanyFoundException extends RuntimeException {

    public CompanyFoundException() {
        super("Empresa já cadastrada");
    }
}
