package com.example.electeur_candidat.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PasswordDTO implements Serializable {

    private  Integer id ;
    private String oldPassword ;
    private String newPassword ;
}
