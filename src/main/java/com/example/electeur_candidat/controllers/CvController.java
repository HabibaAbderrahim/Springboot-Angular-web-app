package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cv")
public class CvController {

    @Autowired
    private CvService cvService;
    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id") Integer id) {
        return cvService.scoringCv(id);
    }
}
