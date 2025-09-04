package br.com.francelinosilva.main.modules.candidate.useCase;

import br.com.francelinosilva.main.exceptions.UserFoundException;
import br.com.francelinosilva.main.modules.candidate.CandidateEntity;
import br.com.francelinosilva.main.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUserNameOrEmail(candidateEntity.getName(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}
