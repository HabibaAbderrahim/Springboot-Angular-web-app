package com.example.electeur_candidat.controllers;


import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Activity;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/getAll")
    public List<Activity> getAll(){
        return activityService.findAll();
    }

    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id")Integer id) { return  activityService.scoringAct(id);}
    @GetMapping("/getAllSorted")
    public List<Activity> getAllSorted(){
        return activityService.allActivitySortedByNomberPersIn();
    }
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Activity activity){
        return activityService.save(activity);
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Activity activity ){
        return activityService.update(activity);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return activityService.delete(id);
    }
    @GetMapping("find/{name}")
    public Activity findCandidat(@PathVariable String name){
        return activityService.activityByName(name);
    }


}
