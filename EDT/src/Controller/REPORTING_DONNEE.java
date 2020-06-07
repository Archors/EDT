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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Milou
 */
public class REPORTING_DONNEE extends UTILISATEURDAO{

   
   public REPORTING_DONNEE (){}
private List<UTILISATEUR> listENSEIGNANT =new ArrayList<UTILISATEUR>();
private List <Integer> nbSeance =new ArrayList<Integer>();



   public void REPORTING_DONNEE()
   {
       try {
            PreparedStatement recupenseignant= this.connection.prepareStatement("SELECT DISTINCT ID_UTILISATEUR FROM ENSEIGNANT", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = recupenseignant.executeQuery();
        
        while(result.next())         
        { 
            UTILISATEUR saignant = new UTILISATEUR();
            DAO <UTILISATEUR> testsaignant = new UTILISATEURDAO();
            saignant=testsaignant.find(result.getInt("ID_UTILISATEUR"));
            listENSEIGNANT.add(saignant);
            PreparedStatement recupcours= this.connection.prepareStatement("SELECT DISTINCT ID_SEANCE FROM SEANCE_ENSEIGNANT se WHERE se.ID_ENSEIGNANT=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupcours.setInt(1,result.getInt("ID_UTILISATEUR"));
            ResultSet resultnbcours = recupcours.executeQuery();


            
            if(resultnbcours.first()==false)
            {
                nbSeance.add(0);
            }
            else{
                resultnbcours.last();
                nbSeance.add(resultnbcours.getRow()); 
            }
        }
        
        

       }catch (SQLException e){
        e.printStackTrace();
    }
     
   }
   
   

      public List<UTILISATEUR> getlistENSEIGNANT(){
        return listENSEIGNANT;
    }

    public void addUTILISATEUR (UTILISATEUR utilisateur){
        if(this.listENSEIGNANT.contains(utilisateur)!=true)
            this.listENSEIGNANT.add(utilisateur);
    }
    
        public List getnbSeance(){
        return nbSeance;
    }
   
}