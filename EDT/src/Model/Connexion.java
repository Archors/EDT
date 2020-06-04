/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Milou
 */
public class Connexion {

    private static Connection conn;
    private static Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    
    private static String url ="jdbc:mysql://localhost:8889/edt";
    private static String nameuser="root";

    private static String psswd = "root";

    
    public Connection getConnexion() {
        if (conn == null){
            try{
                 Class.forName("com.mysql.jdbc.Driver");
            }catch (Exception e){
                e.printStackTrace();
            }
            
            try{
                conn=DriverManager.getConnection(url,nameuser,psswd);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    	

}
