package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.entities.Formation;
import com.example.electeur_candidat.repositories.ExperienceRepository;
import com.example.electeur_candidat.repositories.FormationRepository;
import com.example.electeur_candidat.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImpl  implements FormationService {

    @Autowired
    private FormationRepository formationRepository;

    @Override
    public MessageResponse save(Formation formation) {

        if(formationRepository.existsById(formation.getId())){
            return new MessageResponse(false, "Formation existante !!");

        }
        formationRepository.save(formation);
        float d =scoringForm(formation.getId());
        formation.setScoreForm(d);

        formationRepository.save(formation);

        return new MessageResponse(true, "formation est ajouté avec succès");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(formationRepository.existsById(id))) {
            return new MessageResponse(false, "form non existant !");

        }
        formationRepository.deleteById(id);
        return new MessageResponse(true, "form est supprimé avec succès");
    }

    @Override
    public MessageResponse update(Formation formation) {
        formationRepository.save(formation);
        return new MessageResponse(true, "from est Modifié avec succès");
    }

    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    @Override
    public List<Formation> allExpStortedByDur() {
        return formationRepository.findAll(Sort.by(Sort.Direction.DESC,"durée"));
    }

    @Override
    public float scoringForm(Integer id) {

        Formation formation = formationRepository.findById(id).orElse(null);
        float score=0 ;
        if((formation.getDurée()) > 30){
            score =(formation.getScoreForm()+5); //+10
            formation.setScoreForm(score);
            formationRepository.save(formation);
        }


        return score;

    }

    @Override
    public Formation findForm(Integer id) {
        return formationRepository.findById(id).orElse(null);
    }
}
