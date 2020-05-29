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
public class TYPE_COURSDAO extends DAO<TYPE_COURS> {
    
public TYPE_COURSDAO(){}

public boolean create(TYPE_COURS obj){
    return false; 
}

public boolean delete(TYPE_COURS obj){
    return false; 
}


public boolean update(TYPE_COURS obj){
    return false; 
}


    public TYPE_COURS find(int ID){
    TYPE_COURS type_cours= new TYPE_COURS();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM TYPE_COURS WHERE ID = " +ID);
        if(result.first())
             type_cours=new TYPE_COURS(ID, result.getString("Nom"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    return type_cours;

    }

}