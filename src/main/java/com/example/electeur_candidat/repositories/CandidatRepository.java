package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Candidat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CandidatRepository extends MongoRepository<Candidat , Integer> {

    public Candidat findByIdAndEmail(Integer id, String email);
    boolean existsByEmail(String email);
    boolean existsByEmailAndId(String email , Integer id);


}
