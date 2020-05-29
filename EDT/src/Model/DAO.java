/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author Milou
 */
public abstract class DAO <D> {
    
    Connexion conn =new Connexion();
    protected Connection connection = conn.getConnexion();
    


public abstract boolean create (D obj);
public abstract boolean delete(D obj);
public abstract boolean update (D obj);
public abstract D find(int ID);
    
}
