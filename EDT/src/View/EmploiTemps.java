/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ENSEIGNANT_EDT;
import Controller.EtudiantEDT;
import Controller.REPORTING_DONNEE;
import Controller.SALLE_EDT;
import Controller.SEANCE_GROUPE;
import Model.COURS;
import Model.ETUDIANT;
import Model.GROUPE;
import Model.SALLE;
import Model.SEANCE;
import Model.TYPE_COURS;
import Model.UTILISATEUR;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Antoine
 */

/** Fonction qui recupere les données du <b>controller</b> et qui s'occupe de les associer avec le <b>view</b> (Swing)*/
public class EmploiTemps {
    private EtudiantEDT studentEDT = new EtudiantEDT();
    private List<SEANCE> listSEANCE =new ArrayList<>();
    private List<SALLE> listSALLE =new ArrayList<>();
    private List<UTILISATEUR> listeENSEIGNANT = new ArrayList<>();
    private List<TYPE_COURS> listeTYPE_COURS = new ArrayList<>();
    private List<COURS> listeCOURS = new ArrayList<>();
    private List <GROUPE> listGROUPE = new ArrayList<>();
    private int compteur=0;
  
    public EmploiTemps(){}
    
    /** Recupere le String du nom d'un etudiant et la semaine pour rentrer les données dans un tableau d'Object renvoyé à la fin pour l'affichage par l'etudiant*/
    public Object[][] emploidutempsetudiant(ETUDIANT student, int semaine){
        
        //Creation de l'objet qui contient les données de l'etudiant
    studentEDT.voirETUDIANT_SEANCE(student.getNOM(), semaine);
    //Recuperation des données sur les cours de l'etudiant dans la classe
    listSEANCE = studentEDT.getlistSEANCE();
    listSALLE = studentEDT.getListSALLE();
    listeTYPE_COURS = studentEDT.getListTYPE_COURS();
    listeCOURS = studentEDT.getListCOURS();
    listeENSEIGNANT = studentEDT.getlistENSEIGNANT();
    int compteur=0;
    

    //Données du tableau
    Object[][] data = remplissage();
    
    for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                System.out.println("VOICI LE COURS VERSION2 : " + listeCOURS.get(compteur).getNOM());
                data[coordo.gety()][coordo.getx()] = "Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            }
            else if(i.getETAT()==0)
            {
                data[coordo.gety()][coordo.getx()] = "ANNULE : Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            }
            else if(i.getETAT()==2)
            {
                data[coordo.gety()][coordo.getx()] = "EN COURS DE VALIDATION : Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            }
            compteur++;
        }
    }
    return data;
    }
    
