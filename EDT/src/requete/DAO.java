/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;
import java.sql.Connection;
/**
 *
 * @author Milou
 */
public abstract class DAO <D> {
    protected Connection connection = null;
    


public DAO(Connection connection){
    this.connection=connection;
}

public abstract boolean create (D obj);
public abstract boolean delete(D obj);
public abstract boolean update (D obj);
public abstract D find(int ID);
    
}
