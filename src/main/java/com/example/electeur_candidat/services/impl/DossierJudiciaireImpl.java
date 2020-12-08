package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.DossierJudiciaire;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.repositories.DossierJudiciaireRepository;
import com.example.electeur_candidat.services.DossierJudiciareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierJudiciaireImpl implements DossierJudiciareService {
    @Autowired
    private DossierJudiciaireRepository dossierJudiciaireRepository ;

    @Override
    public MessageResponse save(DossierJudiciaire dossierJudiciaire) {
        if (dossierJudiciaireRepository.existsById(dossierJudiciaire.getCodeDossier())) {
            return new MessageResponse(false, "Dossier candidat existant !!");
        }

        dossierJudiciaireRepository.save(dossierJudiciaire);


        float d = scoringDoss(dossierJudiciaire.getCodeDossier());
        dossierJudiciaire.setScoreCrime(d);

        dossierJudiciaireRepository.save(dossierJudiciaire);
        return new MessageResponse(true, "Dossier Candidat est ajouté avec succès");

    }

    @Override
    public MessageResponse delete(Long id) {
        if (!(dossierJudiciaireRepository.existsById(id))) {
            return new MessageResponse(false, "Dossier non existant !");

        }
        dossierJudiciaireRepository.deleteById(id);
        return new MessageResponse(true, "Dossier est supprimé avec succès");
    }

    @Override
    public MessageResponse update(DossierJudiciaire dossierJudiciaire) {
        if ((dossierJudiciaireRepository.existsById(dossierJudiciaire.getCodeDossier()))) {
            dossierJudiciaireRepository.save(dossierJudiciaire);
            return new MessageResponse(true, "Dossier Candidat est Modifié avec succès");
        }

        return new MessageResponse(false, "Dossier candiddat non existant !");

    }

    @Override
    public List<DossierJudiciaire> allExpStortedByjuridiction() {
        return dossierJudiciaireRepository.findAll(Sort.by(Sort.Direction.ASC,"juridiction"));
    }

    @Override
    public float scoringDoss(Long id) {
        //List<Candidat> candidats = candidatRepository.findAll();
       DossierJudiciaire dossierJudiciaire= dossierJudiciaireRepository.findById(id).orElse(null);
        float score=0 ;
        //for (Candidat candidat : candidats )
        String peine ="prison";
        if(dossierJudiciaire.getPeine().equals(peine)){
            score =(dossierJudiciaire.getScoreCrime()-40);
            dossierJudiciaire.setScoreCrime(score);
            dossierJudiciaireRepository.save(dossierJudiciaire);
        }


        return score;
    }



    @Override
    public DossierJudiciaire findCrime(Long id) {
        return dossierJudiciaireRepository.findById(id).orElse(null);
    }
}
