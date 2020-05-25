/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.SITE;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */
public class SITEDAO extends DAO<SITE> {
    
public SITEDAO(){}

public boolean create(SITE obj){
    return false; 
}

public boolean delete(SITE obj){
    return false; 
}


public boolean update(SITE obj){
    return false; 
}


    public SITE find(int ID){
    SITE site= new SITE();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM SITE WHERE ID = " +ID);
        if(result.first())
             site=new SITE(ID, result.getString("Nom"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    return site;

    }

}