package com.example.electeur_candidat.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@Document
public class Users extends Contact implements UserDetails {
    //Objet de type UserDetail
   //NB In case usename and passw # nzid getser b esm #
    private String username ;
    private String password ;
    private String role ;

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                "} " + super.toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //mdp akther men mara faut
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //jme3et kol 6 ybadlou mdp
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //les comptes par defaut des
    @Override
    public boolean isEnabled() {
        return true;
    }
}
