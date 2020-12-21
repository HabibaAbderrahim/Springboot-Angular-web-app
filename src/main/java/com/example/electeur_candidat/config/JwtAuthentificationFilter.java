package com.example.electeur_candidat.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.electeur_candidat.entities.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${jwt.signin-key}")
    private String signkey;
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.prefix}")
    private String prefix;
    @Value("${jwt.exp-time}")
    private long expTime;

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        Users usera = new Users();
        //req traja3 json lezem nraj3 objet (user) b jackon
        ObjectMapper mapper = new ObjectMapper();
        try {
            usera = mapper.readValue(request.getInputStream(), Users.class);

            //System.out.println(usera);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(usera.getUsername(), usera.getPassword()));

    }
    //F1 T3ADIT AAL AUTHENTIF
    //F2 TOKEN

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {


//           String username = authResult.getName();
//           List<String>  authorities = new ArrayList<>();
//           authResult.getAuthorities().forEach(role ->{
//               authorities.add(role.getAuthority());
//           });
//           String token = Jwts.builder().setSubject(username).claim("roles", authorities).setIssuedAt(new Date(System.currentTimeMillis())).
//                   setExpiration(new Date(System.currentTimeMillis()+ expTime)).signWith(SignatureAlgorithm.HS512, signkey.getBytes()).
//                   compact();
//
//           response.addHeader(header , prefix+token);
//    }
    }
}