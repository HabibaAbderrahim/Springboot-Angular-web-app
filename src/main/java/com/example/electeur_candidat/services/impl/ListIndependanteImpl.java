package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListIndependante;
import com.example.electeur_candidat.entities.ListPartisienne;
import com.example.electeur_candidat.repositories.ListIndependanteRepository;
import com.example.electeur_candidat.services.ListIndepedanteService;
import com.example.electeur_candidat.services.ListPartisienneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListIndependanteImpl implements ListIndepedanteService {

    @Autowired
    private ListIndependanteRepository listIndependanteRepository ;

    @Override
    public MessageResponse save(ListIndependante listIndependante) {
        if(listIndependanteRepository.existsByIdAndNom(listIndependante.getId(),listIndependante.getNom())){
            return new MessageResponse(false, "List existante !!");
        }
       listIndependanteRepository.save(listIndependante);
        return new MessageResponse(true, "List est ajouté avec succès");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(listIndependanteRepository.existsById(id))) {
            return new MessageResponse(false, "List non existant !");

        }
        listIndependanteRepository.deleteById(id);
        return new MessageResponse(true, "List est supprimé avec succès");
    }

    @Override
    public MessageResponse update(ListIndependante listIndependante) {
        if(!(listIndependanteRepository.existsByIdAndNom(listIndependante.getId(),listIndependante.getNom()))){
            return new MessageResponse(false, "List non existante pour la mofifié !!");
        }
        listIndependanteRepository.save(listIndependante);
        return new MessageResponse(true, "List est modifié avec succès");
    }

    @Override
    public List<ListIndependante> findAll() {
        return listIndependanteRepository.findAll();
    }

    @Override
    public List<ListIndependante> listByGouv(String gouv) {
        return listIndependanteRepository.findByGouvernorat(gouv);
    }

    @Override
    public ListIndependante findList(Integer id) {
        return listIndependanteRepository.findById(id).orElse(null);
    }

    @Override
    public List<ListIndependante> topListScore() {
        return listIndependanteRepository.findAll(Sort.by(Sort.Direction.DESC,"scoreList"));
    }

    @Override
    public List<ListIndependante> scoreBtw() {
        return listIndependanteRepository.findByScoreListBetween(50,100);
    }
}
