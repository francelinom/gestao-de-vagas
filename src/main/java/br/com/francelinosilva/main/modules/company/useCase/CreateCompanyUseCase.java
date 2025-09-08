package br.com.francelinosilva.main.modules.company.useCase;

import br.com.francelinosilva.main.exceptions.CompanyFoundException;
import br.com.francelinosilva.main.modules.company.entities.CompanyEntity;
import br.com.francelinosilva.main.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity){
        this.companyRepository.findByUserNameOrEmail(companyEntity.getUserName(), companyEntity.getEmail())
                .ifPresent((company) -> {
                    throw new CompanyFoundException();
                });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);

        return this.companyRepository.save(companyEntity);
    }
}
