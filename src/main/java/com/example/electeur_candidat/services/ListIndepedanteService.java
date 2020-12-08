package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListIndependante;
import com.example.electeur_candidat.entities.ListPartisienne;

import java.util.List;

public interface ListIndepedanteService {

    public MessageResponse save(ListIndependante listIndependante);
    public MessageResponse delete(Integer id);
    public MessageResponse update(ListIndependante listIndependante);
    public List<ListIndependante> findAll();
    public List<ListIndependante> listByGouv(String gouv);
    public ListIndependante findList(Integer id);
    public List<ListIndependante> topListScore();
    public List<ListIndependante> scoreBtw();
}
