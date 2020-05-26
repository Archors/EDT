/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.UTILISATEUR;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */
public class UTILISATEURDAO extends DAO<UTILISATEUR> {
    
public UTILISATEURDAO(){}

public boolean create(UTILISATEUR obj){
    return false; 
}


public boolean delete(UTILISATEUR obj){
    return false; 
}


public boolean update(UTILISATEUR obj){
    return false; 
}


    public UTILISATEUR find(int ID){
    UTILISATEUR utilisateur= new UTILISATEUR();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM UTILISATEUR WHERE ID = " +ID);
        if(result.first())
             utilisateur=new UTILISATEUR(ID, result.getString("EMAIL"), result.getString("PASSWD"), result.getString("NOM"), result.getString("PRENOM"), result.getInt("DROIT"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    return utilisateur;

    }

}
