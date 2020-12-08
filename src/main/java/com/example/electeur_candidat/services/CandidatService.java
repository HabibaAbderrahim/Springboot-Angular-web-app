package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;

import java.util.List;

public interface CandidatService {

    public MessageResponse save(Candidat candidat);
    public MessageResponse delete(Integer id);
    public MessageResponse update(Candidat candidat);
    public List<Candidat> findAll();
    public List<Candidat> allCandidatSortedByScore();
    public float scoring (Integer id);
    public Candidat findById(Integer id);
    public Candidat findByIdAndEmail(Integer id , String email);

}
