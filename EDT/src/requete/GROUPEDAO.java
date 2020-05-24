/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.GROUPE;
import Model.ETUDIANT;
import javax.sql.DataSource;
import java.sql.SQLException;
/**
 *
 * @author Milou
 */

public class GROUPEDAO extends DAO<GROUPE> {
    
    public GROUPEDAO(Connection conn) {
        super(conn);
    }

public boolean create(GROUPE obj){
    return false; 
}

public boolean delete(GROUPE obj){
    return false; 
}

public boolean update(GROUPE obj){
    return false; 
}
public GROUPE find (int ID){
    GROUPE groupe =new GROUPE();
    
    try{
    ResultSet result=this.connection.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from GROUPE WHERE ID="+ID);
    if(result.first()){
        groupe=new GROUPE(ID, result.getString("NOM"));
    
        ETUDIANTDAO etudiantdao = new ETUDIANTDAO(this.connection);
        result=this.connection.createStatement().executeQuery("SELECT ID,NUMERO, EMAIL, PASSWD, NOM, PRENOM, DROIT FROM ETUDIANT"+"INNER JOIN GROUPE ON ID_GROUPE AND ID="+ID);
    while(result.next())
        groupe.addETUDIANT(etudiantdao.find(result.getInt("ID")));
}
}catch(SQLException e) {
    e.printStackTrace();
}
    return groupe;
}
}
