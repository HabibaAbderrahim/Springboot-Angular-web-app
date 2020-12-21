package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Users;
import com.example.electeur_candidat.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> getAll(){
        return usersService.findAll();
    }
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Users user){
        return usersService.save(user);
    }

    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Users user){
        return usersService.update(user);
    }

    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return usersService.delete(id);
    }


    @GetMapping("find/{id}")
    public Users findUser(@PathVariable Integer id){
        return usersService.findById(id);
    }
}
