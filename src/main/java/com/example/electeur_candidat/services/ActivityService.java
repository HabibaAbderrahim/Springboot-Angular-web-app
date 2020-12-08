package com.example.electeur_candidat.services;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Activity;
import com.example.electeur_candidat.entities.Candidat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActivityService {

    public MessageResponse save(Activity activity);
    public MessageResponse delete(Integer id);
    public MessageResponse update(Activity activity);
    public List<Activity> findAll();
    public List<Activity> allActivitySortedByNomberPersIn();
    public float scoringAct(Integer id);
    public Activity activityByName(String name);

}
