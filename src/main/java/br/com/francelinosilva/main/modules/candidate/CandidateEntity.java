package br.com.francelinosilva.main.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Pattern(regexp = "^\\S+$", message = "O campo não pode conter espaços em branco")
    @NotBlank(message = "O campo não pode estar em branco")
    private String userName;

    @Email(message = "O campo email deve conter um email válido")
    private String email;

    @Length(min = 5, max = 100, message = "O campo deve conter entre 5 e 100 caracteres")
    private String password;
    private String description;
    private String curriculum;
}
