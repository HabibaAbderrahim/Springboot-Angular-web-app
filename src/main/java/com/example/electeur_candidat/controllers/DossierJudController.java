package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.DossierJudiciaire;
import com.example.electeur_candidat.entities.Formation;
import com.example.electeur_candidat.services.DossierJudiciareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossierJud")
@CrossOrigin("http://localhost:4200")
public class DossierJudController {

    @Autowired
    private DossierJudiciareService dossierJudiciareService ;

    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id")Long id) {
        return dossierJudiciareService.scoringDoss(id);
    }
    @GetMapping("/getAllSorted")
    public List<DossierJudiciaire> getAllSorted(){
        return dossierJudiciareService.allExpStortedByjuridiction();
    }
    @PostMapping("/add")
    public MessageResponse add(@RequestBody DossierJudiciaire dossierJudiciaire){
        return dossierJudiciareService.save(dossierJudiciaire);
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody DossierJudiciaire dossierJudiciaire ){
        return dossierJudiciareService.update(dossierJudiciaire);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Long id){
        return dossierJudiciareService.delete(id);
    }
    @GetMapping("find/{id}")
    public DossierJudiciaire findForm(@PathVariable Long id){
        return dossierJudiciareService.findCrime(id);
    }
}
