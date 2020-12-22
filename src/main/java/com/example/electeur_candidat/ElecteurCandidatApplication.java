package com.example.electeur_candidat;


import com.example.electeur_candidat.entities.Users;
import com.example.electeur_candidat.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@SpringBootApplication(exclude = {
//		MongoAutoConfiguration.class,
//		MongoDataAutoConfiguration.class
//})
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class ElecteurCandidatApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElecteurCandidatApplication.class, args);
	}

	@Autowired
	private UsersService usersService ;

	@Override
	public void run(String... args) throws Exception {

//		Users user = new Users();
//		user.setId(3);
//		user.setNom("Rami");
//		user.setEmail("Rami@gamil.com");
//		user.setUsername("admin");
//		user.setPassword("admin");
//		user.setRole("ADMIN");
//		usersService.save(user);

		}
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}


}
