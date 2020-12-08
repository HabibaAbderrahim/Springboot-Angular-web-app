package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Activity;
import com.example.electeur_candidat.entities.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExperienceRepository extends MongoRepository<Experience , Integer> {

    public List<Activity> getListByDomaine(String domaine);
}
