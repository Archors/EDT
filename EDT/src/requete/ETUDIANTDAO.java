/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.ETUDIANT;
import Model.UTILISATEUR;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */
public class ETUDIANTDAO extends DAO<ETUDIANT> {
    
public ETUDIANTDAO(){}

public boolean create(ETUDIANT obj){
    return false; 
}


public boolean delete(ETUDIANT obj){
    return false; 
}


public boolean update(ETUDIANT obj){
    return false; 
}


public ETUDIANT find(int ID){
    ETUDIANT etudiant= new ETUDIANT();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM ETUDIANT JOIN UTILISATEUR u ON u.ID = ETUDIANT.ID_UTILISATEUR WHERE u.ID=" +ID);
        if(result.first())
             etudiant=new ETUDIANT(ID, result.getString("NUMERO"), result.getString("EMAIL"), result.getString("PASSWD"), result.getString("NOM"), result.getString("PRENOM"), result.getInt("DROIT"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    return etudiant;

    }

}
