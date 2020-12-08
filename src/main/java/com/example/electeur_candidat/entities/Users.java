package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document
public class Users extends Contact {

    private String username ;
    private String password ;
    private String role ;

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                "} " + super.toString();
    }
}
