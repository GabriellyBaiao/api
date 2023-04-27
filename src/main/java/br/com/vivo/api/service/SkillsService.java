package br.com.vivo.api.service;

import br.com.vivo.api.model.Skills;
import br.com.vivo.api.repository.SkillsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {

    @Autowired
    private final SkillsRepository skillsRepository;

    @Autowired
    public SkillsService(SkillsRepository skillsRepository) {

        this.skillsRepository = skillsRepository;
    }

    public Skills addSkills(Skills skills) {

        return skillsRepository.save(skills);
    }
}
