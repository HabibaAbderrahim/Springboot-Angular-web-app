package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ListIndependante extends ListElectorale{



    @Override
    public String toString() {
        return "ListIndependante{} " + super.toString();
    }
}
