package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.ListIndependante;
import com.example.electeur_candidat.entities.ListPartisienne;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ListPartisienneRepository extends MongoRepository<ListPartisienne , Integer> {

    public boolean existsByIdAndNom (Integer id , String nom);

    public List<ListPartisienne> findByGouvernorat (String gouvernorat);

    public  List<ListPartisienne> findByScoreListBetween(int scoreGT, int scoreLT);
}
