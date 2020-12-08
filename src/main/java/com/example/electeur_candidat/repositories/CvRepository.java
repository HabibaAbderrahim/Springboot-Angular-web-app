package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Cv;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CvRepository extends MongoRepository<Cv, Integer> {


}
