package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Experience implements Serializable {

    @MongoId
    private Integer id ;
    private String domaine ;

    private String description ;
    private Integer nombreAnnée ;
    private float scoreExp = 0;


    private List<Justificatif> justificatifs ;//OneToMany
    //Ma7atitech many to one

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", domaine='" + domaine + '\'' +
                ", description='" + description + '\'' +
                ", nombreAnnée=" + nombreAnnée +
                ", scoreExp=" + scoreExp +
                ", justificatifs=" + justificatifs +
                '}';
    }
}
