package br.com.francelinosilva.main.modules.candidate.controllers;

import br.com.francelinosilva.main.exceptions.UserFoundException;
import br.com.francelinosilva.main.modules.candidate.CandidateEntity;
import br.com.francelinosilva.main.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
        this.candidateRepository.findByUserNameOrEmail(candidateEntity.getName(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}
