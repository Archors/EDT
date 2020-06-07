/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.SEANCE;
import Model.SEANCEDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */

/** Recoit une séance, vérifie si elle existe et supprime tout ce qui lui est relié dans la BDD */ 
public class SUPPRIMER_SEANCE extends SEANCEDAO{
    public SUPPRIMER_SEANCE() {}
    public String SUPPRIMER_SEANCE_INSTANCE(int SEMAINE, String DATE, String HEURE_DEBUT, String SALLENOM)
    {
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
            else{ //On a récup un cours qui existe
                SEANCE seancerecup = new SEANCE();
                DAO <SEANCE> seancerecupdao = new  SEANCEDAO();
                seancerecup = seancerecupdao.find(recupseanceorigine.getInt("ID"));
                System.out.println("AFFICHAGE ID SEANCE A SUPP" + recupseanceorigine.getInt("s.ID"));
                
            PreparedStatement supp_seance_enseignant= this.connection.prepareStatement("DELETE FROM SEANCE_ENSEIGNANT WHERE ID_SEANCE = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            supp_seance_enseignant.setInt(1,recupseanceorigine.getInt("s.ID"));
            
            resultatenseignant = supp_seance_enseignant.executeUpdate();
            
            PreparedStatement supp_seance_groupe= this.connection.prepareStatement("DELETE FROM SEANCE_GROUPE WHERE ID_SEANCE = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            supp_seance_groupe.setInt(1,recupseanceorigine.getInt("s.ID"));
            
            resultatgroupe = supp_seance_groupe.executeUpdate();
            
            PreparedStatement supp_seance_salle= this.connection.prepareStatement("DELETE FROM SEANCE_SALLE  WHERE ID_SEANCE = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            supp_seance_salle.setInt(1,recupseanceorigine.getInt("s.ID"));
            
            resultatsalle = supp_seance_salle.executeUpdate();
            
            PreparedStatement supp_seance= this.connection.prepareStatement("DELETE FROM SEANCE WHERE ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            supp_seance.setInt(1,recupseanceorigine.getInt("s.ID"));
            
            resultatsupp = supp_seance.executeUpdate();
            
            
                }

    }catch (SQLException e){
        e.printStackTrace();
    }
 return "SEANCE BIEN SUPPRIM´E";   
}
}



