package br.com.vivo.api.repository;


import br.com.vivo.api.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    void deleteCandidateById(Long id);

    Optional<Candidate> findCandidateById(Long id); //query method in spring
}

// o método findCandidateById() é responsável por buscar um candidato com base no ID
// fornecido e retornar um Optional<Candidate>, que pode ser vazio se não for encontrado
// nenhum candidato correspondente.