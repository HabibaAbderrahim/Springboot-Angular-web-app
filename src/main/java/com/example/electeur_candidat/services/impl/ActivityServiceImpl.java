package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Activity;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.repositories.ActivityRepository;
import com.example.electeur_candidat.repositories.CandidatRepository;
import com.example.electeur_candidat.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository ;
    @Autowired
    private CandidatRepository candidatRepository;
    @Override
    public MessageResponse save(Activity activity) {

     if(activityRepository.existsByTitulaireAndSecteur(activity.getTitulaire(),activity.getSecteur())){
         return new MessageResponse(false, "Cette activité a eté effectuee par un autre candidat !!");
     }
     activityRepository.save(activity);

        float d = scoringAct(activity.getId());
        activity.setScoreActv(d);

        activityRepository.save(activity);
       return new MessageResponse(true, "Activité ajouté avec succés ");

    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(activityRepository.existsById(id))) {
            return new MessageResponse(false, "Activité non existante !");

        }
        activityRepository.deleteById(id);
        return new MessageResponse(true, "Activity est supprimé avec succès");
    }

    @Override
    public MessageResponse update(Activity activity) {
        activityRepository.save(activity);
        return new MessageResponse(true, "Activité cahngé avec succés ");
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> allActivitySortedByNomberPersIn() {
        return activityRepository.findAll(Sort.by(Sort.Direction.ASC, "nombrePersonneIn"));
    }


    @Override
    public float scoringAct(Integer id) {

        Activity act = activityRepository.findById(id).orElse(null);
        float score=0 ;


        if((act.getNombrePersonneIn()) > 100){
            score =(act.getScoreActv()+15); //+10
            act.setScoreActv(score);
            activityRepository.save(act);
        }


        return score;
    }


    @Override
    public Activity activityByName(String name) {
        return activityRepository.findActivityByTitulaire(name);
    }


}
