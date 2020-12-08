package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Formation implements Serializable {

    @MongoId
    private Integer id ;
    private String type ;
    private String description ;
    private Integer durée ;
    private float scoreForm =0 ;

    private List<Justificatif> justificatifs ;//OneToMany

}
