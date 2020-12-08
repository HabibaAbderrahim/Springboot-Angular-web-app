package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Contact implements Serializable {

    @MongoId
    private Integer id ;
    private String nom ;
    private String prenom ;
    private Date dateNaissance ;
    private Integer age;
    private String job;
    private String email ;
    private String photo ;


    private List<Reclamation> reclamations ; //OneTomany


}
