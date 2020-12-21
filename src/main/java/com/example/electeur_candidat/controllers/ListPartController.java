package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListCoalition;
import com.example.electeur_candidat.entities.ListPartisienne;
import com.example.electeur_candidat.services.ListPartisienneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/part")
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ELECTEUR')")
public class ListPartController {

    @Autowired
    private ListPartisienneService listPartisienneService ;
    @GetMapping("/getAll")
    public List<ListPartisienne> getAll(){
        return listPartisienneService.findAll();
    }

    @GetMapping("/getBtwn")
    public List<ListPartisienne> getlistBtw(){
        return  listPartisienneService.scoreBtw();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public MessageResponse add(@RequestBody ListPartisienne listPartisienne){
        return  listPartisienneService.save(listPartisienne);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody ListPartisienne listPartisienne ){
        return  listPartisienneService.update(listPartisienne);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return  listPartisienneService.delete(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("find/{id}")
    public ListPartisienne findList(@PathVariable Integer id){
        return listPartisienneService.findList(id);
    }

    @GetMapping("find/{gouv}")
    public List<ListPartisienne> findByGouv(@PathVariable String gouv){
        return  listPartisienneService.listByGouv(gouv);
    }
}
