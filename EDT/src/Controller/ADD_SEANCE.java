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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.SQLException;
/**
 *
 * @author Milou
 */
public class ADD_SEANCE extends SEANCEDAO {
    public ADD_SEANCE(){}

    public void AJOUTER_SEANCE(String SEMAINE, String DATE, String HEURE_DEBUT, String HEURE_FIN, int ETAT, int id_cours, int id_type)
    {
        //retrouver le groupe en question

        try{ 
      PreparedStatement ps= this.connection.prepareStatement("INSERT INTO SEANCE (SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT,ID_COURS, ID_TYPE) VALUES (?, ?, ?, ?, ?, ?, ?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       // ps.setString(Nom);
       ps.setString(1,SEMAINE);
       ps.setString(2,DATE);
       ps.setString(3,HEURE_DEBUT);
       ps.setString(4,HEURE_FIN);
       ps.setInt(5,ETAT);
       ps.setInt(6, id_cours);
       ps.setInt(7, id_type);
       int resultat = ps.executeUpdate();


    }catch (SQLException e){
        e.printStackTrace();
    }
        


    }


}