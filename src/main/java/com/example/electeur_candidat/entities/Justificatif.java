package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Document
public class Justificatif implements Serializable {

    @MongoId
    private Integer id ;
    private String type ;//video certf image
    private String document ;
    private LocalDate dateD ;
    private  LocalDate dateF ;


    //ManyToOne
    //private Justificatif jsuJustificatif ;

    private Formation formation ;//ManyToOne
    private  Experience experience ; //ManyToOne
    private Activity activity ;

    private Reclamation reclamation ;
}
