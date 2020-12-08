package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Reclamation;

import java.util.List;
import java.util.Optional;

public interface ReclamationService {

    public MessageResponse save(Reclamation reclamation);
    public MessageResponse delete(Integer id);
    public MessageResponse update(Reclamation reclamation);
    public Reclamation findRec(Integer id);
    //requet Jointure entre REC et contact
}
