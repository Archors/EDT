/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ENSEIGNANT_EDT;
import Controller.EtudiantEDT;
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
  private List <GROUPE> listGROUPE = new ArrayList<>();
  int compteur = 0;
  
    public EmploiDuTemps(){
        
    }
    public Object[][] emploidutempsetudiant(ETUDIANT student, int semaine){
        
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
    
    listSEANCE.stream().map((i) -> {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                data[coordo.gety()][coordo.getx()] = "Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            }
        }   return i;
        }).forEachOrdered((_item) -> {
            compteur++;
        });
    return data;
    }
    
    public Object[][] emploidutempssalle(SALLE salle, int semaine){
        SALLE_EDT edtsalle = new SALLE_EDT();
        edtsalle.voirSALLE_EDT(salle.getNOM());
        listSEANCE = edtsalle.getlistSEANCE();
        listeTYPE_COURS = edtsalle.getListTYPE_COURS();
        listeCOURS = edtsalle.getListCOURS();
        listeENSEIGNANT = edtsalle.getlistENSEIGNANT();

    //Données du tableau
    Object[][] data = remplissage();
    listSEANCE.stream().map((i) -> {
        if(i.getSEMAINE() == semaine)
        {
            int x = 0,y=0;
            Coordonnees coordo = findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM()+" et "+ groupe(listGROUPE) ;
            }
        }   return i;
        }).forEachOrdered((_item) -> {
            compteur++;
        });
    return data;
    }
    
    public Object[][] emploidutempsenseignant(UTILISATEUR enseignant, int semaine){
        ENSEIGNANT_EDT edtenseignant = new ENSEIGNANT_EDT();
        edtenseignant.voirENSEIGNANT_EDT(enseignant.getNOM());
        listSEANCE = edtenseignant.getlistSEANCE();
        listeTYPE_COURS = edtenseignant.getListTYPE_COURS();
        listeCOURS = edtenseignant.getListCOURS();
        listeENSEIGNANT = edtenseignant.getlistENSEIGNANT();

    //Données du tableau
    Object[][] data = remplissage();
    listSEANCE.stream().map((i) -> {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = findJour(i);
            
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                SEANCE_GROUPE sgroup = new SEANCE_GROUPE(i.getID());
                data[coordo.gety()][coordo.getx()] = "Cours " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+ groupe(listGROUPE);
            }
        }   return i;
        }).forEachOrdered((_item) -> {
            compteur++;
        });
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
        String grp;
        if(list.size() == 1)
            grp = "Le groupe "+list.get(1).getNOM();
        else
        {
            grp = "Les groupes : ";
            grp = list.stream().map((i) -> i.getNOM()+",").reduce(grp, String::concat);
            removeLastChar(grp);
        }
        return grp;
    }
    
    //Enleve le derniere caractere d'un String
    private static String removeLastChar(String str) {
    return str.substring(0, str.length() - 1);
}
}
