package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.DossierJudiciaire;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DossierJudiciaireRepository extends MongoRepository<DossierJudiciaire , Long> {
}
