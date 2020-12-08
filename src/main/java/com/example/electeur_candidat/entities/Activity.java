package com.example.electeur_candidat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Activity implements Serializable {

    @MongoId
    private Integer id ;
    private Integer duree ;
    private String description ;
    private String empalcement ;//hospital , ..
    private String titulaire ; //activité lancé sous le nom de ...
    private String type ;//privé public conference workshop
    private String secteur ; //commercial donation humanitaire environ
    private Integer nombrePersonneIn ;// 100 200 .
    private float scoreActv ;
    private List<Justificatif> justificatifs ;//oneToMany


}
