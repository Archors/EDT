/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ADMIN;
import Model.ADMINDAO;
import Model.COURS;
import Model.COURSDAO;

import Model.DAO;
import Model.Connexion;

import Model.ETUDIANT;
import Model.ETUDIANTDAO;

import Model.GROUPE;
import Model.GROUPEDAO;

import Model.PROMOTION;
import Model.PROMOTIONDAO;
import Model.REFERENT;
import Model.REFERENTDAO;

import Model.SALLE;
import Model.SALLEDAO;

import Model.SEANCE;
import Model.SEANCEDAO;

import Model.SITE;
import Model.SITEDAO;

import Model.TYPE_COURS;
import Model.TYPE_COURSDAO;

import Model.UTILISATEUR;
import Model.UTILISATEURDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Milou
 */
public class CONNEXION_UTILISATEUR extends UTILISATEURDAO{
   private boolean connexion;
   private int droit;
   private ETUDIANT etudiant = new ETUDIANT();
   private ADMIN admin = new ADMIN();
   private REFERENT referent= new REFERENT();
   UTILISATEUR utilisateur = new UTILISATEUR();
   
   public CONNEXION_UTILISATEUR (){this.connexion = false;
   this.droit=0;
   }
    public CONNEXION_UTILISATEUR(boolean connexion){this.connexion=connexion;}
   
    public void VERIFCONNEXION_UTILISATEUR (String EMAIL, String PASSWD)
    {
        try{ 
       PreparedStatement ps= this.connection.prepareStatement("SELECT * FROM UTILISATEUR u WHERE u.EMAIL = ? AND u.PASSWD= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       ps.setString(1,EMAIL);
       ps.setString(2,PASSWD);
       ResultSet resultat=ps.executeQuery();
       if (resultat.first() == false)
       {
           System.out.println("RIEN");
       }
       else { System.out.println("QCH");
       this.connexion=true;
          if (resultat.getInt("DROIT")==1)
         {
           System.out.println("ADMIN");
              this.droit=1;
              DAO <ADMIN> admindao = new  ADMINDAO();
              admin=admindao.find(resultat.getInt("ID"));
         }
          
          else if (resultat.getInt("DROIT")==2)
          {
              System.out.println("REFERENT");
              this.droit=2;
              DAO <REFERENT> referentdao = new  REFERENTDAO();
              referent=referentdao.find(resultat.getInt("ID"));
              System.out.println("REFERENT");
          }
          
          else if (resultat.getInt("DROIT")==3)
          {
              this.droit=3;
              DAO <UTILISATEUR> utilisateurdao = new UTILISATEURDAO();
              utilisateur=utilisateurdao.find(resultat.getInt("ID"));
              System.out.println("prof");
          }
          
          else if (resultat.getInt("DROIT")==4)
          {
              this.droit=4;
              System.out.println("eleve");
              DAO <ETUDIANT> etudiantdao = new  ETUDIANTDAO();
              etudiant=etudiantdao.find(resultat.getInt("ID"));
          }
          
          
       this.connexion=true; } 
       /*
       ResultSet resultat = ps.executeQuery();
       if (resultat.first() == false)
       {
           System.out.println(resultat.getInt("DROIT"));
           this.connexion=true;
       }
       */
       

    }catch (SQLException e){
        e.printStackTrace();
    }
        
   }

    public boolean isConnexion() {
        return connexion;
    }

    public void setConnexion(boolean connexion) {
        this.connexion = connexion;
    }

    public ETUDIANT getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(ETUDIANT etudiant) {
        this.etudiant = etudiant;
    }

    public int getDroit() {
        return droit;
    }

    public void setDroit(int droit) {
        this.droit = droit;
    }

    public ADMIN getAdmin() {
        return admin;
    }

    public void setAdmin(ADMIN admin) {
        this.admin = admin;
    }

    public REFERENT getReferent() {
        return referent;
    }

    public void setReferent(REFERENT referent) {
        this.referent = referent;
    }

    public UTILISATEUR getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UTILISATEUR utilisateur) {
        this.utilisateur = utilisateur;
    }
    
}
