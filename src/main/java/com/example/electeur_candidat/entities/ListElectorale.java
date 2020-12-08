package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.io.Serializable;
import java.util.List;

@Data
@Document
public class ListElectorale implements Serializable {

    @MongoId
    private Integer id ;
    private String gouvernorat ;
    private Integer scoreList ;
    private String nom ;

    //OneToMany
    private List<Candidat>candidatList ;
    private List<ListIndependante> listIndependantes ;
    private List<ListPartisienne> listPartisiennes ;
    private List<ListCoalition> listCoalitions ;
}
