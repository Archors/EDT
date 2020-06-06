/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.COURS;
import Model.COURSDAO;
import Model.DAO;
import Model.GROUPE;
import Model.GROUPEDAO;
import Model.SALLE;
import Model.SALLEDAO;
import Model.SEANCE;
import Model.SEANCEDAO;
import Model.TYPE_COURS;
import Model.TYPE_COURSDAO;
import Model.UTILISATEUR;
import Model.UTILISATEURDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milou
 */
public class SEANCE_GROUPE extends SEANCEDAO{
    private List <GROUPE> listGROUPE = new ArrayList<GROUPE>();
    public SEANCE_GROUPE(int SEANCEID)
    {
    
try{
          
       
        PreparedStatement ps = this.connection.prepareStatement("SELECT g.ID FROM GROUPE g JOIN SEANCE_GROUPE sg ON g.ID = sg.ID_GROUPE JOIN SEANCE s ON s.ID=sg.ID_SEANCE WHERE s.ID = ?  ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1,SEANCEID);
        ResultSet result = ps.executeQuery();
        
        while(result.next())         
        {    
           GROUPE groupetest = new GROUPE();
           DAO <GROUPE> groupetestdao = new GROUPEDAO();
           groupetest = groupetestdao.find(result.getInt("ID"));
           listGROUPE.add(groupetest);
           
           

        }

    }catch (SQLException e){
        e.printStackTrace();
    }
    /*afficherLISTEENSEIGNANT();
    afficherLISTEPROMOTION();
    afficherLISTESEANCE();*/
}
    
    
        public void addGROUPE (GROUPE groupe){
        if(this.listGROUPE.contains(groupe)!=true)
            this.listGROUPE.add(groupe);
    }

    public List<GROUPE> getlistGROUPE(){
        return listGROUPE;
    }
    
}
