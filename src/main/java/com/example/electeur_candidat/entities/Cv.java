package com.example.electeur_candidat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.io.Serializable;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Cv implements Serializable {
    @MongoId
    private Integer id ;
    private float scoreCv =0;


    private List<Experience> experiences ; //OneToMany
    private List<Formation> formations ;//OneToMany
    private List<Activity> activities ; //oneToMany

    private List<DossierJudiciaire> dossierJudiciaires ;//oneToMany



}
