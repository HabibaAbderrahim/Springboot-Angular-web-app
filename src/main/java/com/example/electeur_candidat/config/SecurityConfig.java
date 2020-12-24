package com.example.electeur_candidat.config;

import com.example.electeur_candidat.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthentificationFilter jwtAuthentificationFilter;
    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;
    @Autowired
    private UsersService usersService ;

    //Avant liaison avec base statique an d for test
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin").password("admin1").authorities("ROLE_admin");
//        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("habiba").password("admin12").authorities("ROLE_user");

      auth.userDetailsService(usersService).passwordEncoder(passwordEncoder());
    }

    //http pour securiser mon url des pages
    //redif bech nod5el fi 5edmtou
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //desactifer CSRF token (gener automatiquement par spring sec or i will use a JWT token !)
        http.csrf().disable();
        //AS CROSS ORIGINE!!!!!!
        http.cors();
        //change sec Mannagement (Im not using basic web security)
        //Gere session spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //7alit  el la3b 3al login login accesible lel ness el kol
        http.authorizeRequests().antMatchers("/login").permitAll();

        //bech nal3eb aal access le requet mte3i
        //ay requet apart el login bech tlansiha lezemha authentification
        http.authorizeRequests().anyRequest().authenticated();

        //-------------------------------------------------------------------
        //Adding My filters To the configure So he could handle Them
        http.addFilter(jwtAuthentificationFilter);
        //Ma ye5dem eli ma ba3d Auth Val
        http.addFilterAfter(jwtAuthorizationFilter , JwtAuthentificationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**",
                "/swagger-ui.html", "/webjars/**");

    }

    //FOR THE FRONT
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");

        configuration.addAllowedMethod("*");

        configuration.addExposedHeader("Authorization");
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);}

        //Filter authenticatian

    //caused By authefi manager must be defiened
    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        //auth manager Class mere
        return super.authenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}