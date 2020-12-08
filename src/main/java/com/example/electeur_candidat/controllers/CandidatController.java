package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidat")
@CrossOrigin("http://localhost:4200")
public class CandidatController {

    @Autowired
    private CandidatService candidatService ;

    @GetMapping("/getAll")
    public List<Candidat> getAll(){
        return candidatService.findAll();
    }
    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id")Integer id) { return  candidatService.scoring(id);}
    @GetMapping("/getAllSorted")
    public List<Candidat> getAllSorted(){
        return candidatService.allCandidatSortedByScore();
    }
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Candidat candidat){
        return candidatService.save(candidat);
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Candidat candidat ){
        return candidatService.update(candidat);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return candidatService.delete(id);
    }
    @GetMapping("find/{id}")
    public Candidat findCandidat(@PathVariable Integer id){
        return candidatService.findById(id);
    }
    @GetMapping("find/{id}/{email}")
    public Candidat findCandidatByIdAndMail(@PathVariable Integer id , @PathVariable String email){
        return candidatService.findByIdAndEmail(id , email);
    }




}
