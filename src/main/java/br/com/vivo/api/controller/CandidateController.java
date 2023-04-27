package br.com.vivo.api.controller;

import br.com.vivo.api.dtos.CandidateDTO;
import br.com.vivo.api.dtos.SkillDTO;
import br.com.vivo.api.model.Candidate;
import br.com.vivo.api.model.Skills;
import br.com.vivo.api.service.CandidateService;
import br.com.vivo.api.service.SkillsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService; // final: imutável

    private final SkillsService skillsService;

    public CandidateController(CandidateService candidateService, SkillsService skillsService) {

        this.candidateService = candidateService;
        this.skillsService = skillsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidate>> getAllCandidates () {
        List<Candidate> candidates = candidateService.findAllCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long id) {
        Candidate candidate = candidateService.findCandidateById(id);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody @Valid CandidateDTO candidate) {

        candidateService.CandidateTest(candidate);
        Candidate candidate1 = new Candidate(); //candidade1 é uma entidade
        candidate1.setEmail(candidate.getEmail()); // transferencia de dados do DTO para entidade.
        candidate1.setName(candidate.getName());
        candidateService.addCandidate(candidate1);

        for(SkillDTO skills : candidate.getSkills()) {
            Skills skills1 = new Skills();
            skills1.setName(skills.getName());
            skills1.setScore(skills.getScore());
            skills1.setCandidate(candidate1);
            skillsService.addSkills(skills1);
        }
        return new ResponseEntity(candidate, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
        Candidate updateCandidate = candidateService.updateCandidate(candidate);
        return new ResponseEntity<>(updateCandidate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable("id") Long id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


