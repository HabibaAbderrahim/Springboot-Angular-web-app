package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Justificatif;
import com.example.electeur_candidat.repositories.JustificatifRepository;
import com.example.electeur_candidat.services.JustificatifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JustificatifServiceImpl implements JustificatifService {
    @Autowired
    private JustificatifRepository justificatifRepository ;
    @Override
    public MessageResponse save(Justificatif justificatif) {
        if (justificatifRepository.existsByIdAndDocument(justificatif.getId() , justificatif.getDocument())) {
            return new MessageResponse(false, "Justification existante !!");
        }

        justificatifRepository.save(justificatif);
        return new MessageResponse(true, "Justification est ajouté avec succès");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if (!(justificatifRepository.existsById(id))) {
            return new MessageResponse(false, "Justificative non existant !");

        }
        justificatifRepository.deleteById(id);
        return new MessageResponse(true, "Justif est supprimé avec succès");
    }

    @Override
    public MessageResponse update(Justificatif justificatif) {
        if (!(justificatifRepository.existsByIdAndDocument(justificatif.getId() , justificatif.getDocument())) ){
            //He may changed document ?
            if (justificatifRepository.existsByDocument(justificatif.getDocument())) {
                return new MessageResponse(false, "Justif existante !");
            }
        }
        justificatifRepository.save(justificatif);
        return new MessageResponse(true, "Justif nn existante !");
    }


    @Override
    public Justificatif findJustf(Integer id) {
        return justificatifRepository.findById(id).orElse(null);
    }
}
