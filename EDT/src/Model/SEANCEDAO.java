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
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM SEANCE JOIN SEANCE_GROUPE b ON SEANCE.ID = b.ID_SEANCE JOIN GROUPE c ON b.ID_GROUPE = c.ID JOIN SEANCE_SALLE d ON SEANCE.ID = d.ID_SEANCE JOIN SALLE e ON d.ID_SALLE = e.ID JOIN SEANCE_ENSEIGNANT f ON f.ID_SEANCE = SEANCE.ID JOIN ENSEIGNANT g ON g.ID_UTILISATEUR = f.ID_ENSEIGNANT WHERE SEANCE.ID =  " +ID);

        if(!result.first())
        {

        }
        if(result.first())

      //on déclare un objet séance et on le remplit grace aux informations récupéré par la requete ResultSet result
      seance=new SEANCE(ID, result.getInt("SEMAINE"), result.getString("DATE"), result.getString("HEURE_DEBUT"), result.getString("HEURE_FIN"), result.getInt("ETAT"));

    }catch (SQLException e){
        e.printStackTrace();
    }

    return seance;

    }

}