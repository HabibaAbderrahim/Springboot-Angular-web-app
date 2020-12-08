package com.example.electeur_candidat.services.impl;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.DTO.PasswordDTO;
import com.example.electeur_candidat.entities.Users;
import com.example.electeur_candidat.repositories.ContactRepository;
import com.example.electeur_candidat.repositories.UserRepository;
import com.example.electeur_candidat.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServicesImpl implements UsersService {

    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private ContactRepository contactRepository ;//email nestsi 3al kol
    //To deal with password
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Override
    public MessageResponse save(Users user) {
        boolean exist= contactRepository.existsByEmail(user.getEmail());
        if(exist){
            return new MessageResponse(false,"Fail Email exist");
        }

        if(userRepository.existsByUsername(user.getUsername())){
            return new MessageResponse(false,"Fail Username exist");

        }
        String cryptedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(cryptedPwd);

        userRepository.save(user);

        return new MessageResponse(true,"ADD success");
    }

    @Override
    public MessageResponse delete(Integer id) {
        if(!(userRepository.existsById(id))){

            return new MessageResponse(false , "utilisateur intouvable");

        }
        userRepository.deleteById(id);
        return new MessageResponse(true , "supprimé avec succés") ;
    }

    @Override
    public MessageResponse update(Users user) {
        if( !(contactRepository.existsByEmailAndId(user.getEmail(),user.getId()))){
            if(contactRepository.existsByEmail(user.getEmail())){
                return new MessageResponse(false ,"Email existant ");

            }
        }
        if( !(userRepository.existsByUsernameAndId(user.getUsername(),user.getId()))){
            if(userRepository.existsByUsername(user.getUsername())){
                return new MessageResponse(false ,"Nom utilisateur existant ");

            }
        }

        userRepository.save(user);
        return  new MessageResponse(true ,"utilistaeur bien modifié ");
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(Integer id) {
       return userRepository.findById(id).orElse(null);
    }

    @Override
    public MessageResponse changePassword(PasswordDTO pwdDTO) {
        return null;
    }
}
