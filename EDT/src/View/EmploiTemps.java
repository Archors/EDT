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
//classe pour afficher les emplois du temps en grille
public class EmploiTemps {
    private EtudiantEDT studentEDT = new EtudiantEDT();
    private List<SEANCE> listSEANCE =new ArrayList<>();
    private List<SALLE> listSALLE =new ArrayList<>();
    private List<UTILISATEUR> listeENSEIGNANT = new ArrayList<>();
    private List<TYPE_COURS> listeTYPE_COURS = new ArrayList<>();
    private List<COURS> listeCOURS = new ArrayList<>();
    private List <GROUPE> listGROUPE = new ArrayList<>();
    private int compteur=0;
  
    public EmploiTemps(){
        
    }
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

    public Object[][] voiremploidutempssalle(String salles, int semaine){
        SALLE_EDT edtsalle = new SALLE_EDT();
        edtsalle.voirSALLE_EDT(salles);
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
    
    //Rempli le tableau avec les horaires
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
    
    //Cherche quel est le jour et l'heure de la seance
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
    
    //Crée l'entete du tableau
    public String[] setTitle(){
        String  title[] = {"Heure","Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
        return title;
    }
    
    //Cree un String de groupe de TD qui ont cours
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
    
    /*public Object[][] reporting(UTILISATEUR leprof)
    {
        List<UTILISATEUR> listprof =new ArrayList<>();
        List <Integer> nbSeance =new ArrayList<Integer>();
        
        ENSEIGNANT_EDT edtenseignant = new ENSEIGNANT_EDT();
        edtenseignant.voirENSEIGNANT_EDT(leprof.getNOM());
        listSEANCE = edtenseignant.getlistSEANCE();
        listSALLE = edtenseignant.getListSALLE();
        listeTYPE_COURS = edtenseignant.getListTYPE_COURS();
        listeCOURS = edtenseignant.getListCOURS();
        listeENSEIGNANT = edtenseignant.getlistENSEIGNANT();
        List<SEANCE> premieresemaine =new ArrayList<>();
        List<SEANCE> premierjour =new ArrayList<>();
        List<SEANCE> dernieresemaine =new ArrayList<>();
        List<SEANCE> dernierjour =new ArrayList<>();
        //String cours1 = new String();
        //String cours2 = new String();
        //int compteurcours1 = 0;
        //3int compteurcours2 = 0;
        
        Object[][] data = {
      {"", "", "", "", ""},
      {"", "", "", "", ""},
      {"", "", "", "", ""},
      {"", "", "", "", ""},
      {"", "", "", "", ""}
    };
        REPORTING_DONNEE report = new REPORTING_DONNEE();
        report.REPORTING_DONNEE();
        listprof = report.getlistENSEIGNANT();
        nbSeance = report.getnbSeance();
        int compteur = 0;
        int firstsemaine = 0;
        String firstjour = new String();
        SEANCE firstSEANCE = new SEANCE();
        int lastsemaine = 0;
        String lastjour = new String();
        SEANCE lastSEANCE = new SEANCE();
        
        //On cherche la 1ere semaine
        for(int i=0; i<listSEANCE.size();i++)
        {
            if(i==0)
            {
                firstsemaine = listSEANCE.get(0).getSEMAINE();
            }
            
            if(firstsemaine > listSEANCE.get(i).getSEMAINE())
            {
                firstsemaine = listSEANCE.get(i).getSEMAINE();
            }
            
        }
        //On ajoute a la liste toute les seance de la 1ere semaine
        for(SEANCE i : listSEANCE)
        {
            if(firstsemaine == i.getSEMAINE()){
                premieresemaine.add(i);
            }
        }
        System.out.println("Il y a "+premieresemaine.size()+" cours la premiere semaine");
        //On cherche le jour de la permiere seance
        for(int i=0; i<premieresemaine.size();i++)
        {
            if(i==0)
            {
                firstjour = premieresemaine.get(0).getDATE();
                System.out.println(premieresemaine.get(0).getDATE());
                if(firstjour.equals("LUNDI"))
                    break;
            }
            System.out.println("firstjour= "+firstjour);
            if(firstjour.compareTo("VENDREDI") == 0)
            {
                if(firstjour.compareTo(premieresemaine.get(i).getDATE()) != 0)
                    firstjour = premieresemaine.get(i).getDATE();
            }
            if (firstjour.compareTo("JEUDI") == 0 && firstjour.compareTo(premieresemaine.get(i).getDATE()) < 0 && firstjour.compareTo("VENDREDI") != 0)
                firstjour = premieresemaine.get(i).getDATE();
            if (firstjour.compareTo("MERCREDI") == 0 && firstjour.compareTo(premieresemaine.get(i).getDATE()) > 0 && firstjour.compareTo("JEUDI") != 0)
                firstjour = premieresemaine.get(i).getDATE();
            if (firstjour.compareTo("MARDI") == 0 && firstjour.compareTo(premieresemaine.get(i).getDATE()) < 0 && firstjour.compareTo("JEUDI") != 0)
                firstjour = premieresemaine.get(i).getDATE();
            if(firstjour.equals("LUNDI"))
                break;
        }
        //On ajoute à la liste toutes les seances du premier jour
        for(SEANCE i : premieresemaine)
        {
            if(firstjour.equals(i.getDATE()))
                premierjour.add(i);
        }
        //On cherche l'heure de la première seance
        for(int i =0 ; i<premierjour.size();i++)
        {
            if(i==0)
            {
                firstSEANCE = premierjour.get(0);
                if(firstSEANCE.getHEURE_DEBUT().equals("8h30")){
                    firstSEANCE = premierjour.get(0);
                    break;
                }
            }
            if (firstSEANCE.getHEURE_DEBUT().compareTo(premierjour.get(i).getHEURE_DEBUT()) > 0)
                firstSEANCE = premierjour.get(i);
            if(firstSEANCE.getHEURE_DEBUT().equals("8h30"))
                break;
        }
        
        
        //On cherche la derniere semaine
        for(int i=0; i<listSEANCE.size();i++)
        {
            if(i==0)
            {
                lastsemaine = listSEANCE.get(0).getSEMAINE();
            }
                else if(lastsemaine < listSEANCE.get(i).getSEMAINE())
            {
                lastsemaine = listSEANCE.get(i).getSEMAINE();
            }
            
        }
        //On ajoute a la liste toute les seance de la derniere semaine
        for(SEANCE i : listSEANCE)
        {
            if(lastsemaine == i.getSEMAINE())
                dernieresemaine.add(i);
        }
        //On cherche le jour de la derniere seance
        for(int i=0; i<dernieresemaine.size();i++)
        {
            if(i==0)
            {
                lastjour = dernieresemaine.get(0).getDATE();
                if(lastjour.compareTo("VENDREDI")== 0)
                    break;
            }
            if(lastjour.compareTo("LUNDI")== 0 && lastjour.compareTo(dernieresemaine.get(i).getDATE()) != 0)
            {
                lastjour = premieresemaine.get(i).getDATE();
            }
            if (lastjour.compareTo("MARDI")== 0 && (lastjour.compareTo(dernieresemaine.get(i).getDATE()) < 0 || lastjour.compareTo("JEUDI")== 0))
                lastjour = dernieresemaine.get(i).getDATE();
            if (lastjour.compareTo("MERCREDI")== 0 && (dernieresemaine.get(i).getDATE().compareTo("JEUDI") == 0 || dernieresemaine.get(i).getDATE().compareTo("VENDREDI") == 0))
                lastjour = dernieresemaine.get(i).getDATE();
            if (lastjour.compareTo("JEUDI")== 0 && dernieresemaine.get(i).getDATE().compareTo("VENDREDI") == 0)
                lastjour = dernieresemaine.get(i).getDATE();
            if(lastjour.compareTo("VENDREDI")== 0)
                break;
        }
        //On ajoute à la liste toutes les seances du premier jour
        for(SEANCE i : dernieresemaine)
        {
            if(lastjour.compareTo(i.getDATE()) == 0)
                dernierjour.add(i);
        }
        System.out.println("taille :" +dernierjour.size());
        //On cherche l'heure de la première seance
        for(int i =0 ; i<dernierjour.size();i++)
        {
            if(i==0)
            {
                lastSEANCE = dernierjour.get(0);
                if(lastSEANCE.getHEURE_DEBUT().equals("17h15")){
                    lastSEANCE = dernierjour.get(0);
                    break;
                }
            }
            if (lastSEANCE.getHEURE_DEBUT().compareTo(dernierjour.get(i).getHEURE_DEBUT()) < 0)
                lastSEANCE = dernierjour.get(i);
            if(lastSEANCE.getHEURE_DEBUT().equals("17h15"))
                break;
        }
        
        
        for(UTILISATEUR iprof : listprof)
        {
            iprof.afficherUTILISATEUR();
            if(iprof.getID() == leprof.getID())
            {
                data[0][0] = listeCOURS.get(0).getNOM();
                data[0][1] = "Semaine " +firstSEANCE.getSEMAINE()+" le "+firstSEANCE.getDATE()+" à "+firstSEANCE.getHEURE_DEBUT();
                data[0][2] = "Semaine " +lastSEANCE.getSEMAINE()+" le "+lastSEANCE.getDATE()+" à "+lastSEANCE.getHEURE_DEBUT();
                data[0][3] = nbSeance.get(compteur)*1.5 +"h";
                data[0][4] = nbSeance.get(compteur);
            }
            compteur++;
        }
        
        return data;
    }*/
    
    public Object[][] reporting(UTILISATEUR leprof)
    {
        List<UTILISATEUR> listprof =new ArrayList<>();
        List <Integer> nbSeance =new ArrayList<Integer>();
        List<COURS> listCOURS =new ArrayList<COURS>();
        List<SEANCE> listSEANCEprems =new ArrayList<SEANCE>();
        List<SEANCE> listSEANCElast =new ArrayList<SEANCE>();
        
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
