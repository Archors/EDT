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
public class ADMINDAO extends DAO<ADMIN> {
    
public ADMINDAO(){}

public boolean create(ADMIN obj){
    return false; 
}


public boolean delete(ADMIN obj){
    return false; 
}


public boolean update(ADMIN obj){
    return false; 
}


public ADMIN find(int ID){
    ADMIN admin= new ADMIN();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM ADMIN JOIN UTILISATEUR u ON u.ID = ADMIN.ID_UTILISATEUR WHERE u.ID=" +ID);
        if(result.first())
             admin=new ADMIN(ID, result.getString("EMAIL"), result.getString("PASSWD"), result.getString("NOM"), result.getString("PRENOM"), result.getInt("DROIT"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    return admin;

    }

}
