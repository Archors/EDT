/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.SALLE;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */
public class SALLEDAO extends DAO<SALLE> {
    
public SALLEDAO(){}

public boolean create(SALLE obj){
    return false; 
}

public boolean delete(SALLE obj){
    return false; 
}


public boolean update(SALLE obj){
    return false; 
}


    public SALLE find(int ID){
    SALLE salle= new SALLE();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM SALLE WHERE ID = " +ID);
        if(result.first())
             salle=new SALLE(ID, result.getString("Nom"), result.getInt("CAPACITE"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    return salle;

    }

}