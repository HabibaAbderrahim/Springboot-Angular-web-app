package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Reclamation;
import com.example.electeur_candidat.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Reclamatioon")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService ;
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Reclamation reclamation){
        return reclamationService.save(reclamation);
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Reclamation reclamation ){
        return reclamationService.update(reclamation);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return reclamationService.delete(id);
    }
    @GetMapping("find/{id}")
    public Reclamation findExperience(@PathVariable Integer id){
        return reclamationService.findRec(id);
    }
}
