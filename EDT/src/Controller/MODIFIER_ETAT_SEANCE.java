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

   
   public MODIFIER_ETAT_SEANCE (){}
    
   public String MODIFIER_ETAT_SEANCE(int SEMAINE, String DATE, String HEURE_DEBUT, String SALLENOM, int etat)
   {
       try {
            PreparedStatement recupSEANCE= this.connection.prepareStatement("SELECT s.ID FROM SEANCE s JOIN SEANCE_SALLE ss ON ss.ID_SEANCE = s.ID JOIN SALLE sa ON sa.ID = ss.ID_SALLE WHERE s.SEMAINE = ? AND s.DATE = ? AND s.HEURE_DEBUT = ? AND sa.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupSEANCE.setInt(1,SEMAINE);
            recupSEANCE.setString(2,DATE);
            recupSEANCE.setString(3,HEURE_DEBUT);
            recupSEANCE.setString(4,SALLENOM);
            ResultSet recupseanceorigine = recupSEANCE.executeQuery();
            if(recupseanceorigine.first()==false)
            { 
                return "SEANCE N'EXISTE PAS";
            } 
            else {

    PreparedStatement ps= this.connection.prepareStatement("UPDATE SEANCE  SET SEANCE.ETAT = ?  WHERE SEANCE.ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ps.setInt(1, etat);
    ps.setInt(2,recupseanceorigine.getInt("ID"));
     int resultat = ps.executeUpdate();
            }

       }catch (SQLException e){
        e.printStackTrace();
    }
     return "ETAT CORRECTEMENT CHANGE"; 
   }
   
   }
  
   
    
  
   
    