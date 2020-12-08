package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class ListCoalition extends ListElectorale {

    //OneToOne
    private Parti parti ;



    @Override
    public String toString() {
        return "ListCoalition{" +
                "parti=" + parti +
                "} " + super.toString();
    }
}
