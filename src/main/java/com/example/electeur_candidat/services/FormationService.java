package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.entities.Formation;
import io.swagger.models.auth.In;

import java.util.List;

public interface FormationService {


    public MessageResponse save(Formation formation);
    public MessageResponse delete(Integer id);
    public MessageResponse update(Formation formation);
    public List<Formation> findAll();
    public List<Formation> allExpStortedByDur ();
    public float scoringForm(Integer id);
    public Formation findForm (Integer id);
}
