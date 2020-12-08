package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Experience;
import io.swagger.models.auth.In;

import java.util.List;

public interface ExperienceService {

    public MessageResponse save(Experience experience );
    public MessageResponse delete(Integer id);
    public MessageResponse update(Experience experience);
    public List<Experience> findAll();
    public List<Experience> allExpStortedByNbExp ();
    public float scoringExp (Integer id);
    public Experience findExp (Integer id);
}
