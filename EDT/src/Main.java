/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milou
 */
import Model.ETUDIANTDAO;
import Model.ETUDIANT;
import Model.UTILISATEUR;
import Model.UTILISATEURDAO;
import Model.PROMOTION;
import Model.PROMOTIONDAO;
import Model.GROUPE;
import Model.GROUPEDAO;

import Model.DAO;

import Model.COURS;
import Model.COURSDAO;

import Model.TYPE_COURS;
import Model.TYPE_COURSDAO;

import Model.SITE;
import Model.SITEDAO;

import Model.SALLE; 
import Model.SALLEDAO; 

import Model.ETUDIANT;
import Model.ETUDIANTDAO;

import Model.UTILISATEUR;
import Model.UTILISATEURDAO;

import Model.REFERENT;
import Model.REFERENTDAO;

import Model.ADMIN;
import Model.ADMINDAO;

import Model.SEANCE;
import Model.SEANCEDAO;

import Controller.GROUPE_EDT;
import Controller.EtudiantEDT;
import Controller.PROMOTION_EDT;
import Controller.ADD_SEANCE;
import Controller.CONNEXION_UTILISATEUR;
import Controller.ENSEIGNANT_EDT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
       ENSEIGNANT_EDT testenseignant = new ENSEIGNANT_EDT();
       testenseignant.voirENSEIGNANT_EDT("Hina");
       Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
       Set <TYPE_COURS> listTYPE_COURS =new HashSet <TYPE_COURS>();
       Set <SALLE> listSALLE = new HashSet <SALLE>();
       listSEANCE = testenseignant.getlistSEANCE();
       listTYPE_COURS = testenseignant.getListTYPE_COURS();
       listSALLE = testenseignant.getListSALLE();
       
           for (SEANCE seance : listSEANCE)
    {
        System.out.println(seance.getHEURE_DEBUT());
    }
          
    for (TYPE_COURS type_cours : listTYPE_COURS)
    {
        
        System.out.println(type_cours.getNOM());
    } 
    
        for (SALLE salle : listSALLE)
    {
        
        System.out.println(salle.getNOM());
    } 
    
        
        /*
       PROMOTION_EDT test = new PROMOTION_EDT();
       test.voirPROMOTION_SEANCE("2022");
       Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
       Set <TYPE_COURS> listTYPE_COURS =new HashSet <TYPE_COURS>();
       listSEANCE = test.getListSEANCE(); 
       listTYPE_COURS = test.getListTYPE_COURS();
       
    for (SEANCE seance : listSEANCE)
    {
        System.out.println(seance.getHEURE_DEBUT());
    }
          
    for (TYPE_COURS type_cours : listTYPE_COURS)
    {
        
        System.out.println(type_cours.getNOM());
    }
       
       /* 
      GROUPE_EDT test = new GROUPE_EDT();
      test.voirGROUPE_SEANCE(1);
      Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
      Set <TYPE_COURS> listTYPE_COURS =new HashSet <TYPE_COURS>();
      listSEANCE = test.getlistSEANCE(); 
      listTYPE_COURS = test.getListTYPE_COURS();
      
          for (SEANCE seance : listSEANCE)
    {
        System.out.println(seance.getHEURE_DEBUT());
    }
          
              for (TYPE_COURS type_cours : listTYPE_COURS)
    {
        
        System.out.println(type_cours.getNOM());
    }
      
      /*
    EtudiantEDT etudiantedt = new EtudiantEDT();
    etudiantedt.voirETUDIANT_SEANCE("Bernard");
    Set<SEANCE> listSEANCE = new HashSet<SEANCE>();
    listSEANCE= etudiantedt.getlistSEANCE();

    for (SEANCE seance : listSEANCE)
    {
        System.out.println("COUCOU");
        System.out.println(seance.getHEURE_DEBUT());
    }
*/

    
    
  /*  CONNEXION_UTILISATEUR connect = new CONNEXION_UTILISATEUR();
    connect.VERIFCONNEXION_UTILISATEUR("davodet@gmail.com", "davodet");
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
