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
public class COURSDAO extends DAO<COURS> {
    
public COURSDAO(){}

public boolean create(COURS obj){
    return false; 
}

public boolean delete(COURS obj){
    return false; 
}


public boolean update(COURS obj){
    return false; 
}


    public COURS find(int ID){
    COURS cours= new COURS();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM COURS WHERE ID = " +ID);
        if(result.first())
             cours=new COURS(ID, result.getString("Nom"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    return cours;

    }

}
