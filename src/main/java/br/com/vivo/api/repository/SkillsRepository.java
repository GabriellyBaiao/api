package br.com.vivo.api.repository;


import br.com.vivo.api.model.Candidate;
import br.com.vivo.api.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SkillsRepository extends JpaRepository<Skills,Long> {
    void deleteSkillsById(Long id);

    Optional<Skills> findSkillsById(Long id);
}

