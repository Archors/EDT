/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.PROMOTION;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */
public class PROMOTIONDAO extends DAO<PROMOTION> {
    
public PROMOTIONDAO(){}

public boolean create(PROMOTION obj){
    return false; 
}


public boolean delete(PROMOTION obj){
    return false; 
}


public boolean update(PROMOTION obj){
    return false; 
}


    public PROMOTION find(int ID){
    PROMOTION promotion= new PROMOTION();
    
    try{
        ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM PROMOTION WHERE ID = " +ID);
        if(result.first())
             promotion=new PROMOTION(ID, result.getString("Nom"));
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    return promotion;

    }

}
