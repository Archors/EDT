/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ENSEIGNANT_EDT;
import Controller.EtudiantEDT;
import Controller.SALLE_EDT;
import Model.COURS;
import Model.ETUDIANT;
import Model.SALLE;
import Model.SEANCE;
import Model.TYPE_COURS;
import Model.UTILISATEUR;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antoine
 */
public class EmploiDuTemps {
    private EtudiantEDT studentEDT = new EtudiantEDT();
  private List<SEANCE> listSEANCE =new ArrayList<>();
  private List<SALLE> listSALLE =new ArrayList<>();
  private List<UTILISATEUR> listeENSEIGNANT = new ArrayList<>();
  private List<TYPE_COURS> listeTYPE_COURS = new ArrayList<>();
  private List<COURS> listeCOURS = new ArrayList<>();
  
    public EmploiDuTemps(){
        
    }
    public Object[][] emploidutempsetudiant(ETUDIANT student, int semaine){
        int compteur = 0;
        String infoSEANCE;
        //Creation de l'objet qui contient les données de l'etudiant
    studentEDT.voirETUDIANT_SEANCE(student.getNOM());
    //Recuperation des données sur les cours de l'etudiant dans la classe
    listSEANCE = studentEDT.getlistSEANCE();
    listSALLE = studentEDT.getListSALLE();
    listeTYPE_COURS = studentEDT.getListTYPE_COURS();
    listeCOURS = studentEDT.getListCOURS();
    listeENSEIGNANT = studentEDT.getlistENSEIGNANT();

    //Données du tableau
    Object[][] data = remplissage();
    
    for(SEANCE i : listSEANCE)
    {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
        //On verifie que le cours n'est pas annulé
        if(i.getETAT()==1){
            infoSEANCE= "Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            data[coordo.gety()][coordo.getx()] = infoSEANCE;
        }
        }
        compteur++;
    }
    return data;
    }
    
    public Object[][] emploidutempssalle(SALLE salle, int semaine){
        int compteur = 0;
        String infoSEANCE;
        SALLE_EDT edtsalle = new SALLE_EDT();
        edtsalle.voirSALLE_EDT(salle.getNOM());
        listSEANCE = edtsalle.getlistSEANCE();
        listeTYPE_COURS = edtsalle.getListTYPE_COURS();
        listeCOURS = edtsalle.getListCOURS();
        listeENSEIGNANT = edtsalle.getlistENSEIGNANT();

    //Données du tableau
    Object[][] data = remplissage();
    for(SEANCE i : listSEANCE)
    {
        if(i.getSEMAINE() == semaine)
        {
            int x = 0,y=0;
            Coordonnees coordo = findJour(i);
        //On verifie que le cours n'est pas annulé
        if(i.getETAT()==1){
            infoSEANCE= "Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            data[coordo.gety()][coordo.getx()] = infoSEANCE;
        }
        }
        compteur++;
    }
    return data;
    }
    
    public Object[][] emploidutempsenseignant(UTILISATEUR enseignant, int semaine){
        int compteur = 0;
        String infoSEANCE;
        ENSEIGNANT_EDT edtenseignant = new ENSEIGNANT_EDT();
        edtenseignant.voirENSEIGNANT_EDT(enseignant.getNOM());
        listSEANCE = edtenseignant.getlistSEANCE();
        listeTYPE_COURS = edtenseignant.getListTYPE_COURS();
        listeCOURS = edtenseignant.getListCOURS();
        listeENSEIGNANT = edtenseignant.getlistENSEIGNANT();

    //Données du tableau
    Object[][] data = remplissage();
    for(SEANCE i : listSEANCE)
    {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            
        //On verifie que le cours n'est pas annulé
        if(i.getETAT()==1){
            infoSEANCE= "Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec le groupe" + listeENSEIGNANT.get(compteur).getNOM();
            data[coordo.gety()][coordo.getx()] = infoSEANCE;
        }
        }
        compteur++;
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
      {"15h30-17h", "", "", "", "", ""}
    };
    return donnee;
}
    
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
        }
        return coord;
    }
    public String[] setTitle(){
        String  title[] = {"Heure","Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
        return title;
    }
}
