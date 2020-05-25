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
import requete.DAO;
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
              
      
      
      
   // ETUDIANT tiago=new ETUDIANT();
   // DAO<ETUDIANT> test = new ETUDIANTDAO();
   // tiago=test.find(8);
   // tiago.afficher();
    
    
        
    /*    
    PROMOTION vingtdeux = new PROMOTION();
    GROUPE TD01 = new GROUPE(1, "TD01");
    ETUDIANT Delahegue= new ETUDIANT(15,1,"delahegue@gmail.com","delahegue","Delahegue","Emilien",4);
    ETUDIANT Boulan= new ETUDIANT(24,2,"boulan@gmail.com","Boulan","Boulan","Maxime",4);
    ETUDIANT Debois=new ETUDIANT(29,3,"debois@gmail.com", "Debois", "Debois", "Julien",4);
    vingtdeux.addGROUPES(TD01);
    TD01.addETUDIANT(Delahegue);
    TD01.addETUDIANT(Boulan);
    TD01.addETUDIANT(Debois);
    vingtdeux.afficherPROMOTION();
    
    SITE E1= new SITE(1,"E1");
    SALLE propre=new SALLE(1,"propre",60);
    SALLE paspropre=new SALLE(2,"paspropre",40);
   E1.addSALLE(propre);
    E1.addSALLE(paspropre);
    E1.afficherSITE();
    
    COURS Java =new COURS(1,"Java");
  COURS C=new COURS (2,"C");
    
    TYPE_COURS CI=new TYPE_COURS(1,"CI");
    TYPE_COURS TP=new TYPE_COURS(2,"TP");
    
    SEANCE prems = new SEANCE(1,"ok", "ok", "ok", "ok", 1);
  prems.addCOURS(Java);
    prems.addCOURS(C);
    prems.addTYPE_COURS(CI);
   prems.addTYPE_COURS(TP);
    
    prems.afficherSEANCE();
    
    */ 
    }
    
}
