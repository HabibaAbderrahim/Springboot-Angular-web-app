package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Parti;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartiRepository extends MongoRepository<Parti , Integer> {
}
