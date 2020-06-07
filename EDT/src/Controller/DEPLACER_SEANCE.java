/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milou
 */
public class DEPLACER_SEANCE extends SEANCEDAO{
    //premiere etape, je recuperer la séance actuelle afin de recuperer les infos
    public DEPLACER_SEANCE() {} 
    
    public String DEPLACER_SEANCE_INSTANCE(int SEMAINE, String DATE, String HEURE_DEBUT, String NomSALLE, int newSEMAINE, String newDATE, String newHEURE_DEBUT, String newHEURE_FIN) {
        int J=0;
        String recup="";
        
        try{
            
        
            PreparedStatement recupSEANCE= this.connection.prepareStatement("SELECT * FROM SEANCE s JOIN SEANCE_SALLE ss ON ss.ID_SEANCE = s.ID JOIN SALLE sa ON sa.ID = ss.ID_SALLE WHERE s.SEMAINE = ? AND s.DATE = ? AND s.HEURE_DEBUT = ? AND sa.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupSEANCE.setInt(1,SEMAINE);
            recupSEANCE.setString(2,DATE);
            recupSEANCE.setString(3,HEURE_DEBUT);
            recupSEANCE.setString(4,NomSALLE);
            ResultSet recupseanceorigine = recupSEANCE.executeQuery();
            if(recupseanceorigine.first()==false)
            { 
                return "SEANCE N'EXISTE PAS";
            }
            else{ //On a récup un cours qui existe
            SEANCE seancerecup = new SEANCE();
            DAO <SEANCE> seancerecupdao = new  SEANCEDAO();
            seancerecup = seancerecupdao.find(recupseanceorigine.getInt("ID"));    
            
            //on recupere le nom du COURS
            PreparedStatement recupinformations= this.connection.prepareStatement("SELECT c.NOM FROM COURS c JOIN SEANCE s ON s.ID_COURS = c.ID WHERE s.ID=?  ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupinformations.setInt(1,seancerecup.getID());
            
            
             
            PreparedStatement recupcours= this.connection.prepareStatement("SELECT c.NOM FROM COURS c JOIN SEANCE s ON s.ID_COURS = c.ID WHERE s.ID=?  ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupcours.setInt(1,seancerecup.getID());
            ResultSet recupcoursset = recupcours.executeQuery();
            
            if(recupcoursset.first()==false)
            { return "PROBLEME";
            }
            
            //recup type_cours
             PreparedStatement recuptype_cours= this.connection.prepareStatement("SELECT c.NOM FROM TYPE_COURS c JOIN SEANCE s ON s.ID_TYPE = c.ID WHERE s.ID=?  ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recuptype_cours.setInt(1,seancerecup.getID());
            ResultSet recuptype_coursset = recuptype_cours.executeQuery();
            
            if(recuptype_coursset.first()==false)
            { return "PROBLEME";
            }
            
            //recup enseignant du cours
            
             PreparedStatement recupenseignant= this.connection.prepareStatement("SELECT u.NOM FROM UTILISATEUR u JOIN ENSEIGNANT e ON e.ID_UTILISATEUR = u.ID JOIN SEANCE_ENSEIGNANT se ON se.ID_ENSEIGNANT = e.ID_UTILISATEUR JOIN SEANCE s ON s.ID = se.ID_SEANCE WHERE s.ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupenseignant.setInt(1,seancerecup.getID());
            ResultSet recupenseignantset = recupenseignant.executeQuery();
            
            if(recupenseignantset.first()==false)
            { return "PROBLEME";
            }
            
            //recup GROUPE
            
            PreparedStatement recupGROUPE= this.connection.prepareStatement("SELECT g.NOM FROM GROUPE g JOIN SEANCE_GROUPE sg ON sg.ID_GROUPE = g.ID JOIN SEANCE s ON s.ID = sg.ID_SEANCE WHERE s.ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupGROUPE.setInt(1,seancerecup.getID());
            ResultSet recupGROUPEset = recupGROUPE.executeQuery();
            
            if(recupGROUPEset.first()==false)
            { return "PROBLEME";
            }
            
            //recup PROMOTION
            PreparedStatement recupPROMOTION= this.connection.prepareStatement("SELECT p.NOM FROM PROMOTION p JOIN GROUPE g ON g.ID_PROMOTION = p.ID JOIN SEANCE_GROUPE sg ON sg.ID_GROUPE = g.ID JOIN SEANCE s ON s.ID = sg.ID_SEANCE   WHERE s.ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupPROMOTION.setInt(1,seancerecup.getID());
            ResultSet recupPROMOTIONset = recupPROMOTION.executeQuery();
            
            if(recupPROMOTIONset.first()==false)
            { return "PROBLEME";
            }
            
            //recup SALLE
            
            PreparedStatement recupSALLE= this.connection.prepareStatement("SELECT sa.NOM FROM SALLE sa JOIN SEANCE_SALLE ss ON ss.ID_SALLE = sa.ID JOIN SEANCE s ON s.ID = ss.ID_SEANCE WHERE s.ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupSALLE.setInt(1,seancerecup.getID());
            ResultSet recupSALLEset = recupSALLE.executeQuery();
            
            if(recupSALLEset.first()==false)
            { return "PROBLEME";
            }
            
            ADD_SEANCE add = new ADD_SEANCE();
           recup= add.AJOUTER_SEANCE(newSEMAINE, newDATE, newHEURE_DEBUT, newHEURE_FIN, 2, recupcoursset.getString("NOM"), recuptype_coursset.getString("NOM"), recupenseignantset.getString("NOM"), recupGROUPEset.getString("NOM"), recupSALLEset.getString("NOM"), recupPROMOTIONset.getString("NOM"));
            if(recup.equals("COURS CORRECTEMENT AJOUTEE"))
            {
                SUPPRIMER_SEANCE supp = new SUPPRIMER_SEANCE();
                supp.SUPPRIMER_SEANCE_INSTANCE(SEMAINE, DATE, HEURE_DEBUT, NomSALLE);
               
            }
            else{
                System.out.println(recup);
            }
            
            
            
            
            
            
            
            

            }
        
        
            }catch (SQLException e){
        e.printStackTrace();
    }
            
      return "SEANCE DEPLACE";  
    }
    
}
