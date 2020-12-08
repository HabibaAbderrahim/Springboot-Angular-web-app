package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ActivityRepository extends MongoRepository<Activity , Integer> {

    @Query("{'nom' : ?0}")
    public Activity findActivityByTitulaire(String nom);
    public boolean existsByTitulaireAndSecteur(String nom , String prenom);
}
