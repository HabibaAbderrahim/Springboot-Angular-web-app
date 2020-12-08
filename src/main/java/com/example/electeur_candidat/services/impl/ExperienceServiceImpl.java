package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Cv;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.repositories.ExperienceRepository;
import com.example.electeur_candidat.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository ;

    @Override
    public MessageResponse save(Experience experience) {
        if(experienceRepository.existsById(experience.getId())){
            return new MessageResponse(false, "Experience existante !!");

        }
        experienceRepository.save(experience);
        float d = scoringExp(experience.getId());
        experience.setScoreExp(d);

        experienceRepository.save(experience);


        return new MessageResponse(true, "Experience est ajouté avec succès");

    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(experienceRepository.existsById(id))) {
            return new MessageResponse(false, "Experience non existant !");

        }
        experienceRepository.deleteById(id);
        return new MessageResponse(true, "Experience est supprimé avec succès");
    }

    @Override
    public MessageResponse update(Experience experience) {
        experienceRepository.save(experience);
        return new MessageResponse(true, "Experience est Modifié avec succès");
    }

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public List<Experience> allExpStortedByNbExp() {
        return experienceRepository.findAll(Sort.by(Sort.Direction.DESC,"nombreAnnée"));
    }

    @Override
    public float scoringExp(Integer id) {

        Experience cexo = experienceRepository.findById(id).orElse(null);
        float score=0 ;


        if((cexo.getNombreAnnée()) > 2){
            score =(cexo.getScoreExp()+15); //+10
            cexo.setScoreExp(score);
            experienceRepository.save(cexo);
        }


        return score;
    }

    @Override
    public Experience findExp(Integer id) {
        return experienceRepository.findById(id).orElse(null);
    }


}
