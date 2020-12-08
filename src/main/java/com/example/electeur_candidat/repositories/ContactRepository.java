package com.example.electeur_candidat.repositories;

import com.example.electeur_candidat.entities.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact , Integer> {

    //Methods specifics
    //find mail for all
    boolean existsByEmail(String email);
    boolean existsByEmailAndId(String email , Integer id);

}
