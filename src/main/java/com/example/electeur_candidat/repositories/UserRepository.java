package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Users;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {

    boolean existsByUsername (String uesrname);
    boolean existsByUsernameAndId(String username , Integer id);
    //Only one sachant que username traité pour quil soit unique dans usersService !! juste en cas ou
    public Users findOneByUsername(String username);

}
