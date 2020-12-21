package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Cv;

import java.util.List;

public interface CvService {

    public float scoringCv (Integer id);
    public List<Cv> allCv();
    public MessageResponse save(Cv cv);
    public Cv findById(Integer id);
}
