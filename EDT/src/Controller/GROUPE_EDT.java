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
public class GROUPE_EDT extends GROUPEDAO {
    public GROUPE_EDT(){}

    public void voirGROUPE_SEANCE(int ID)
    {
        //retrouver le groupe en question
        GROUPE groupe = new GROUPE();
        DAO <GROUPE> groupe2 = new  GROUPEDAO();
        groupe=groupe2.find(ID);
        System.out.println("EDT du GROUPE : ");
        groupe.afficherGROUPE();
      //retrouver les cours auquel il appartient
      try{

        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM GROUPE JOIN SEANCE_GROUPE a ON GROUPE.ID = a.ID_GROUPE JOIN SEANCE b ON a.ID_SEANCE = b.ID WHERE GROUPE.ID = " +ID);
        while(result.next()) 
        {
        
            
        //on créee un objet séance contenant les informations récupérés (ID_SEANCE) de la BDD
        SEANCE seancetest= new SEANCE();
        DAO<SEANCE> seancedaotest = new SEANCEDAO();
        seancetest=seancedaotest.find(result.getInt("ID_SEANCE"));
        
        //affichage du type du cours en récupérant ID_TYPE par la requête SQL
        TYPE_COURS test = new TYPE_COURS();
        DAO<TYPE_COURS> test2 =new TYPE_COURSDAO();
        test=test2.find(result.getInt("ID_TYPE"));
        test.afficherTYPE();
        
        //affichage du cours en récupérant l'ID Cours par la requete SQL
        COURS recupcours=new COURS();
        DAO<COURS> recupcoursdao = new COURSDAO();
        recupcours=recupcoursdao.find(result.getInt("ID_COURS"));
        
        }

    }catch (SQLException e){
        e.printStackTrace();
    }



    }


}