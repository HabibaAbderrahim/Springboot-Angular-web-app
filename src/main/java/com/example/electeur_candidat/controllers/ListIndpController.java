package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListCoalition;
import com.example.electeur_candidat.entities.ListIndependante;
import com.example.electeur_candidat.services.ListIndepedanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indp")
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ELECTEUR')")
class ListIndpController {
    @Autowired
    private ListIndepedanteService listIndepedanteService;

    @GetMapping("/getAll")
    public List<ListIndependante> getAll(){
        return listIndepedanteService.findAll();
    }

    @GetMapping("/getBtwn")
    public List<ListIndependante> getlistBtw(){
        return listIndepedanteService.scoreBtw();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public MessageResponse add(@RequestBody ListIndependante listIndependante){
        return listIndepedanteService.save(listIndependante);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody ListIndependante listIndependante){
        return listIndepedanteService.update(listIndependante);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return listIndepedanteService.delete(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("find/{id}")
    public ListIndependante findList(@PathVariable Integer id){
        return listIndepedanteService.findList(id);
    }

    @GetMapping("find/{gouv}")
    public List<ListIndependante> findByGouv(@PathVariable String gouv){
        return listIndepedanteService.listByGouv(gouv);
    }
}
