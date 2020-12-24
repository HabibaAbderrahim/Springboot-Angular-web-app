package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Parti;

import java.util.List;

public interface PartiService {

    public MessageResponse save(Parti parti);
    public MessageResponse delete(Integer id);
    public MessageResponse update(Parti parti);
    public List<Parti> findAll();
    public Parti findById(Integer id);
}
