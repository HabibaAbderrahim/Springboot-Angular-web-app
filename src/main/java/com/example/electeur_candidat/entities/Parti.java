package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Data
@Document
public class Parti implements Serializable {

    @MongoId
    private Integer id ;
    private String slogan ;
    private String nom ;
    private String orientationPolitique ;
}
