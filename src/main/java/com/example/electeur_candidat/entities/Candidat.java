package com.example.electeur_candidat.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Candidat extends Contact {
    private double score = 0.0 ;
    private String facebook ;
    private String twitter ;
    private Integer position ;


    private Parti partis ;// One To One
    private Cv cvs ; // one To One

    @Override
    public String toString() {
        return "Candidat{" +
                "score=" + score +
                ", facebook='" + facebook + '\'' +
                ", twitter='" + twitter + '\'' +
                ", partis=" + partis +
                ", cvs=" + cvs +
                "} " + super.toString();
    }

    /*@OneToMany(mappedBy = "candidat")
    List<Activity> activities ;
    @ManyToOne
    ListCandidat listCandidat ;*/





}
