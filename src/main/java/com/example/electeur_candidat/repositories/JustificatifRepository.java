package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Justificatif;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JustificatifRepository extends MongoRepository<Justificatif , Integer> {

    public boolean existsByIdAndDocument (Integer id , String document);
    public boolean existsByDocument (String document);
}
