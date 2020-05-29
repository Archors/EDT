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
public class GROUPEDAO extends DAO<GROUPE> {
    
public GROUPEDAO(){}

public boolean create(GROUPE obj){
    return false; 
}


public boolean delete(GROUPE obj){
    return false; 
}


public boolean update(GROUPE obj){
    return false; 
}


    public GROUPE find(int ID){
    GROUPE groupe= new GROUPE();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM GROUPE WHERE ID = " +ID);
        if(result.first())
             groupe=new GROUPE(ID, result.getString("Nom"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    return groupe;

    }

}
