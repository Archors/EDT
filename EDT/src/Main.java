/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milou
 */
import Controller.CONNEXION_UTILISATEUR;
import Controller.GROUPE_EDT;
import Model.ADMIN;
import Model.ETUDIANT;
import Model.REFERENT;
import Model.SEANCE;
import Model.SALLE;
import Model.SEANCEDAO;

import Controller.GROUPE_EDT;
import Controller.EtudiantEDT;
import Controller.PROMOTION_EDT;
import Controller.ADD_SEANCE;
import Controller.CONNEXION_UTILISATEUR;
import Controller.ENSEIGNANT_EDT;
import Controller.SALLE_EDT;
import Model.COURS;
import Model.GROUPE;
import Model.PROMOTION;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.SQLException;

import Model.TYPE_COURS;
import Model.UTILISATEUR;
import View.Fenetre;

import java.util.HashSet;
import java.util.Set;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SALLE_EDT salleedt = new SALLE_EDT();
        salleedt.voirSALLE_EDT("104");
       Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
       Set <TYPE_COURS> listTYPE_COURS =new HashSet <TYPE_COURS>();
       Set <COURS> listCOURS = new HashSet <COURS>();
       Set <PROMOTION> listPROMOTION = new HashSet <PROMOTION>();
       Set <GROUPE> listGROUPE = new HashSet <GROUPE>();
       listSEANCE = salleedt.getlistSEANCE();
       listPROMOTION= salleedt.getlistPROMOTION();
       listCOURS = salleedt.getListCOURS();
       listTYPE_COURS = salleedt.getListTYPE_COURS();
       listGROUPE=salleedt.getListGROUPE();
       
       for(SEANCE seance : listSEANCE)
       {
           System.out.println("Heure debutdebutdebut: ");
           System.out.println(seance.getHEURE_DEBUT());
       }
       for(PROMOTION promotion : listPROMOTION)
       {
           System.out.println(promotion.getNOM());
       }
              for(GROUPE groupe : listGROUPE)
       {
           System.out.println(groupe.getNOM());
       }
      
               


   //  Fenetre fenetre = new Fenetre();

    
    /*
    CONNEXION_UTILISATEUR connect = new CONNEXION_UTILISATEUR();
    connect.VERIFCONNEXION_UTILISATEUR("tiago@gmail.com", "tiago");
    if (connect.isConnexion()==false)
    {
        System.out.println("MAUVAISE INFO");
    }
    else {
        if(connect.getDroit()==4)
        {
    ETUDIANT etudiant = new ETUDIANT();
    etudiant=connect.getEtudiant();
    etudiant.afficherETUDIANT(); 
        }
        else if (connect.getDroit()==1)
        {
            ADMIN admin = new ADMIN();
            admin=connect.getAdmin();
            admin.afficherADMIN();
        }
        
        else if (connect.getDroit()==2)
        {
            REFERENT referent = new REFERENT();
            referent=connect.getReferent();
            referent.afficherREFERENT();
        }
        else if (connect.getDroit()==3)
        {
            UTILISATEUR utilisateur =new UTILISATEUR();
            utilisateur = connect.getUtilisateur();
            utilisateur.afficherUTILISATEUR();
        }
        
        }

*/
      
     
    }
    
}
