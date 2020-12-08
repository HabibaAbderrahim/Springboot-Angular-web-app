package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Formation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormationRepository extends MongoRepository<Formation,Integer> {
}
