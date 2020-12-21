package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.entities.Cv;
import com.example.electeur_candidat.services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cv")
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ELECTEUR')")
public class CvController {

    @Autowired
    private CvService cvService;
    @GetMapping("/getAll")
    public List<Cv> getAll(){
        return cvService.allCv();
    }
    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id") Integer id) {
        return cvService.scoringCv(id);
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @GetMapping("find/{id}")
    public Cv findCv(@PathVariable Integer id){
        return cvService.findById(id);
    }
}
