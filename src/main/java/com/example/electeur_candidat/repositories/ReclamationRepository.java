package com.example.electeur_candidat.repositories;


import com.example.electeur_candidat.entities.Reclamation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReclamationRepository extends MongoRepository<Reclamation, Integer> {
}
