package br.com.francelinosilva.main.modules.company.useCase;

import br.com.francelinosilva.main.exceptions.CompanyFoundException;
import br.com.francelinosilva.main.modules.company.entities.CompanyEntity;
import br.com.francelinosilva.main.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity){
        this.companyRepository.findByUserNameOrEmail(companyEntity.getUserName(), companyEntity.getEmail())
                .ifPresent((company) -> {
                    throw new CompanyFoundException();
                });
        return this.companyRepository.save(companyEntity);
    }
}
