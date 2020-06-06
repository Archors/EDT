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
public class ADD_SEANCE extends SEANCEDAO {
  private List<SEANCE> listSEANCE =new ArrayList<SEANCE>();
  private List<SEANCE> listSEANCESALLE =new ArrayList<SEANCE>();
  private List<SEANCE> listSEANCEGROUPE =new ArrayList<SEANCE>();



    public ADD_SEANCE(){}
    


    public String AJOUTER_SEANCE(int SEMAINE, String DATE, String HEURE_DEBUT, String HEURE_FIN, int ETAT, String NomCours, String Type_CoursNom, String ENSEIGNANTNOM, String GROUPENOM, String SALLENOM, String NomPROMOTION)

    { 
        
        int resultat;
        int resultatenseignant;
        int resultatgroupe;
        int resultatsalle;
        int i=2;
        int j=2;
        int capaciteok=1;
        int resultatsupp;
        int resultsallesupp;
        int resultatsalle2;
        int Supprimer_seance_salle;
    
        try{
            PreparedStatement recupCOURS= this.connection.prepareStatement("SELECT ID FROM COURS c WHERE c.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            recupCOURS.setString(1,NomCours);
            ResultSet recupcoursorigine = recupCOURS.executeQuery();
            if(recupcoursorigine.first()==false)
            { 
                return "NOM DU COURS NON VALIDE";
            }
            else{ 
                COURS recupcours = new COURS();
                DAO <COURS> recupcoursdao = new  COURSDAO();
                recupcours = recupcoursdao.find(recupcoursorigine.getInt("ID"));
         
                PreparedStatement recupTYPE_COURS = this.connection.prepareStatement("SELECT ID FROM TYPE_COURS tp WHERE tp.NOM= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                recupTYPE_COURS.setString(1,Type_CoursNom);
                ResultSet recuptype_coursorigine = recupTYPE_COURS.executeQuery();
                if(recuptype_coursorigine.first()==false)
                { 
                    return "TYPE_DE COURS NON VALIDE";
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
                     
                     //On insere l'enseignant qui donnera le cours de la nouvelle séance
                   ENSEIGNANT_EDT enseignantedt = new ENSEIGNANT_EDT();
                   enseignantedt.voirENSEIGNANT_EDT(ENSEIGNANTNOM);
                   listSEANCE = enseignantedt.getlistSEANCE();
                   
                   for(SEANCE seancelibre : listSEANCE)
                   {
                       if(HEURE_DEBUT.equals(seancelibre.getHEURE_DEBUT()) && DATE.equals(seancelibre.getDATE()) && SEMAINE == seancelibre.getSEMAINE() )
                       {
                           i=0;
                       }
                   }
                   if(i==0)
                   {
                  PreparedStatement supprimerSEANCE= this.connection.prepareStatement("DELETE FROM SEANCE ORDER by ID desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  resultatsupp = supprimerSEANCE.executeUpdate();
                  
                  return "Le prof est pas dispo";
                       
                   }
                   else{
                       
                   PreparedStatement retrouverenseignant= this.connection.prepareStatement("SELECT ID FROM UTILISATEUR WHERE NOM= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                   retrouverenseignant.setString(1,ENSEIGNANTNOM);
                   ResultSet enseignantrecuperer = retrouverenseignant.executeQuery(); 
                   if(enseignantrecuperer.first()==false)
                   {
                       return "Le nom de l'utilisateur est invalide";
                   }
                   else 
                   {
                   
                   
                   PreparedStatement ajouterenseignant= this.connection.prepareStatement("INSERT INTO SEANCE_ENSEIGNANT (ID_SEANCE, ID_ENSEIGNANT) VALUES ((SELECT MAX(ID) FROM SEANCE),?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    
                   
                   ajouterenseignant.setInt(1,enseignantrecuperer.getInt("ID"));
                   resultatenseignant = ajouterenseignant.executeUpdate();
                   }
                     
                   }
                   
                   //SALLLE
                   //SALLE
                   //SALLE
                   //SALLE
                   //SALLE
                   //Nous souhaitons vérifier deux points : 1. La capacité de la salle est-elle suffisante ? 
                   // 2. La salle est-elle libre ? 
                   SALLE_EDT salledt = new SALLE_EDT();
                   //on utilise la fonction dans le controller qui permet de trouver toutes les séances associées à la salle
                   
                   salledt.voirSALLE_EDT(SALLENOM);
                   listSEANCESALLE = salledt.getlistSEANCE();
                   
                   for(SEANCE seancesalle : listSEANCESALLE)
                   {
                       if(HEURE_DEBUT.equals(seancesalle.getHEURE_DEBUT()) && DATE.equals(seancesalle.getDATE()) && SEMAINE == seancesalle.getSEMAINE() )
                       {
                           j=0;
                       }
                   }
                   if(j==0)
                   {
                  PreparedStatement supprimerSEANCE_ENSEIGNANT = this.connection.prepareStatement("DELETE FROM SEANCE_ENSEIGNANT ORDER by ID_SEANCE desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  Supprimer_seance_salle = supprimerSEANCE_ENSEIGNANT.executeUpdate();
                       
                  PreparedStatement supprimerSEANCE_SALLE = this.connection.prepareStatement("DELETE FROM SEANCE ORDER by ID desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  resultsallesupp = supprimerSEANCE_SALLE.executeUpdate();
                  
                  return "La salle est occupée";
                       
                   }
                   else{
                       
                   PreparedStatement retrouverSALLE= this.connection.prepareStatement("SELECT ID, CAPACITE FROM SALLE WHERE NOM= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                   retrouverSALLE.setString(1,SALLENOM);
                   ResultSet sallerecuperer = retrouverSALLE.executeQuery(); 
                   if(sallerecuperer.first()==false)
                   {
                       return "Le nom de la salle est invalide";
                   }
                   else 
                   {
                       if(Type_CoursNom.equals("CI"))
                       {
                           if(sallerecuperer.getInt("CAPACITE")<90)
                           {
                            capaciteok=0;
                           }
                       }
                    if(capaciteok==0)
                    {
                  PreparedStatement supprimerSEANCE_ENSEIGNANT = this.connection.prepareStatement("DELETE FROM SEANCE_ENSEIGNANT ORDER by ID_SEANCE desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  Supprimer_seance_salle = supprimerSEANCE_ENSEIGNANT.executeUpdate();
                       
                  PreparedStatement supprimerSEANCE_SALLE = this.connection.prepareStatement("DELETE FROM SEANCE ORDER by ID desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  resultsallesupp = supprimerSEANCE_SALLE.executeUpdate();
                        return "capacite insufissante";
                    }
                    else{
                   PreparedStatement ajoutersalle= this.connection.prepareStatement("INSERT INTO SEANCE_SALLE (ID_SEANCE, ID_SALLE) VALUES ((SELECT MAX(ID) FROM SEANCE),?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                   ajoutersalle.setInt(1,sallerecuperer.getInt("ID"));
                   resultatsalle2 = ajoutersalle.executeUpdate();
                   }
                     
                   }
                   
                   
                   //GROUPE
                   //GROUPE
                   //GROUPE
                   //GROUPE
                   //GROUPE

            GROUPE_EDT groupedt = new GROUPE_EDT();
                
            PreparedStatement recupGROUPE= this.connection.prepareStatement("SELECT g.ID FROM GROUPE g JOIN PROMOTION p ON p.ID=g.ID_PROMOTION WHERE g.NOM = ? AND p.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            recupGROUPE.setString(1,GROUPENOM);
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
                           i=0;
                       }
                   }
                   if(i==0)
                   {
                  
                  PreparedStatement supprimerSEANCE_ENSEIGNANT = this.connection.prepareStatement("DELETE FROM SEANCE_ENSEIGNANT ORDER by ID_SEANCE desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  Supprimer_seance_salle = supprimerSEANCE_ENSEIGNANT.executeUpdate();
                       
                  PreparedStatement supprimerSEANCE_SALLE = this.connection.prepareStatement("DELETE FROM SEANCE_SALLE ORDER by ID_SEANCE desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  resultsallesupp = supprimerSEANCE_SALLE.executeUpdate();
                  
                  PreparedStatement supprimerSEANCE= this.connection.prepareStatement("DELETE FROM SEANCE ORDER by ID desc limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                  resultatsupp = supprimerSEANCE.executeUpdate();
                  
                  return "LE GROUPE N'EST PAS DISPO";
                       
                   }
                   else{                   
                   
                   PreparedStatement ajoutergroupe= this.connection.prepareStatement("INSERT INTO SEANCE_GROUPE (ID_GROUPE, ID_SEANCE) VALUES (?,(SELECT MAX(ID) FROM SEANCE))", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                   ajoutergroupe.setInt(1,recupGROUPEset.getInt("ID"));
                   resultatenseignant = ajoutergroupe.executeUpdate();
                   }
                     
                   }  //recup
                
            }
                   }
                }
            
                   
            
                        
    }catch (SQLException e){
        e.printStackTrace();
    }
        
return "COURS CORRECTEMENT AJOUTEE";

    } 

}


