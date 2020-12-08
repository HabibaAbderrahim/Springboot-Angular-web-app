package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Reclamation implements Serializable {

    @MongoId
    private Integer id ;

    private String contenu ; //commenter


    private Contact contacts ;//ManyToOne

    private List<Justificatif> justificatifs ;//OneToMany
}
