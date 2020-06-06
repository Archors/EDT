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
import Model.PROMOTION;
import Model.PROMOTIONDAO;
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
public class SEANCE_PROMOTION extends PROMOTIONDAO{
    private List <PROMOTION> listPROMOTION = new ArrayList<>();
    public SEANCE_PROMOTION() {}
    
    public SEANCE_PROMOTION(int SEANCEID)
    {
    
try{
          
       
        PreparedStatement ps = this.connection.prepareStatement("SELECT p.ID FROM PROMOTION p JOIN GROUPE g ON g.ID_PROMOTION = p.ID JOIN SEANCE_GROUPE sg ON g.ID = sg.ID_GROUPE JOIN SEANCE s ON s.ID=sg.ID_SEANCE WHERE s.ID = ?  ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1,SEANCEID);
        ResultSet result = ps.executeQuery();
        
        while(result.next())         
        {    
           PROMOTION promotest = new PROMOTION();
           DAO <PROMOTION> promotestdao = new PROMOTIONDAO();
           promotest = promotestdao.find(result.getInt("ID"));
           listPROMOTION.add(promotest);
        }
       

    }catch (SQLException e){
        e.printStackTrace();
    }
    /*afficherLISTEENSEIGNANT();
    afficherLISTEPROMOTION();
    afficherLISTESEANCE();*/
}
    
    
        public void addGROUPE (PROMOTION promotion){
        if(this.listPROMOTION.contains(promotion)!=true)
            this.listPROMOTION.add(promotion);
    }

    public List<PROMOTION> getlistGROUPE(){
        return listPROMOTION;
    }
    
}
