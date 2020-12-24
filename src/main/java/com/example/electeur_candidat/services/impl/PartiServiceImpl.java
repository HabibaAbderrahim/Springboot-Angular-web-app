package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Parti;
import com.example.electeur_candidat.repositories.PartiRepository;
import com.example.electeur_candidat.services.PartiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartiServiceImpl implements PartiService {

    @Autowired
    private PartiRepository partiRepository ;
    @Override
    public MessageResponse save(Parti parti) {

        if(partiRepository.existsById(parti.getId())){
            return new MessageResponse(false, "Parti exists !");
        }
        partiRepository.save(parti);
        return new MessageResponse(true, "Parti ajouté");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if(!partiRepository.existsById(id)){
            return new MessageResponse(false, "Parti nn exists !");
        }
        partiRepository.deleteById(id);
        return new MessageResponse(true, "Parti ajouté");
    }

    @Override
    public MessageResponse update(Parti parti) {
        return null;
    }

    @Override
    public List<Parti> findAll() {
        return partiRepository.findAll();
    }

    @Override
    public Parti findById(Integer id) {
        return partiRepository.findById(id).orElse(null);
    }
}
