/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ENSEIGNANT_EDT;
import Controller.EtudiantEDT;
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

/**classe permettant d'afficher les emplois du temps en ligne*/
public class ListeEDT {
    
    private List<Object> dataL =new ArrayList<>();
    private List<Object> dataM =new ArrayList<>();
    private List<Object> dataMe =new ArrayList<>();
    private List<Object> dataJ =new ArrayList<>();
    private List<Object> dataV =new ArrayList<>();
    
    private EtudiantEDT studentEDT = new EtudiantEDT();
    private ENSEIGNANT_EDT enseignantEDT = new ENSEIGNANT_EDT();
    private List<SEANCE> listSEANCE =new ArrayList<>();
    private List<SALLE> listSALLE =new ArrayList<>();
    private List<UTILISATEUR> listeENSEIGNANT = new ArrayList<>();
    private List<TYPE_COURS> listeTYPE_COURS = new ArrayList<>();
    private List<COURS> listeCOURS = new ArrayList<>();
    private List <GROUPE> listGROUPE = new ArrayList<>();
    private int compteur = 0;
    
    public ListeEDT(){}

    public void ListeEtudiant(ETUDIANT eleve, int semaine)
    {
        //Creation de l'objet qui contient les données de l'etudiant
        studentEDT.voirETUDIANT_SEANCE(eleve.getNOM(), semaine);
        //Recuperation des données sur les cours de l'etudiant dans la classe
        listSEANCE = studentEDT.getlistSEANCE();
        listSALLE = studentEDT.getListSALLE();
        listeTYPE_COURS = studentEDT.getListTYPE_COURS();
        listeCOURS = studentEDT.getListCOURS();
        listeENSEIGNANT = studentEDT.getlistENSEIGNANT();
        EmploiTemps emploidutemps = new EmploiTemps();
        compteur = 0;
        for(int i=0;i<8;i++)
        {
            dataL.add("");
            dataM.add("");
            dataMe.add("");
            dataJ.add("");
            dataV.add("");
        }
        for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = emploidutemps.findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                switch(coordo.getx())
                {
                    //Lundi
                    case(1):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataL.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataL.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataL.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataL.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataL.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataL.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Mardi
                    case(2):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataM.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataM.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataM.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataM.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataM.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataM.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Mercredi
                    case(3):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataMe.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataMe.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataMe.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataMe.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataMe.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataMe.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Jeudi
                    case(4):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataJ.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataJ.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataJ.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataJ.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataJ.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataJ.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Vendredi
                    case(5):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataV.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataV.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataV.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataV.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataV.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataV.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            compteur++;
        }
        }
        for(int obj=0;obj<dataL.size();obj++)
        {
            dataL.remove("");
        }
        for(int obj=0;obj<dataM.size();obj++)
        {
            dataM.remove("");
        }
        
        for(int obj=0;obj<dataMe.size();obj++)
        {
            dataMe.remove("");
        }
        for(int obj=0;obj<dataJ.size();obj++)
        {
            dataJ.remove("");
        }
        for(int obj=0;obj<dataV.size();obj++)
        {
            dataV.remove("");
        }
        if(dataL.isEmpty())
            dataL.add("");
        if(dataM.isEmpty())
            dataM.add("");
        if(dataM.isEmpty())
            dataMe.add("");
        if(dataJ.isEmpty())
            dataJ.add("");
        if(dataV.isEmpty())
            dataV.add("");
    
}
    
    public void ListeProfesseur(UTILISATEUR prof, int semaine)
    {
        //Creation de l'objet qui contient les données de l'etudiant
        enseignantEDT.voirENSEIGNANT_EDT(prof.getNOM(),semaine);
        //Recuperation des données sur les cours de l'etudiant dans la classe
        listSEANCE = enseignantEDT.getlistSEANCE();
        listSALLE = enseignantEDT.getListSALLE();
        listeTYPE_COURS = enseignantEDT.getListTYPE_COURS();
        listeCOURS = enseignantEDT.getListCOURS();
        listeENSEIGNANT = enseignantEDT.getlistENSEIGNANT();
        EmploiTemps emploidutemps = new EmploiTemps();
        compteur = 0;
        for(int i=0;i<8;i++)
        {
            dataL.add("");
            dataM.add("");
            dataMe.add("");
            dataJ.add("");
            dataV.add("");
        }
        for(SEANCE i : listSEANCE) {
        if(i.getSEMAINE() == semaine)
        {
            Coordonnees coordo = emploidutemps.findJour(i);
            //On verifie que le cours n'est pas annulé
            if(i.getETAT()==1){
                switch(coordo.getx())
                {
                    //Lundi
                    case(1):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataL.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataL.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataL.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataL.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataL.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataL.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Mardi
                    case(2):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataM.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataM.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataM.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataM.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataM.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataM.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Mercredi
                    case(3):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataMe.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataMe.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataMe.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataMe.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataMe.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataMe.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Jeudi
                    case(4):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataJ.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataJ.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataJ.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataJ.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataJ.add(coordo.gety(),"15h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (5):
                            {
                                dataJ.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                    //Vendredi
                    case(5):
                    {
                        switch(coordo.gety())
                        {
                            case (0):
                            {
                                dataV.add(coordo.gety(),"8h30 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (1):
                            {
                                dataV.add(coordo.gety(),"10h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (2):
                            {
                                dataV.add(coordo.gety(),"12h : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (3):
                            {
                                dataV.add(coordo.gety(),"13h45 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                            case (4):
                            {
                                dataV.add(coordo.gety(),"15h30 : Cours de " /*+ listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM()*/);
                                break;
                            }
                            case (5):
                            {
                                dataV.add("17h15 : Cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM());
                                break;
                            }
                        }
                        break;
                    }
                }
                
            }
            compteur++;
        }
        }
        for(int obj=0;obj<dataL.size();obj++)
        {
            dataL.remove("");
        }
        for(int obj=0;obj<dataM.size();obj++)
        {
            dataM.remove("");
        }
        
        for(int obj=0;obj<dataMe.size();obj++)
        {
            dataMe.remove("");
        }
        for(int obj=0;obj<dataJ.size();obj++)
        {
            dataJ.remove("");
        }
        for(int obj=0;obj<dataV.size();obj++)
        {
            dataV.remove("");
        }
        if(dataL.isEmpty())
            dataL.add("");
        if(dataM.isEmpty())
            dataM.add("");
        if(dataM.isEmpty())
            dataMe.add("");
        if(dataJ.isEmpty())
            dataJ.add("");
        if(dataV.isEmpty())
            dataV.add("");
}
    
    public Object[] getL()
    {
        return(dataL.toArray());
    }
    public Object[] getM()
    {
        return(dataM.toArray());
    }
    public Object[] getMe()
    {
        return(dataMe.toArray());
    }
    public Object[] getJ()
    {
        return(dataJ.toArray());
    }
    public Object[] getV()
    {
        return(dataV.toArray());
    }
    
}
