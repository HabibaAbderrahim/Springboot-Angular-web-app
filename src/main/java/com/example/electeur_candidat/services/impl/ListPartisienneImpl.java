package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListIndependante;
import com.example.electeur_candidat.entities.ListPartisienne;
import com.example.electeur_candidat.repositories.ListPartisienneRepository;
import com.example.electeur_candidat.services.ListPartisienneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPartisienneImpl implements ListPartisienneService {

    @Autowired
    private ListPartisienneRepository listPartisienneRepository ;
    @Override
    public MessageResponse save(ListPartisienne listPartisienne) {
        if(listPartisienneRepository.existsByIdAndNom(listPartisienne.getId(),listPartisienne.getNom())){
            return new MessageResponse(false, "List existante !!");
        }
        listPartisienneRepository.save(listPartisienne);
        return new MessageResponse(true, "List est ajouté avec succès");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(listPartisienneRepository.existsById(id))) {
            return new MessageResponse(false, "List non existant !");

        }
        listPartisienneRepository.deleteById(id);
        return new MessageResponse(true, "List est supprimé avec succès");
    }

    @Override
    public MessageResponse update(ListPartisienne listPartisienne) {
        if(!(listPartisienneRepository.existsByIdAndNom(listPartisienne.getId(),listPartisienne.getNom()))){
            return new MessageResponse(false, "List non existante pour la mofifié !!");
        }
        listPartisienneRepository.save(listPartisienne);
        return new MessageResponse(true, "List est modifié avec succès");
    }

    @Override
    public List<ListPartisienne> findAll() {
        return listPartisienneRepository.findAll();
    }

    @Override
    public List<ListPartisienne> listByGouv(String gouv) {
        return listPartisienneRepository.findByGouvernorat(gouv);
    }

    @Override
    public ListPartisienne findList(Integer id) {
        return listPartisienneRepository.findById(id).orElse(null);
    }

    @Override
    public List<ListPartisienne> topListScore() {
        return listPartisienneRepository.findAll(Sort.by(Sort.Direction.DESC,"scoreList"));
    }

    @Override
    public List<ListPartisienne> scoreBtw() {
        return null;
    }
}
