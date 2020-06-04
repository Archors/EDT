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
public class MODIFIER_ETAT_SEANCE extends SEANCEDAO{
   private boolean connexion;
   private int droit;
   private ETUDIANT etudiant = new ETUDIANT();
   private ADMIN admin = new ADMIN();
   private REFERENT referent= new REFERENT();
   UTILISATEUR utilisateur = new UTILISATEUR();
   
   public MODIFIER_ETAT_SEANCE (){}
    
   public MODIFIER_ETAT_SEANCE(int ID, int etat)
   {/*
       try {
   PreparedStatement ps= this.connection.prepareStatement("UPDATE ETAT FROM SEANCE SET ETAT = ? u WHERE u.ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ps.setInt(1, etat);
     int resultat = ps.executeUpdate();

       }catch (SQLException e){
        e.printStackTrace();
    }
    */    
   }
   
   }
  
   
    