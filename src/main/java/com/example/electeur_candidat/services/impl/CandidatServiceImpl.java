package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Activity;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Contact;
import com.example.electeur_candidat.entities.Cv;
import com.example.electeur_candidat.repositories.ActivityRepository;
import com.example.electeur_candidat.repositories.CandidatRepository;
import com.example.electeur_candidat.repositories.ContactRepository;
import com.example.electeur_candidat.repositories.CvRepository;
import com.example.electeur_candidat.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CvRepository cvRepository ;
    @Autowired
    private ActivityRepository activityRepository ;

    @Override
    @Transactional //hibernate session
    public MessageResponse save(Candidat candidat) {

        boolean exist= candidatRepository.existsByEmail(candidat.getEmail());
        if(exist){
            return new MessageResponse(false,"Fail Email exist");
        }


        candidatRepository.save(candidat);

        float d = scoring(candidat.getId());
        candidat.setScore(d);

        candidatRepository.save(candidat);

        return new MessageResponse(true, "Candidat est ajouté avec succès");

    }

    @Override
    @Transactional
    public MessageResponse delete(Integer id) {
        if (!(candidatRepository.existsById(id))) {
            return new MessageResponse(false, "Candidat non existant !");

        }
        candidatRepository.deleteById(id);
        return new MessageResponse(true, "Candidat est supprimé avec succès");
    }

    @Override
    @Transactional
    public MessageResponse update(Candidat candidat) {
        if (!(contactRepository.existsByEmailAndId(candidat.getEmail(), candidat.getId()))) {
            //He may changed mail ?
            if (contactRepository.existsByEmail(candidat.getEmail())) {
                return new MessageResponse(false, "Email Candidat existant !");
            }
        }
        candidatRepository.save(candidat);
        return new MessageResponse(true, "Candidat est Modifié avec succès");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }

    @Override
    public List<Candidat> allCandidatSortedByScore() {
        return candidatRepository.findAll(Sort.by(Sort.Direction.DESC,"score"));
    }


    @Override
    public float scoring(Integer id) {
        Candidat candidat = candidatRepository.findById(id).orElse(null);
        float score=0 ;
            if(candidat.getAge()<= 50){
                score = (float) (candidat.getScore()+10); //+10
                candidat.setScore(score);
                candidatRepository.save(candidat);
            }

        return score;
    }


    @Override
    public Candidat findById(Integer id) {
        return candidatRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Candidat findByIdAndEmail(Integer id, String email) {
        return candidatRepository.findByIdAndEmail(id , email);
    }
}
