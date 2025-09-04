package br.com.francelinosilva.main.modules.company.repositories;

import br.com.francelinosilva.main.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    public Optional<CompanyEntity> findByUserNameOrEmail(String userName, String email);
}
