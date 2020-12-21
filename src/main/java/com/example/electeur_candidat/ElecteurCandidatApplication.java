package com.example.electeur_candidat;

import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.*;
import com.example.electeur_candidat.repositories.*;
import com.example.electeur_candidat.services.ActivityService;
import com.example.electeur_candidat.services.CandidatService;
import org.apache.catalina.User;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = {
		MongoAutoConfiguration.class,
		MongoDataAutoConfiguration.class
})
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})

public class ElecteurCandidatApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElecteurCandidatApplication.class, args);
	}

	@Autowired
	CandidatRepository candidatRepository;
	@Autowired
	ActivityRepository activityRepository ;

	@Autowired
	ExperienceRepository experienceRepository ;
	@Autowired
	CvRepository cvRepository ;
	@Autowired
	PartiRepository partiRepository ;
	@Autowired
	FormationRepository formationRepository ;
	@Autowired
	JustificatifRepository justificatifRepository;
	@Autowired
    DossierJudiciaireRepository dossierJudiciaireRepository ;
	@Autowired
	ListPartisienneRepository listPartisienneRepository ;

	@Autowired
	CandidatService candidatService;
	@Override
	public void run(String... args) throws Exception {

		/*Experience exp = new Experience();
		exp.setId(1);
		exp.setDescription("10 ans d'experience en droit ");
		exp.setDomaine("Droit");
		exp.setNombreAnnée(10);
		experienceRepository.save(exp);

		Formation form = new Formation();
		form.setId(1);
		form.setType("Informatique");
		form.setDescription("formation a l'institut isg");
        formationRepository.save(form);

		Formation form1 = new Formation();
		form1.setId(2);
		form1.setType("Informatique");
		form1.setDescription("formation a l'institut isg");
		form1.setDurée(40);
		formationRepository.save(form1);


		Experience ex= new Experience();
		ex.setId(2);
		ex.setDescription("10 ans d'experience en politique ");
		ex.setDomaine("politique");
		ex.setNombreAnnée(10);
		experienceRepository.save(ex);

		Experience ex1= new Experience();
		ex1.setId(3);
		ex1.setDescription("10 ans d'experience en politique ");
		ex1.setDomaine("politique");
		ex1.setNombreAnnée(10);
		ex1.setScoreExp(0);
		experienceRepository.save(ex1);

		Justificatif justificatif = new Justificatif();
		justificatif.setId(1);
		justificatif.setType("Certification");
		justificatifRepository.save(justificatif);

		Activity activity = new Activity();
		activity.setId(1);
		activity.setDuree(60);
		activity.setDescription("Visite hopital");
		activity.setEmpalcement("Hopital");
		activity.setJustificatifs(Arrays.asList(new Justificatif[] {justificatif}));
		activity.setTitulaire("Good Life for all");
		activity.setType("Humanité");
		activity.setNombrePersonneIn(100);
		activityRepository.save(activity);

        DossierJudiciaire dossierJudiciaire = new DossierJudiciaire();
        dossierJudiciaire.setCodeDossier((long) 0001);
        dossierJudiciaire.setCrime("falsification");
        dossierJudiciaire.setJuridiction(2);
        dossierJudiciaire.setPeine("prison");
        dossierJudiciaireRepository.save(dossierJudiciaire);


		Cv cv = new Cv();
		cv.setId(2);
		cv.setExperiences(Arrays.asList(new Experience[] {exp , ex}));
		cv.setFormations(Arrays.asList(new Formation[] {form}));
		cv.setActivities(Arrays.asList(new Activity[] {activity}));
		cv.setDossierJudiciaires(Arrays.asList(new DossierJudiciaire[] {dossierJudiciaire}));
		cvRepository.save(cv);

		Parti par = new Parti();
		par.setId(1);
		par.setNom("Nahdha");
		par.setOrientationPolitique("Droite");
		par.setSlogan("7oureya karama 3adela");
		partiRepository.save(par);

		Parti p = new Parti();
		p.setId(2);
		p.setNom("Nidham");
		p.setOrientationPolitique("Droite");
		p.setSlogan("7oureya ");
		partiRepository.save(par);

		Parti p1= new Parti();
		p1.setId(3);
		p1.setNom("Courage");
		p1.setOrientationPolitique("Droite");
		p1.setSlogan("courage");
		partiRepository.save(par);



		Candidat candidat = new Candidat();
		candidat.setId(1);
		candidat.setNom("ahmed");
		candidat.setPrenom("rami");
		candidat.setPosition(1);
		candidat.setDateNaissance(LocalDate.of(1950 ,12 ,24));
		candidat.setAge(40);
		candidat.setEmail("AhmedRami@gmail.com");
		candidat.setJob("juge");
		//candidat.setPhoto(data);
		candidat.setPartis(par);
		candidat.setFacebook("ahmedAhmed");
		candidat.setTwitter("ahmedAhmed");
		candidatRepository.save(candidat);
/////////


		Candidat candidat1 = new Candidat();
		candidat1.setId(2);
		candidat1.setNom("Hedi");
		candidat1.setPrenom("rami");
		candidat1.setPosition(1);
		candidat1.setDateNaissance(LocalDate.of(1950 ,12 ,24));
		candidat1.setAge(20);
		candidat1.setEmail("HediRami@gmail.com");
		candidat1.setJob("juge");
		//candidat.setPhoto(data);
		float d = candidatService.scoring(2);
		candidat1.setScore(d);
		candidat1.setFacebook("ahmedAhmed");
		candidat1.setTwitter("ahmedAhmed");
		candidatRepository.save(candidat1);

		ListPartisienne listPartisienne = new ListPartisienne();
		listPartisienne.setId(1);
		listPartisienne.setGouvernorat("Ariana");
		listPartisienne.setNom("Union");
		listPartisienne.setPartis(Arrays.asList(new Parti[] {p , p1}));
		listPartisienne.setCandidatList(Arrays.asList(new Candidat[] {candidat}));
		listPartisienneRepository.save(listPartisienne);





		Activity activity999 = new Activity();
		activity999.setId(9999);
		activity999.setDuree(60);
		activity999.setDescription("Visite hopital");
		activity999.setEmpalcement("Hopital");
		activity999.setJustificatifs(Arrays.asList(new Justificatif[] {justificatif}));
		activity999.setTitulaire("Good Life for all");
		activity999.setType("Humanité");
		activity999.setNombrePersonneIn(100);
		activityRepository.save(activity999);


		/*Contact contact = new Contact();
		contact.setId(3);
		contact.setEmail("aghghg");
		contact.setNom("ahla");
		contact.setPrenom("bagha");

		contactRepository.save(contact);
		System.out.println(contact);*/
		/*Candidat candidat = new Candidat();
		candidat.setScore((float) 0.0);
		candidat.setNom("ahmed");
		candidat.setId(77);
		candidatRepository.save(candidat);*/

		//ImageConvertToByte
		/*BufferedImage bImage = ImageIO.read(new File("50-Long-Haircuts-Hairstyle-Tips-for-Men-2.jpg"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos );
		byte [] data = bos.toByteArray();*/



		Formation form = new Formation();
		form.setId(1);
		form.setType("Informatique");
		form.setDescription("formation a l'institut isg");
		formationRepository.save(form);

		Formation form1 = new Formation();
		form1.setId(2);
		form1.setType("Informatique");
		form1.setDescription("formation a l'institut isg");
		form1.setDurée(40);
		formationRepository.save(form1);


		Experience ex= new Experience();
		ex.setId(2);
		ex.setDescription("10 ans d'experience en politique ");
		ex.setDomaine("politique");
		ex.setNombreAnnée(10);
		experienceRepository.save(ex);

		Experience ex1= new Experience();
		ex1.setId(3);
		ex1.setDescription("10 ans d'experience en politique ");
		ex1.setDomaine("politique");
		ex1.setNombreAnnée(10);
		ex1.setScoreExp(0);
		experienceRepository.save(ex1);

		Justificatif justificatif = new Justificatif();
		justificatif.setId(1);
		justificatif.setType("Certification");
		justificatifRepository.save(justificatif);

		Activity activity = new Activity();
		activity.setId(1);
		activity.setDuree(60);
		activity.setDescription("Visite hopital");
		activity.setEmpalcement("Hopital");
		activity.setJustificatifs(Arrays.asList(new Justificatif[] {justificatif}));
		activity.setTitulaire("Good Life for all");
		activity.setType("Humanité");
		activity.setNombrePersonneIn(100);
		activityRepository.save(activity);

		DossierJudiciaire dossierJudiciaire = new DossierJudiciaire();
		dossierJudiciaire.setCodeDossier((long) 0001);
		dossierJudiciaire.setCrime("falsification");
		dossierJudiciaire.setJuridiction(2);
		dossierJudiciaire.setPeine("prison");
		dossierJudiciaireRepository.save(dossierJudiciaire);


		Cv cv = new Cv();
		cv.setId(2);
		cv.setExperiences(Arrays.asList(new Experience[] { ex}));
		cv.setFormations(Arrays.asList(new Formation[] {form}));
		cv.setActivities(Arrays.asList(new Activity[] {activity}));
		cv.setDossierJudiciaires(Arrays.asList(new DossierJudiciaire[] {dossierJudiciaire}));
		cvRepository.save(cv);

		Parti par = new Parti();
		par.setId(1);
		par.setNom("Nahdha");
		par.setOrientationPolitique("Droite");
		par.setSlogan("7oureya karama 3adela");
		partiRepository.save(par);

		Parti p = new Parti();
		p.setId(2);
		p.setNom("Nidham");
		p.setOrientationPolitique("Droite");
		p.setSlogan("7oureya ");
		partiRepository.save(par);

		Parti p1= new Parti();
		p1.setId(3);
		p1.setNom("Courage");
		p1.setOrientationPolitique("Droite");
		p1.setSlogan("courage");
		partiRepository.save(par);



		Candidat candidat = new Candidat();
		candidat.setId(1);
		candidat.setNom("ahmed");
		candidat.setPrenom("rami");
		candidat.setPosition(1);
		candidat.setAge(40);
		candidat.setEmail("AhmedRami@gmail.com");
		candidat.setJob("juge");
		//candidat.setPhoto(data);
		candidat.setPartis(par);
		candidat.setFacebook("ahmedAhmed");
		candidat.setTwitter("ahmedAhmed");
		candidat.setCvs(cv);
		candidatRepository.save(candidat);





		Formation fo = new Formation();
		fo.setId(10);
		fo.setType("marketing");
		fo.setDescription("formation a l'institut isg");
		formationRepository.save(form);




		Experience e= new Experience();
		e.setId(10);
		e.setDescription("10 ans d'experience en politique ");
		e.setDomaine("politique");
		e.setNombreAnnée(20);
		experienceRepository.save(ex);



		Justificatif justificati = new Justificatif();
		justificati.setId(10);
		justificati.setType("Certification");
		justificatifRepository.save(justificati);

		Activity activit = new Activity();
		activit.setId(1);
		activit.setDuree(60);
		activit.setDescription("Fabirication ");
		activit.setEmpalcement("Tunie palace");
		activit.setJustificatifs(Arrays.asList(new Justificatif[] {justificatif}));
		activit.setTitulaire("Good Life ");
		activit.setType("Humanité");
		activit.setNombrePersonneIn(100);
		activityRepository.save(activit);

		DossierJudiciaire dossierJudiciair = new DossierJudiciaire();
		dossierJudiciair.setCodeDossier((long) 0004);
		dossierJudiciaire.setCrime("falsification");
		dossierJudiciaire.setJuridiction(4);
		dossierJudiciaire.setPeine("arret");
		dossierJudiciaireRepository.save(dossierJudiciaire);


		Cv c = new Cv();
		c.setId(4);
		c.setExperiences(Arrays.asList(new Experience[] { ex}));
		c.setFormations(Arrays.asList(new Formation[] {fo}));
		c.setActivities(Arrays.asList(new Activity[] {activit}));
		c.setDossierJudiciaires(Arrays.asList(new DossierJudiciaire[] {dossierJudiciair}));
		cvRepository.save(cv);


		Parti po = new Parti();
		po.setId(2);
		po.setNom("Nidham");
		po.setOrientationPolitique("Droite");
		po.setSlogan("7oureya ");
		partiRepository.save(po);




		Candidat candida = new Candidat();
		candida.setId(4);
		candida.setNom("ahmed");
		candida.setPrenom("binou");
		candida.setPosition(1);
		candida.setAge(40);
		candida.setEmail("Ahmedbimi@gmail.com");
		candida.setJob("entrepreneur");
		//candidat.setPhoto(data);
		candida.setPartis(par);
		candida.setFacebook("ahmedAhmedni");
		candida.setTwitter("ahmedAhmedninii");
		candida.setCvs(c);
		candidatRepository.save(candida);















		}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
