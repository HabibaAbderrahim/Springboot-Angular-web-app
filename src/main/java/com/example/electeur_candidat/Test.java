package com.example.electeur_candidat;

import com.example.electeur_candidat.entities.*;
import com.example.electeur_candidat.repositories.*;
import com.example.electeur_candidat.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class Test implements CommandLineRunner {
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

//        Formation form = new Formation();
//        form.setId(1);
//        form.setType("Informatique");
//        form.setDescription("formation a l'institut isg");
//        formationRepository.save(form);
//
//        Formation form1 = new Formation();
//        form1.setId(2);
//        form1.setType("Informatique");
//        form1.setDescription("formation a l'institut isg");
//        form1.setDurée(40);
//        formationRepository.save(form1);
//
//
//        Experience ex= new Experience();
//        ex.setId(2);
//        ex.setDescription("10 ans d'experience en politique ");
//        ex.setDomaine("politique");
//        ex.setNombreAnnée(10);
//        experienceRepository.save(ex);
//
//        Experience ex1= new Experience();
//        ex1.setId(3);
//        ex1.setDescription("10 ans d'experience en politique ");
//        ex1.setDomaine("politique");
//        ex1.setNombreAnnée(10);
//        ex1.setScoreExp(0);
//        experienceRepository.save(ex1);
//
//        Justificatif justificatif = new Justificatif();
//        justificatif.setId(1);
//        justificatif.setType("Certification");
//        justificatifRepository.save(justificatif);
//
//        Activity activity = new Activity();
//        activity.setId(1);
//        activity.setDuree(60);
//        activity.setDescription("Visite hopital");
//        activity.setEmpalcement("Hopital");
//        activity.setJustificatifs(Arrays.asList(new Justificatif[] {justificatif}));
//        activity.setTitulaire("Good Life for all");
//        activity.setType("Humanité");
//        activity.setNombrePersonneIn(100);
//        activityRepository.save(activity);
//
//        DossierJudiciaire dossierJudiciaire = new DossierJudiciaire();
//        dossierJudiciaire.setCodeDossier((long) 0001);
//        dossierJudiciaire.setCrime("falsification");
//        dossierJudiciaire.setJuridiction(2);
//        dossierJudiciaire.setPeine("prison");
//        dossierJudiciaireRepository.save(dossierJudiciaire);
//
//
//        Cv cv = new Cv();
//        cv.setId(2);
//        cv.setExperiences(Arrays.asList(new Experience[] { ex}));
//        cv.setFormations(Arrays.asList(new Formation[] {form}));
//        cv.setActivities(Arrays.asList(new Activity[] {activity}));
//        cv.setDossierJudiciaires(Arrays.asList(new DossierJudiciaire[] {dossierJudiciaire}));
//        cvRepository.save(cv);
//
//        Parti par = new Parti();
//        par.setId(1);
//        par.setNom("Nahdha");
//        par.setOrientationPolitique("Droite");
//        par.setSlogan("7oureya karama 3adela");
//        partiRepository.save(par);
//
//        Parti p = new Parti();
//        p.setId(2);
//        p.setNom("Nidham");
//        p.setOrientationPolitique("Droite");
//        p.setSlogan("7oureya ");
//        partiRepository.save(par);
//
//        Parti p1= new Parti();
//        p1.setId(3);
//        p1.setNom("Courage");
//        p1.setOrientationPolitique("Droite");
//        p1.setSlogan("courage");
//        partiRepository.save(par);
//
//
//
//        Candidat candidat = new Candidat();
//        candidat.setId(1);
//        candidat.setNom("ahmed");
//        candidat.setPrenom("rami");
//        candidat.setPosition(1);
//        candidat.setAge(40);
//        candidat.setEmail("AhmedRami@gmail.com");
//        candidat.setJob("juge");
//        //candidat.setPhoto(data);
//        candidat.setPartis(par);
//        candidat.setFacebook("ahmedAhmed");
//        candidat.setTwitter("ahmedAhmed");
//        candidat.setCvs(cv);
//        candidatRepository.save(candidat);
//
//
//
//
//
//        Formation fo = new Formation();
//        fo.setId(10);
//        fo.setType("marketing");
//        fo.setDescription("formation a l'institut isg");
//        formationRepository.save(form);
//
//
//
//
//        Experience e= new Experience();
//        e.setId(10);
//        e.setDescription("10 ans d'experience en politique ");
//        e.setDomaine("politique");
//        e.setNombreAnnée(20);
//        experienceRepository.save(ex);
//
//
//
//        Justificatif justificati = new Justificatif();
//        justificati.setId(10);
//        justificati.setType("Certification");
//        justificatifRepository.save(justificati);
//
//        Activity activit = new Activity();
//        activit.setId(1);
//        activit.setDuree(60);
//        activit.setDescription("Fabirication ");
//        activit.setEmpalcement("Tunie palace");
//        activit.setJustificatifs(Arrays.asList(new Justificatif[] {justificatif}));
//        activit.setTitulaire("Good Life ");
//        activit.setType("Humanité");
//        activit.setNombrePersonneIn(100);
//        activityRepository.save(activit);
//
//        DossierJudiciaire dossierJudiciair = new DossierJudiciaire();
//        dossierJudiciair.setCodeDossier((long) 0004);
//        dossierJudiciaire.setCrime("falsification");
//        dossierJudiciaire.setJuridiction(4);
//        dossierJudiciaire.setPeine("arret");
//        dossierJudiciaireRepository.save(dossierJudiciaire);
//
//
//        Cv c = new Cv();
//        c.setId(4);
//        c.setExperiences(Arrays.asList(new Experience[] { ex}));
//        c.setFormations(Arrays.asList(new Formation[] {fo}));
//        c.setActivities(Arrays.asList(new Activity[] {activit}));
//        c.setDossierJudiciaires(Arrays.asList(new DossierJudiciaire[] {dossierJudiciair}));
//        cvRepository.save(cv);
//
//
//        Parti po = new Parti();
//        po.setId(2);
//        po.setNom("Nidham");
//        po.setOrientationPolitique("Droite");
//        po.setSlogan("7oureya ");
//        partiRepository.save(po);




        Candidat candida = new Candidat();
        candida.setId(5);
        candida.setNom("ahmed");
        candida.setPrenom("binou");
        candida.setPosition(1);
        candida.setAge(40);
        candida.setEmail("Ahmedb@gmail.com");
        candida.setJob("entrepreneur");
        //candidat.setPhoto(data);
        candida.setFacebook("ahmedAhmedni");
        candida.setTwitter("ahmedAhmedninii");
        candidatRepository.save(candida);

    }
}