    /** Recupere le String d'une salle et la semaine pour rentrer les données dans un tableau d'Object renvoyé à la fin pour l'affichage par un admin*/
    public Object[][] emploidutempssalle(SALLE salle, int semaine){
        SALLE_EDT edtsalle = new SALLE_EDT();
        edtsalle.voirSALLE_EDT(salle.getNOM());
        listSEANCE = edtsalle.getlistSEANCE();
        listeTYPE_COURS = edtsalle.getListTYPE_COURS();
        listeCOURS = edtsalle.getListCOURS();
        listeENSEIGNANT = edtsalle.getlistENSEIGNANT();
        compteur=0;

    //Données du tableau
    Object[][] data = remplissage();
    for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM()+" et "+ groupe(listGROUPE) ;
            }
            if(i.getETAT()==0){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "ANNULE : Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM()+" et "+ groupe(listGROUPE) ;
            }
            if(i.getETAT()==2){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "EN COURS DE VALIDATION : Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM()+" et "+ groupe(listGROUPE) ;
            }
            compteur++;
        }
        }
    return data;
    }
    /** Recupere le String du nom d'un professeur et la semaine pour rentrer les données dans un tableau d'Object renvoyé à la fin pour l'affichage par le professeur*/
    public Object[][] emploidutempsenseignant(UTILISATEUR enseignant, int semaine){
        ENSEIGNANT_EDT edtenseignant = new ENSEIGNANT_EDT();
        edtenseignant.voirENSEIGNANT_EDT(enseignant.getNOM(),semaine);
        listSEANCE = edtenseignant.getlistSEANCE();
        listSALLE = edtenseignant.getListSALLE();
        listeTYPE_COURS = edtenseignant.getListTYPE_COURS();
        listeCOURS = edtenseignant.getListCOURS();
        listeENSEIGNANT = edtenseignant.getlistENSEIGNANT();
        
        for(SALLE salle : listSALLE)
        {
            System.out.println(salle.getNOM());
        }
        
        compteur=0;

    //Données du tableau
    Object[][] data = remplissage();
    for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+ groupe(sgroup.getlistGROUPE());
            }
            if(i.getETAT()==0){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "ANNULE : Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+ groupe(sgroup.getlistGROUPE());
            }
            if(i.getETAT()==2){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "EN COURS DE VALIDATION : Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+ groupe(sgroup.getlistGROUPE());
            }
            compteur++;
        }
    }
    return data;
    }

    /** Recupere le String du nom d'un professeur et la semaine pour rentrer les données dans un tableau d'Object renvoyé à la fin pour l'affichage par un admin*/
    public Object[][] voiremploidutempsenseignant(String enseignant, int semaine){
        ENSEIGNANT_EDT edtenseignant = new ENSEIGNANT_EDT();
        edtenseignant.voirENSEIGNANT_EDT(enseignant,semaine);
        listSEANCE = edtenseignant.getlistSEANCE();
        listSALLE = edtenseignant.getListSALLE();
        listeTYPE_COURS = edtenseignant.getListTYPE_COURS();
        listeCOURS = edtenseignant.getListCOURS();
        listeENSEIGNANT = edtenseignant.getlistENSEIGNANT();
        compteur=0;

    //Données du tableau
    Object[][] data = remplissage();
    for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+ groupe(sgroup.getlistGROUPE());
            }
            compteur++;
        }
    }
    return data;
    }
    
    /** Recupere le String du nom d'un etudiant et la semaine pour rentrer les données dans un tableau d'Object renvoyé à la fin pour l'affichage par un admin*/
    public Object[][] voiremploidutempsetudiant(String nomet, int semaine){
        
        //Creation de l'objet qui contient les données de l'etudiant
    studentEDT.voirETUDIANT_SEANCE(nomet,semaine);
    //Recuperation des données sur les cours de l'etudiant dans la classe
    listSEANCE = studentEDT.getlistSEANCE();
    listSALLE = studentEDT.getListSALLE();
    listeTYPE_COURS = studentEDT.getListTYPE_COURS();
    listeCOURS = studentEDT.getListCOURS();
    listeENSEIGNANT = studentEDT.getlistENSEIGNANT();
    compteur=0;

    //Données du tableau
    Object[][] data = remplissage();
    
    for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                data[coordo.gety()][coordo.getx()] = "Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            }
            compteur++;
        }
    }
    return data;
    }
    
    /** Recupere le String d'une salle et la semaine pour rentrer les données dans un tableau d'Object renvoyé à la fin pour l'affichage par un admin*/
    public Object[][] voiremploidutempssalle(String salle, int semaine){
        SALLE_EDT edtsalle = new SALLE_EDT();
        edtsalle.voirSALLE_EDT(salle);
        listSEANCE = edtsalle.getlistSEANCE();
        listeTYPE_COURS = edtsalle.getListTYPE_COURS();
        listeCOURS = edtsalle.getListCOURS();
        listeENSEIGNANT = edtsalle.getlistENSEIGNANT();
        compteur=0;

    //Données du tableau
    Object[][] data = remplissage();
    for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM()+" et "+ groupe(listGROUPE) ;
            }
            compteur++;
        }
        }
    return data;
    }
    
    /**Rempli le tableau avec les horaires */
    public Object[][] remplissage() {
    Object[][] donnee = {
    {"8h30-10h", "", "", "", "", ""},
      {"10h15-11h45", "", "", "", "", ""},
      {"12h-13h30", "", "", "", "", ""},
      {"13h45-15h15", "", "", "", "", ""},
      {"15h30-17h", "", "", "", "", ""},
      {"17h15-18h45","", "", "", "", ""}
    };
    return donnee;
}
    
    /**Cherche quel est le jour et l'heure de la seance*/
    public Coordonnees findJour(SEANCE cours){
        Coordonnees coord = new Coordonnees();
        switch(cours.getDATE())
        {
            case ("LUNDI") :
            {
                coord.setx(1);
                break;
            }
            case ("MARDI") :
            {
                coord.setx(2);
                break;
            }
            case ("MERCREDI") :
            {
                coord.setx(3);
                break;
            }
            case ("JEUDI") :
            {
                coord.setx(4);
                break;
            }
            case ("VENDREDI") :
            {
                coord.setx(5);
                break;
            }
        }
        switch(cours.getHEURE_DEBUT())
        {
            case ("8h30") :
            {
                coord.sety(0);
                break;
            }
            case ("10h15") :
            {
                coord.sety(1);
                break;
            }
            case ("12h") :
            {
                coord.sety(2);
                break;
            }
            case ("13h45") :
            {
                coord.sety(3);
                break;
            }
            case ("15h30") :
            {
                coord.sety(4);
                break;
            }
            case ("17h15") :
            {
                coord.sety(5);
                break;
            }
        }
        return coord;
    }
    
    /**Crée l'entete du tableau*/
    public String[] setTitle(){
        String  title[] = {"Heure","Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
        return title;
    }
    
    /**Cree un String de groupe de TD qui ont cours*/
    public String groupe(List <GROUPE> list)
    {
        String grp = new String();
        if(list.size() == 1)
            grp = "Le groupe "+list.get(0).getNOM();
        else if(list.size() > 1)
        {
            grp = "Les groupes : ";
            for(GROUPE i : list)
                grp += i.getNOM()+",";
        }
        return grp;
    }

    /** Recupere un tableau d'objet qui est rempli avec le descriptif des cours */
    public Object[][] reporting(UTILISATEUR leprof)
    {
        List<UTILISATEUR> listprof =new ArrayList<>();
        List <Integer> nbSeance =new ArrayList<>();
        List<COURS> listCOURS =new ArrayList<>();
        List<SEANCE> listSEANCEprems =new ArrayList<>();
        List<SEANCE> listSEANCElast =new ArrayList<>();
        
        REPORTING_DONNEE report = new REPORTING_DONNEE();
        
        report.REPORTING_DONNEE();
        
        listprof = report.getlistENSEIGNANT();
        nbSeance = report.getnbSeance();
        listCOURS = report.getlistCOURS();
        listSEANCEprems = report.getlistSEANCEprems();
        listSEANCElast = report.getlistCOURSlast();
        
        int compteur = 0;
        Object[][] data = {
      {"", "", "", "", ""},
      {"", "", "", "", ""},
      {"", "", "", "", ""},
      {"", "", "", "", ""},
      {"", "", "", "", ""}
    };
        int cours=0;
        for(UTILISATEUR iprof : listprof)
        {
            if(iprof.getID() == leprof.getID())
            {
                data[cours][0] = listCOURS.get(compteur).getNOM();
                data[cours][1] = "Semaine "+ listSEANCEprems.get(compteur).getSEMAINE()+" "+listSEANCEprems.get(compteur).getDATE()+" à "+listSEANCEprems.get(compteur).getHEURE_DEBUT();
                data[cours][2] = "Semaine "+ listSEANCElast.get(compteur).getSEMAINE()+" "+listSEANCElast.get(compteur).getDATE()+" à "+listSEANCElast.get(compteur).getHEURE_DEBUT();
                data[cours][3] = nbSeance.get(compteur)*1.5 +"h";
                data[cours][4] = nbSeance.get(compteur);
                cours++;
            }
            compteur++;
        }
        return data;
    }

}
