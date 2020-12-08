package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.entities.Formation;
import com.example.electeur_candidat.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @GetMapping("/getAll")
    public List<Formation> getAll(){
        return formationService.findAll();
    }
    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id") Integer id) {
        return formationService.scoringForm(id);
    }
    @GetMapping("/getAllSorted")
    public List<Formation> getAllSorted(){
        return formationService.allExpStortedByDur();
    }
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Formation formation){
        return formationService.save(formation);
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Formation formation ){
        return formationService.update(formation);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return formationService.delete(id);
    }
    @GetMapping("find/{id}")
    public Formation findForm(@PathVariable Integer id){
        return formationService.findForm(id);
    }
}