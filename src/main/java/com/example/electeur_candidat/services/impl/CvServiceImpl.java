package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Cv;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.entities.Formation;
import com.example.electeur_candidat.repositories.CvRepository;
import com.example.electeur_candidat.repositories.ExperienceRepository;
import com.example.electeur_candidat.repositories.FormationRepository;
import com.example.electeur_candidat.services.CvService;
import com.example.electeur_candidat.services.ExperienceService;
import com.example.electeur_candidat.services.FormationService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImpl implements CvService {
    @Autowired
    private ExperienceRepository experienceRepository ;
    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private CvRepository cvRepository ;

    @Override
    public float scoringCv(Integer id) {

        Cv cv = cvRepository.findById(id).orElse(null);

        float scoreT = cv.getScoreCv();//0
        float score=0 ;
        for(var x:cv.getExperiences()){
            score=x.getScoreExp();
           scoreT +=score;
            cv.setScoreCv(scoreT);
            cvRepository.save(cv);

        }
        System.out.println(scoreT);
        float scoreF=0 ;
        for(var x:cv.getFormations()){
            scoreF =x.getScoreForm();
            scoreT+=scoreF;
            cv.setScoreCv(scoreT);
            cvRepository.save(cv);
        }
        System.out.println(score);
        return scoreT ;   }

    @Override
    public List<Cv> allCv() {
        return cvRepository.findAll();
    }

    @Override
    public MessageResponse save(Cv cv) {
        return null;
    }

    @Override
    public Cv findById(Integer id) {
       
        return cvRepository.findById(id).orElse(null);
    }
}
