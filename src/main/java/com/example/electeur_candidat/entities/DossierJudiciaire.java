package com.example.electeur_candidat.entities;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Document
public class DossierJudiciaire implements Serializable {

    @MongoId
    private Long codeDossier ;
    private String crime ;
    private LocalDate dateCondamnation ;
    private String Peine ;
    private Integer juridiction ;
    private float scoreCrime ;


}
