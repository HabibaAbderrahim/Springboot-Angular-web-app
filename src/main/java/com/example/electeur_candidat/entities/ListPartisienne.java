package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class ListPartisienne extends ListElectorale {

    //OneToMany
    private List<Parti> partis ;



    @Override
    public String toString() {
        return "ListPartisienne{" +
                "partis=" + partis +
                "} " + super.toString();
    }
}
