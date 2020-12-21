package com.example.electeur_candidat;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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


	@Override
	public void run(String... args) throws Exception {

		}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
