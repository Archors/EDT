/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milou
 */
import requete.ETUDIANTDAO;
import Model.ETUDIANT;
import Model.UTILISATEUR;
import requete.UTILISATEURDAO;
import Model.PROMOTION;
import requete.PROMOTIONDAO;
import Model.GROUPE;
import requete.GROUPEDAO;

import requete.DAO;

import Model.COURS;
import requete.COURSDAO;

import Model.TYPE_COURS;
import requete.TYPE_COURSDAO;

import Model.SITE;
import requete.SITEDAO;

import Model.SALLE; 
import requete.SALLEDAO; 

import Model.ETUDIANT;
import requete.ETUDIANTDAO;

import Model.UTILISATEUR;
import requete.UTILISATEURDAO;

import Model.REFERENT;
import requete.REFERENTDAO;

import Model.ADMIN;
import requete.ADMINDAO;

import Model.SEANCE;
import requete.SEANCEDAO;

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
     
      PROMOTION jacques = new PROMOTION();
      DAO<PROMOTION> test= new PROMOTIONDAO();
      jacques=test.find(1);
      jacques.afficherPROMOTION();
      
      GROUPE Paul = new GROUPE();
      DAO <GROUPE> test2 = new  GROUPEDAO();
      Paul=test2.find(1);
      Paul.afficherGROUPE();
      
      
      SALLE E304 = new SALLE();
      DAO <SALLE> test5 = new SALLEDAO();
      E304=test5.find(5);
      E304.afficherSALLE();
      
      SALLE E306 = new SALLE();
      DAO <SALLE> test6 = new SALLEDAO();
      E306=test6.find(6);
      E306.afficherSALLE();
      
      SITE E1 = new SITE();
      DAO <SITE> test4 = new SITEDAO();
      E1=test4.find(1);
      
      
      E1.addSALLE(E304);
      E1.addSALLE(E306);
      
      E1.afficherSITE();
      
      UTILISATEUR mijon = new UTILISATEUR();
      DAO <UTILISATEUR> test8 = new UTILISATEURDAO();
      mijon=test8.find(10);
      mijon.afficherUTILISATEUR();
      
      ETUDIANT romain = new ETUDIANT();
      DAO <ETUDIANT> test7 = new ETUDIANTDAO();
      romain=test7.find(19);
      romain.afficherETUDIANT();
      
      REFERENT aurel =new REFERENT();
      DAO<REFERENT> test9 =new REFERENTDAO();
      aurel=test9.find(18);
      aurel.afficherREFERENT();
      
      ADMIN milou = new ADMIN();
      DAO <ADMIN> test10=new ADMINDAO();
      milou=test10.find(1);
      milou.afficherADMIN();
      
      
      COURS Java =new COURS();
      DAO <COURS> test3 = new COURSDAO();
      Java=test3.find(1);
      Java.afficherCOURS();
      
      TYPE_COURS ci =new TYPE_COURS();
      DAO <TYPE_COURS> test11 = new TYPE_COURSDAO();
      ci=test11.find(1);
      
      
      
      SEANCE zoom = new SEANCE();
      DAO <SEANCE> test12 =new SEANCEDAO();
      zoom=test12.find(1);
      
      zoom.addCOURS(Java);
      zoom.addTYPE_COURS(ci);
      zoom.afficherSEANCE();
      
    }
    
}
