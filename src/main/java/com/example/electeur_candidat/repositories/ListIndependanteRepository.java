package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.ListCoalition;
import com.example.electeur_candidat.entities.ListIndependante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ListIndependanteRepository extends MongoRepository<ListIndependante , Integer> {

    public boolean existsByIdAndNom (Integer id,String nom);

    public List<ListIndependante> findByGouvernorat (String gouvernorat);

    public  List<ListIndependante> findByScoreListBetween(int scoreGT, int scoreLT);

}
