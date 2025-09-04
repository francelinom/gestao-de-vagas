package br.com.francelinosilva.main.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = "^\\S+$", message = "O campo não pode conter espaços em branco")
    @NotBlank(message = "O campo não pode estar em branco")
    private String userName;

    @Email(message = "O campo email deve conter um email válido")
    private String email;

    @Length(min = 5, max = 100, message = "O campo deve conter entre 5 e 100 caracteres")
    private String password;
    private String website;
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
