package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.entities.Experience;
import com.example.electeur_candidat.entities.Formation;
import com.example.electeur_candidat.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ELECTEUR')")
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

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Formation formation){
        return formationService.save(formation);
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Formation formation ){
        return formationService.update(formation);
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return formationService.delete(id);
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @GetMapping("find/{id}")
    public Formation findForm(@PathVariable Integer id){
        return formationService.findForm(id);
    }
}
