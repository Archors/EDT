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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
   //   GROUPE_EDT test = new GROUPE_EDT();
     // test.voirGROUPE_SEANCE(1);
      
     // EtudiantEDT etudiantedt = new EtudiantEDT();
     // etudiantedt.voirETUDIANT_SEANCE("Bernard");
      
      PROMOTION_EDT promotionedt =new PROMOTION_EDT();
      promotionedt.voirPROMOTION_SEANCE("2022");
      String SEMAINE = "Semaine";
      String DATE = "DATE";
      String HEURE_DEBUT ="heure_debut";
      String HEURE_FIN ="heure_fin";
      int ETAT = 0;
      int id_cours = 1;
      int id_type = 1; 
      ADD_SEANCE add_seance = new ADD_SEANCE();
      add_seance.AJOUTER_SEANCE(SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT,id_cours, id_type);
      
      
    }
    
}
