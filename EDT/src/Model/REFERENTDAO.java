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
public class REFERENTDAO extends DAO<REFERENT> {
    
public REFERENTDAO(){}

public boolean create(REFERENT obj){
    return false; 
}


public boolean delete(REFERENT obj){
    return false; 
}


public boolean update(REFERENT obj){
    return false; 
}


public REFERENT find(int ID){
    REFERENT referent= new REFERENT();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM REFERENT JOIN UTILISATEUR u ON u.ID = REFERENT.ID_UTILISATEUR WHERE u.ID=" +ID);
        if(result.first())
             referent=new REFERENT(ID, result.getString("EMAIL"), result.getString("PASSWD"), result.getString("NOM"), result.getString("PRENOM"), result.getInt("DROIT"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    return referent;

    }

}
