package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.DossierJudiciaire;
import com.example.electeur_candidat.entities.Formation;

import java.util.List;

public interface DossierJudiciareService {

    public MessageResponse save(DossierJudiciaire dossierJudiciaire);
    public MessageResponse delete(Long id);
    public MessageResponse update(DossierJudiciaire dossierJudiciaire);
    public List<DossierJudiciaire> allExpStortedByjuridiction ();
    public float scoringDoss(Long id);
    public DossierJudiciaire findCrime (Long id);
}
