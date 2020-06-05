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
/**
 *
 * @author Milou
 */
public class ADD_SEANCE extends SEANCEDAO {
    public ADD_SEANCE(){}

    public boolean AJOUTER_SEANCE(int SEMAINE, String DATE, String HEURE_DEBUT, String HEURE_FIN, int ETAT, String NomCours, String Type_CoursNom)
    {
        int resultat;
    
        try{
            PreparedStatement recupCOURS= this.connection.prepareStatement("SELECT ID FROM COURS c WHERE c.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupCOURS.setString(1,NomCours);
            ResultSet recupcoursorigine = recupCOURS.executeQuery();
            if(recupcoursorigine.first()==false)
            { 
                return false;
            }
            else{ 
                COURS recupcours = new COURS();
                DAO <COURS> recupcoursdao = new  COURSDAO();
                recupcours = recupcoursdao.find(recupcoursorigine.getInt("ID"));
         
                PreparedStatement recupTYPE_COURS = this.connection.prepareStatement("SELECT ID FROM TYPE_COURS tp WHERE tp.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                recupTYPE_COURS.setString(1,Type_CoursNom);
                ResultSet recuptype_coursorigine = recupTYPE_COURS.executeQuery();
                if(recuptype_coursorigine.first()==false)
                { 
                    return false;
                }
                else{ 
                    TYPE_COURS type_coursrecup = new TYPE_COURS();
                    DAO <TYPE_COURS> type_coursrecupdao = new TYPE_COURSDAO();
                    type_coursrecup = type_coursrecupdao.find(recuptype_coursorigine.getInt("ID"));
            

                    PreparedStatement ps= this.connection.prepareStatement("INSERT INTO SEANCE (SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT,ID_COURS, ID_TYPE) VALUES (?, ?, ?, ?, ?, ?, ?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                     ps.setInt(1,SEMAINE);
                     ps.setString(2,DATE);
                     ps.setString(3,HEURE_DEBUT);
                     ps.setString(4,HEURE_FIN);
                     ps.setInt(5,ETAT);
                     ps.setInt(6, recupcours.getID());
                     ps.setInt(7, type_coursrecup.getID());
       
                     resultat = ps.executeUpdate();
                     

                }
            }
    }catch (SQLException e){
        e.printStackTrace();
    }
        
return true;

    }
}
