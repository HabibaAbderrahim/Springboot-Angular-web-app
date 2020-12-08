package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Expert")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService ;

    @GetMapping("/getAll")
    public List<Experience> getAll(){
        return experienceService.findAll();
    }
    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id")Integer id) { return  experienceService.scoringExp(id);}
    @GetMapping("/getAllSorted")
    public List<Experience> getAllSorted(){
        return experienceService.allExpStortedByNbExp();
    }
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Experience experience){
        return experienceService.save(experience);
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Experience experience ){
        return experienceService.update(experience);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return experienceService.delete(id);
    }
    @GetMapping("find/{id}")
    public Experience findExperience(@PathVariable Integer id){
        return experienceService.findExp(id);
    }
}
