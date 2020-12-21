package com.example.electeur_candidat.controllers;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Users;
import com.example.electeur_candidat.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ELECTEUR')")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> getAll(){
        return usersService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Users user){
        return usersService.save(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Users user){
        return usersService.update(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return usersService.delete(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("find/{id}")
    public Users findUser(@PathVariable Integer id){
        return usersService.findById(id);
    }
}
