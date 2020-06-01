/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */
public class SEANCEDAO extends DAO<SEANCE> {
    
public SEANCEDAO(){}

public boolean create(SEANCE obj){
    return false; 
}

public boolean delete(SEANCE obj){
    return false; 
}


public boolean update(SEANCE obj){
    return false; 
}


    public SEANCE find(int ID){
    SEANCE seance= new SEANCE();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM SEANCE JOIN SEANCE_GROUPE b ON SEANCE.ID = b.ID_SEANCE JOIN GROUPE c ON b.ID_GROUPE = c.ID JOIN SEANCE_SALLE d ON SEANCE.ID = d.ID_SEANCE JOIN SALLE e ON d.ID_SALLE = e.ID JOIN SEANCE_ENSEIGNANT f ON SEANCE.ID = f.ID_SEANCE JOIN ENSEIGNANT g ON f.ID_ENSEIGNANT = g.ID_UTILISATEUR WHERE SEANCE.ID =  " +ID);
        if(result.first())
      
      //on déclare un objet séance et on le remplit grace aux informations récupéré par la requete ResultSet result
      seance=new SEANCE(ID, result.getString("SEMAINE"), result.getString("DATE"), result.getString("HEURE_DEBUT"), result.getString("HEURE_FIN"), result.getInt("ETAT"));
      seance.afficherSEANCE();
      
      //Grace a la relation SEANCE_GROUPE, qui associe une séance a un groupe, on initialisé un objet GROUPE contenant les informations récupérés
      GROUPE groupetest= new GROUPE();
      DAO<GROUPE> groupedaotest = new GROUPEDAO();
      groupetest=groupedaotest.find(result.getInt("ID_GROUPE"));
      
      PROMOTION promotion = new PROMOTION();
      DAO <PROMOTION> promotiondao = new PROMOTIONDAO();
      promotion=promotiondao.find(result.getInt("ID_PROMOTION"));
      System.out.println("Promotion : ");
      promotion.afficherPROMOTION();
      
      SALLE sallete = new SALLE();
      DAO<SALLE> testsalle =new SALLEDAO();
      sallete=testsalle.find(result.getInt("ID_SALLE"));
      System.out.println("Voici la salle de la séance : ");
      sallete.afficherSALLE();
      
      UTILISATEUR saignant = new UTILISATEUR();
      DAO <UTILISATEUR> testsaignant = new UTILISATEURDAO();
      saignant=testsaignant.find(result.getInt("ID_ENSEIGNANT"));
      System.out.println("Voici le prof affecté : ");
      saignant.afficherUTILISATEUR(); 
      
                
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    return seance;

    }

}