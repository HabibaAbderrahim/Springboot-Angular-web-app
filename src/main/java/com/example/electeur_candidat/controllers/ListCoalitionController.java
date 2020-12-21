package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.ListCoalition;
import com.example.electeur_candidat.entities.ListElectorale;
import com.example.electeur_candidat.services.ListCoalitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coalition")
@CrossOrigin("http://localhost:4200")
public class ListCoalitionController {

    @Autowired
    private ListCoalitionService listCoalitionService ;


    @GetMapping("/getAll")
    public List<ListCoalition> getAll(){
        return listCoalitionService.findAll();
    }

    @GetMapping("/getBtwn")
    public List<ListCoalition> getlistBtw(){
        return listCoalitionService.scoreBtw();
    }
    @PostMapping("/add")
    public MessageResponse add(@RequestBody ListCoalition listCoalition){
        return listCoalitionService.save(listCoalition);
    }
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody ListCoalition listCoalition ){
        return listCoalitionService.update(listCoalition);
    }
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return listCoalitionService.delete(id);
    }
    @GetMapping("find/{id}")
    public ListCoalition findList(@PathVariable Integer id){
        return listCoalitionService.findList(id);
    }

    @GetMapping("find/{gouv}")
    public List<ListCoalition> findByGouv(@PathVariable String gouv){
        return listCoalitionService.listByGouv(gouv);
    }
}
