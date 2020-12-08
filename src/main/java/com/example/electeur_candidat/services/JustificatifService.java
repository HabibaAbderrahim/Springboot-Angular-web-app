package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Formation;
import com.example.electeur_candidat.entities.Justificatif;

import java.util.List;

public interface JustificatifService {

    public MessageResponse save(Justificatif justificatif);
    public MessageResponse delete(Integer id);
    public MessageResponse update(Justificatif justificatif);
    public Justificatif findJustf (Integer id);

}
