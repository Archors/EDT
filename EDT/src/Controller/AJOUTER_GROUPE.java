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

//le but de cette classe est de pouvoir ajouter un groupe à un CI
//on vérie si la séance existe
//si le type_cours de la séance est bien un CI
//si la séance comporte moins de 3 groupes (max groupes pour CI)
//le groupe est-il libre ? 
//si tous les critères sont réunis, 
public class AJOUTER_GROUPE extends GROUPEDAO{
    private int nbgroupe=0;
    private List<SEANCE> listSEANCEGROUPE =new ArrayList<SEANCE>();
    
    public AJOUTER_GROUPE(){}
    
    public String AJOUTER_GROUPE_INSTANCE(int SEMAINE, String DATE, String HEURE_DEBUT, String NomSALLE, String NomGROUPE, String NomPROMOTION) {
        int resultat;
        int resultatenseignant;
        int resultatgroupe;
        int resultatsalle;
        int i=2;
        int resultatsupp;
        int resultsallesupp;
        int resultatsalle2;
        int Supprimer_seance_salle;
        try{
            
        
            PreparedStatement recupSEANCE= this.connection.prepareStatement("SELECT s.ID FROM SEANCE s JOIN SEANCE_SALLE ss ON ss.ID_SEANCE = s.ID JOIN SALLE sa ON sa.ID = ss.ID_SEANCE WHERE s.SEMAINE = ? AND s.DATE = ? AND s.HEURE_DEBUT = ? AND sa.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
                
            PreparedStatement recuptype_cours= this.connection.prepareStatement("SELECT tc.ID FROM TYPE_COURS tc JOIN SEANCE s ON s.ID_TYPE= tc.ID WHERE s.ID = ? AND tc.NOM='CI'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recuptype_cours.setInt(1,seancerecup.getID());
            
            ResultSet recuptype = recuptype_cours.executeQuery();
            if(recuptype.first()==false)
            { 
                return "VOUS NE POUVEZ PAS AJOUTER CA VOTRE SEANCE N'EST PAS UN CI";
            }
            else{ //on a recup une seance SI, on veut retrouver le nombre de groupe affecté, on utilise COUNT pour compter le nombre de groupe dans une séance
            PreparedStatement nombregroupe= this.connection.prepareStatement("SELECT * FROM SEANCE_GROUPE sg WHERE sg.ID_SEANCE = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            nombregroupe.setInt(1,seancerecup.getID());

            ResultSet nombregrouperecup = nombregroupe.executeQuery();
            if(recuptype.first()==false)
            { 
                return "aucun groupe affecté, c'est impossible";
            }
            else {
                    nombregrouperecup.last();
                    nbgroupe = nombregrouperecup.getRow();
                    System.out.println("Le nombre de groupe : " + nbgroupe);
                if(nbgroupe >= 3)
                {
                    return "Il y a deja trois groupes ou plus dans cette seance, vous ne pouvez pas ajouter un groupe";
                }
                else{
                    
                    /*
                    On commence la récup du groupe, on va vérifier si le groupe est dispo et si oui on l'affecte
                    
                    
                    */
                    
            GROUPE_EDT groupedt = new GROUPE_EDT();
                   
            PreparedStatement recupGROUPE= this.connection.prepareStatement("SELECT g.ID FROM GROUPE g JOIN PROMOTION p ON p.ID=g.ID_PROMOTION WHERE g.NOM = ? AND p.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupGROUPE.setString(1,NomGROUPE);
            recupGROUPE.setString(2,NomPROMOTION);
            ResultSet recupGROUPEset = recupGROUPE.executeQuery();
            if(recupGROUPEset.first()==false)
            { 
                return "NOM DU GROUPE NON VALIDE";
            }

            else{
                
            groupedt.voirGROUPE_SEANCE(recupGROUPEset.getInt("ID"));
            listSEANCEGROUPE = groupedt.getlistSEANCE();
                       for(SEANCE seancelibreGROUPE : listSEANCEGROUPE)
                   {

                       
                       if(HEURE_DEBUT.equals(seancelibreGROUPE.getHEURE_DEBUT()) && DATE.equals(seancelibreGROUPE.getDATE()) && SEMAINE == seancelibreGROUPE.getSEMAINE() )
                       {
                           System.out.println("JE SUIS LA MEC");
                           i=0;
                       }
                   }
                   if(i==0)
                   {
                  
                  return "LE GROUPE N'EST PAS DISPO";
                       
                   }
                   else{                   
                   
                   PreparedStatement ajoutergroupe= this.connection.prepareStatement("INSERT INTO SEANCE_GROUPE (ID_GROUPE, ID_SEANCE) VALUES (?,?) ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                   ajoutergroupe.setInt(1,recupGROUPEset.getInt("ID"));
                   ajoutergroupe.setInt(2,seancerecup.getID());
                   resultatenseignant = ajoutergroupe.executeUpdate();
                   }
                     
                   }
                }
            }
            
            
            
            }
                }
    
    
    }catch (SQLException e){
        e.printStackTrace();
    }
 return "GROUPE BIEN AJOUTÉ";   
}
}
