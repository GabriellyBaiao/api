package br.com.vivo.api.service;

import br.com.vivo.api.dtos.CandidateDTO;
import br.com.vivo.api.dtos.SkillDTO;
import br.com.vivo.api.exception.UserNotFoundException;
import br.com.vivo.api.model.Candidate;
import br.com.vivo.api.model.ProgrammingLanguages;
import br.com.vivo.api.repository.CandidateRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CandidateService {

        @Autowired
        private final CandidateRepository candidateRepository;

        @Autowired
        public CandidateService(CandidateRepository candidateRepository) {
            this.candidateRepository = candidateRepository;
        }

        public Candidate addCandidate(Candidate candidate) {
            return candidateRepository.save(candidate);
        }

        public List<Candidate> findAllCandidates() {

            return candidateRepository.findAll();
        }

        public Candidate updateCandidate(Candidate candidate) {

            return candidateRepository.save(candidate);
        }

        public Candidate findCandidateById(Long id) {
            return candidateRepository.findCandidateById(id)
                    .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
        }

        public void deleteCandidate(Long id){

            candidateRepository.deleteCandidateById(id);
        }



    public void CandidateTest(CandidateDTO candidate) {
        String name, email;
        BigDecimal java = null, csharp = null, golang = null, javascript = null, vue = null, php = null;

        List<SkillDTO> skills = candidate.getSkills();
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getName() == ProgrammingLanguages.JAVA) {
                java = skills.get(i).getScore();
            }
            if (skills.get(i).getName() == ProgrammingLanguages.CSHARP) {
                csharp = skills.get(i).getScore();
            }
            if (skills.get(i).getName() == ProgrammingLanguages.GOLANG) {
                golang = skills.get(i).getScore();
            }
            if (skills.get(i).getName() == ProgrammingLanguages.JAVASCRIPT) {
                javascript = skills.get(i).getScore();
            }
            if (skills.get(i).getName() == ProgrammingLanguages.JAVASCRIPT) {
                javascript = skills.get(i).getScore();
            }
            if (skills.get(i).getName() == ProgrammingLanguages.VUE) {
                vue = skills.get(i).getScore();
            }
            if (skills.get(i).getName() == ProgrammingLanguages.PHP) {
                php = skills.get(i).getScore();
            }
        }
        if (java.compareTo(BigDecimal.valueOf(6)) >= 0 && csharp.compareTo(BigDecimal.valueOf(6)) >= 0 && golang.compareTo(BigDecimal.valueOf(6)) >= 0 && javascript.compareTo(BigDecimal.valueOf(6)) >= 0 && vue.compareTo(BigDecimal.valueOf(6)) >= 0 && php.compareTo(BigDecimal.valueOf(6)) >= 0) {
            this.SendEmail(candidate, "Você é uma(a) desenvolvedor(a) Backend e Frontend");
        } else if (javascript.compareTo(BigDecimal.valueOf(6)) >= 0 && vue.compareTo(BigDecimal.valueOf(6)) >= 0 && php.compareTo(BigDecimal.valueOf(6)) >= 0) {
            this.SendEmail(candidate, "Você foi classificado(a) como Desenvolvedor(a) Frontend, entraremos em contato.");
        } else if (java.compareTo(BigDecimal.valueOf(6)) >= 0 && csharp.compareTo(BigDecimal.valueOf(6)) >= 0 && golang.compareTo(BigDecimal.valueOf(6)) >= 0) {
            this.SendEmail(candidate, "Você foi classificado(a) como desenvolver(a) Backend, entraremos em contato.");
        } else {
            this.SendEmail(candidate, "Você não está qualificado para nenhuma das áreas.");
        }
    }

    private boolean SendEmail (CandidateDTO candidate, String text){
        String to = candidate.getEmail();
        String subject = "FeedBack Classificação Candidato Desenvolvedor";
        String message = text;
        try {
            EmailService emailService = new EmailService();
            emailService.sendEmail(text, subject, to);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
}