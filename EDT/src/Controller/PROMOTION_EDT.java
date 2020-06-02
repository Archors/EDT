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
public class PROMOTION_EDT extends ETUDIANTDAO {
    private Set<GROUPE> listGROUPE =new HashSet<GROUPE>();

    
    public PROMOTION_EDT(){}

    public void voirPROMOTION_SEANCE(String Nom)
    {
        //retrouver le groupe en question

        try{ 
      PreparedStatement ps= this.connection.prepareStatement("SELECT u.ID FROM PROMOTION JOIN GROUPE u ON PROMOTION.ID = u.ID_PROMOTION WHERE PROMOTION.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       // ps.setString(Nom);
       ps.setString(1,Nom);
       ResultSet resultat = ps.executeQuery();

      while(resultat.next())
        { 
        GROUPE_EDT groupeedt = new GROUPE_EDT();
        groupeedt.voirGROUPE_SEANCE(resultat.getInt("ID"));        
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
        


    }
    public Set<GROUPE> getlistGROUPE(){
        return listGROUPE;
    }
    public void addGROUPE (GROUPE groupe){
      if(this.listGROUPE.contains(groupe)!=true)
          this.listGROUPE.add(groupe);
        }
public void afficherLISTEGROUPE(){
           
    for (GROUPE groupe : listGROUPE)
    {
        System.out.println("............"+groupe.getNOM());
    }
}

}