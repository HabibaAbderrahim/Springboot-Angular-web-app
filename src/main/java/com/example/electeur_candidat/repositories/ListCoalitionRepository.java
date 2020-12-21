package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.ListCoalition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ListCoalitionRepository extends MongoRepository<ListCoalition , Integer> {

    public boolean existsByIdAndNom (Integer id , String nom);

    public List<ListCoalition> findByGouvernorat (String gouvernorat);

    public List<ListCoalition> findByParti (String gouvernorat);

    //les liste qui ont plus de 50 ans et moins de 100 ans
    public  List<ListCoalition> findByScoreListBetween(int scoreGT, int scoreLT);
    //TOP 5
    //public List<ListCoalition> findFirst5ByScoreListDesc();
}
