"# In process" 

<h3>pring boot Web application ; </h3> <br>

<h3>Spring Data MongoDB :</h3>Data access layers <br>
<h3>Spring MVC :</h3> To create An API Rest <br>
<h3>Swagger UI :</h3>API building process To test and visualize and interact with your API <br>

<h3>Les patrons de conception :</h3> <br>
MVC ,<br>
DTO : for the best practice <br>

<h3>Project management :</h3><br>
Maven <br>

<h3>Tools:</h3> <br>
MongoDb , MongoDbCompass , IntellJ <br>

<h3>Packages :</h3><br>
com.exemple.electeur_candidat.Config : Config Files such as SpringSecurity config files , swagger config ...<br>
com.exemple.electeur_candidat.entities<br>
com.exemple.electeur_candidat.repositories<br>
com.exemple.electeur_candidat.services<br>
com.exemple.electeur_candidat.serviceImpl<br>
com.exemple.electeur_candidat.controllers<br>
com.exemple.electeur_candidat.DTO : MessageResponse(Returns boolean and String (Message)) , PasswordDTO (userid,oldPassword , newPassword))<br>

<h3>Dependencies To add into po.xml :</h3> <br>
<h3>Spring Boot Starter Data MongoDB (Source Maven Repository ):</h3><br>
 for using MongoDB document-oriented database and Spring Data MongoDB<br>
 
   <dependency><br>
			<groupId>org.springframework.boot</groupId><br>
			<artifactId>spring-boot-starter-data-mongodb</artifactId><br>
		</dependency><br>
    
<h3>Swagger :</h3><br>
 <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 --><br>
		<dependency><br>
			<groupId>io.springfox</groupId><br>
			<artifactId>springfox-swagger2</artifactId><br>
			<version>2.9.2</version><br>
		</dependency><br>

		<dependency><br>
			<groupId>io.springfox</groupId><br>
			<artifactId>springfox-swagger-ui</artifactId><br>
			<version>2.9.2</version><br>
	>	</dependency>
