package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListCoalition;
import com.example.electeur_candidat.entities.ListElectorale;

import java.util.List;

public interface ListCoalitionService {

    public MessageResponse save(ListCoalition listCoalition);
    public MessageResponse delete(Integer id);
    public MessageResponse update(ListCoalition listCoalition);
    public List<ListCoalition> findAll();
    public List<ListCoalition> listByGouv(String gouv);
    public ListCoalition findList(Integer id);
    public List<ListCoalition> topListScore();
    //public List<ListCoalition> topFive();
    public List<ListCoalition> scoreBtw();
    //public float scoringListCoal (Integer id);


}
