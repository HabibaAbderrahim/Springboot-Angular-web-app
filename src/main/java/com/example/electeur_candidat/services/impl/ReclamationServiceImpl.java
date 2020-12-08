package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Reclamation;
import com.example.electeur_candidat.repositories.JustificatifRepository;
import com.example.electeur_candidat.repositories.ReclamationRepository;
import com.example.electeur_candidat.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImpl implements ReclamationService {
    @Autowired
    private ReclamationRepository reclamationRepository ;
    @Autowired
    private JustificatifRepository justificatifRepository ;
    @Override
    public MessageResponse save(Reclamation reclamation) {
        if(!(justificatifRepository.existsById(reclamation.getId()))){
            return new MessageResponse(false, "Toutes reclamations sans justif est rejeté !");
        }
        reclamationRepository.save(reclamation);
        return new MessageResponse(true, "Reclamation est ajouté avec succès");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(reclamationRepository.existsById(id))) {
            return new MessageResponse(false, "Reclamation non existant !");

        }
        reclamationRepository.deleteById(id);
        return new MessageResponse(true, "Reclamation est supprimé avec succès");
    }

    @Override
    public MessageResponse update(Reclamation reclamation) {
        reclamationRepository.save(reclamation);
        return new MessageResponse(true, "Reclamation est Modifié avec succès");
    }



    @Override
    public Reclamation findRec(Integer id) {
        return reclamationRepository.findById(id).orElse(null);
    }
}
