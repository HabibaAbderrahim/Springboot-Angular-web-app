package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListCoalition;
import com.example.electeur_candidat.repositories.ListCoalitionRepository;
import com.example.electeur_candidat.repositories.ListElectoraleRepository;
import com.example.electeur_candidat.services.ListCoalitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCoalitionServiceImpl implements ListCoalitionService {

    @Autowired
    private ListCoalitionRepository listCoalitionRepository ;
    @Override
    public MessageResponse save(ListCoalition listCoalition) {
        if(listCoalitionRepository.existsByIdAndNom(listCoalition.getId(),listCoalition.getNom())){
            return new MessageResponse(false, "List existante !!");
        }
        listCoalitionRepository.save(listCoalition);
        return new MessageResponse(true, "List est ajouté avec succès");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(listCoalitionRepository.existsById(id))) {
            return new MessageResponse(false, "List non existant !");

        }
        listCoalitionRepository.deleteById(id);
        return new MessageResponse(true, "List est supprimé avec succès");
    }

    @Override
    public MessageResponse update(ListCoalition listCoalition) {
        if(!(listCoalitionRepository.existsByIdAndNom(listCoalition.getId(),listCoalition.getNom()))){
            return new MessageResponse(false, "List non existante pour la mofifié !!");
        }
        listCoalitionRepository.save(listCoalition);
        return new MessageResponse(true, "List est modifié avec succès");
    }

    @Override
    public List<ListCoalition> findAll() {
        return listCoalitionRepository.findAll();
    }

    @Override
    public List<ListCoalition> listByGouv(String gouv) {
        return listCoalitionRepository.findByGouvernorat(gouv);
    }

    @Override
    public ListCoalition findList(Integer id) {
        return listCoalitionRepository.findById(id).orElse(null);
    }


    @Override
    public List<ListCoalition> topListScore() {
        return listCoalitionRepository.findAll(Sort.by(Sort.Direction.DESC,"scoreList"));
    }

    @Override
    public List<ListCoalition> scoreBtw() {
        return listCoalitionRepository.findByScoreListBetween(50,100);
    }


}
