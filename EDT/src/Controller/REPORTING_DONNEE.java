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
private List<COURS> listCOURS =new ArrayList<COURS>();
private List<SEANCE> listSEANCEprems =new ArrayList<SEANCE>();
private List<SEANCE> listSEANCElast =new ArrayList<SEANCE>();





   public void REPORTING_DONNEE()
   {
       try {
            PreparedStatement recupenseignant= this.connection.prepareStatement("SELECT ID_UTILISATEUR FROM ENSEIGNANT", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
            
            
            PreparedStatement recupnomcours= this.connection.prepareStatement("SELECT DISTINCT e.ID_COURS FROM ENSEIGNANT e JOIN SEANCE_ENSEIGNANT se ON se.ID_ENSEIGNANT=e.ID_UTILISATEUR JOIN SEANCE s ON s.ID=se.ID_SEANCE WHERE s.ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupnomcours.setInt(1,resultnbcours.getInt("ID_SEANCE"));
            ResultSet recupnomcoursfinal = recupnomcours.executeQuery();
            
            resultnbcours.last();
            nbSeance.add(resultnbcours.getRow());
            
            while(recupnomcoursfinal.next()){
                
                COURS cours = new COURS();
                DAO <COURS> coursdao = new COURSDAO();
                cours=coursdao.find(recupnomcoursfinal.getInt("ID_COURS"));
                listCOURS.add(cours);

            
            //RECUPERATION DE LA TOUTE PREMIERE SEANCE DU PROF AVEC LE COURS ASSOCI´E
            PreparedStatement recupseancefirst= this.connection.prepareStatement("SELECT ID_SEANCE FROM SEANCE b JOIN SEANCE_ENSEIGNANT f ON b.ID = f.ID_SEANCE JOIN ENSEIGNANT g ON f.ID_ENSEIGNANT = g.ID_UTILISATEUR JOIN COURS c ON c.ID=b.ID_COURS WHERE g.ID_UTILISATEUR = ? AND c.ID = ? ORDER BY SEMAINE ASC, DATE ASC, HEURE_DEBUT DESC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupseancefirst.setInt(1,result.getInt("ID_UTILISATEUR"));
            recupseancefirst.setInt(2,recupnomcoursfinal.getInt("ID_COURS"));
            ResultSet recupseanceprems = recupseancefirst.executeQuery();
            
            
           if(recupseanceprems.first()==false)
            {
            }
           else {
               SEANCE seance = new SEANCE();
               DAO <SEANCE> seancedao = new SEANCEDAO();
               seance = seancedao.find(recupseanceprems.getInt("ID_SEANCE"));
               listSEANCEprems.add(seance);
           }
           
           // RECUPERATION LAST COURS
            PreparedStatement recupseancelast= this.connection.prepareStatement("SELECT * FROM SEANCE b JOIN SEANCE_ENSEIGNANT f ON b.ID = f.ID_SEANCE JOIN ENSEIGNANT g ON f.ID_ENSEIGNANT = g.ID_UTILISATEUR JOIN COURS c ON c.ID=b.ID_COURS WHERE g.ID_UTILISATEUR = ? AND c.ID = ?  ORDER BY SEMAINE DESC, DATE DESC, HEURE_DEBUT ASC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupseancelast.setInt(1,result.getInt("ID_UTILISATEUR"));
            recupseancelast.setInt(2,recupnomcoursfinal.getInt("ID_COURS"));
            ResultSet recupseancelasts = recupseancelast.executeQuery();
            
            
           if(recupseancelasts.first()==false)
            {
            }
           else {
               SEANCE seancelast = new SEANCE();
               DAO <SEANCE> seancedaolast = new SEANCEDAO();
               seancelast = seancedaolast.find(recupseancelasts.getInt("ID_SEANCE"));
               listSEANCElast.add(seancelast);
           }
           
           
           
            }
            
            
            
//SELECT * FROM SEANCE b JOIN SEANCE_ENSEIGNANT f ON b.ID = f.ID_SEANCE JOIN ENSEIGNANT g ON f.ID_ENSEIGNANT = g.ID_UTILISATEUR JOIN COURS c ON c.ID=b.ID_COURS WHERE g.ID_UTILISATEUR = 22 AND c.ID = 7  ORDER BY SEMAINE DESC, DATE DESC, HEURE_DEBUT ASC
                
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
    
          public List<SEANCE> getlistSEANCEprems(){
        return listSEANCEprems;
    }
          
    public void addSEANCEprems (SEANCE seance){
        if(this.listSEANCEprems.contains(seance)!=true)
            this.listSEANCEprems.add(seance);
    }
    
    
        public List getnbSeance(){
        return nbSeance;
    }
        
        
         public List<COURS> getlistCOURS(){
        return listCOURS;
    }
             public void addCOURS (COURS cours){
        if(this.listCOURS.contains(cours)!=true)
            this.listCOURS.add(cours);
    }
             
             
         public List<SEANCE> getlistCOURSlast(){
        return listSEANCElast;
    }
   
}

