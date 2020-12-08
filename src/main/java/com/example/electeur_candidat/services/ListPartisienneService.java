package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListCoalition;
import com.example.electeur_candidat.entities.ListPartisienne;

import java.util.List;

public interface ListPartisienneService {


    public MessageResponse save(ListPartisienne listPartisienne);
    public MessageResponse delete(Integer id);
    public MessageResponse update(ListPartisienne listPartisienne);
    public List<ListPartisienne> findAll();
    public List<ListPartisienne> listByGouv(String gouv);
    public ListPartisienne findList(Integer id);
    public List<ListPartisienne> topListScore();
    public List<ListPartisienne> scoreBtw();
}

