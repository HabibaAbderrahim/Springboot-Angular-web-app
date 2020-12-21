package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Justificatif;
import com.example.electeur_candidat.services.JustificatifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/justif")
@CrossOrigin("http://localhost:4200")
@PreAuthorize("haRole('ROLE_ADMIN')")
public class JustifController {

    @Autowired
    private JustificatifService justificatifService ;


    @PostMapping("/add")
    public MessageResponse add(@RequestBody Justificatif justificatif){
        return justificatifService.save(justificatif) ;
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Justificatif justificatif ){
        return justificatifService.update(justificatif);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return justificatifService.delete(id);
    }
    @GetMapping("find/{id}")
    public Justificatif findJustif(@PathVariable Integer id){
        return justificatifService.findJustf(id);
    }
}
