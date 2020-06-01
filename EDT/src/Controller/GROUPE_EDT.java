/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.COURS;
import Model.COURSDAO;

import Model.DAO;

import Model.ETUDIANT;

import Model.GROUPE;
import Model.GROUPEDAO;


import Model.SEANCE;
import Model.SEANCEDAO;


import Model.TYPE_COURS;
import Model.TYPE_COURSDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Milou
 */
public class GROUPE_EDT extends GROUPEDAO {
    public GROUPE_EDT(){}

    private Set<SEANCE> listSEANCE =new HashSet<SEANCE>();

    public void voirGROUPE_SEANCE(int ID)
    {
        //retrouver le groupe en question
        GROUPE groupe = new GROUPE();
        DAO <GROUPE> groupe2 = new  GROUPEDAO();
        groupe=groupe2.find(ID);
        System.out.println("EDT du GROUPE : ");
        groupe.afficherGROUPE();
      //retrouver les cours auquel il appartient
      try{
          
       
        PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM GROUPE JOIN SEANCE_GROUPE a ON GROUPE.ID = a.ID_GROUPE JOIN SEANCE b ON a.ID_SEANCE = b.ID WHERE GROUPE.ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1,ID);
        ResultSet result = ps.executeQuery();
        
        while(result.next()) 
            
        
        {    
            
        //on créee un objet séance contenant les informations récupérés (ID_SEANCE) de la BDD
        SEANCE seancetest= new SEANCE();
        DAO<SEANCE> seancedaotest = new SEANCEDAO();
        seancetest=seancedaotest.find(result.getInt("ID_SEANCE"));
        listSEANCE.add(seancetest);
        //affichage du type du cours en récupérant ID_TYPE par la requête SQL
        TYPE_COURS test = new TYPE_COURS();
        DAO<TYPE_COURS> test2 =new TYPE_COURSDAO();
        test=test2.find(result.getInt("ID_TYPE"));
        //test.afficherTYPE();
        
        //affichage du cours en récupérant l'ID Cours par la requete SQL
        COURS recupcours=new COURS();
        DAO<COURS> recupcoursdao = new COURSDAO();
        recupcours=recupcoursdao.find(result.getInt("ID_COURS"));
        afficherLISTESEANCE();
        }

    }catch (SQLException e){
        e.printStackTrace();
    }
}
public void afficherLISTESEANCE(){
           
    for (SEANCE seance : listSEANCE)
    {
        System.out.println("............"+seance.getSEMAINE());
    }
    
    }
    public void addSEANCE (SEANCE seance){
        if(this.listSEANCE.contains(seance)!=true)
            this.listSEANCE.add(seance);
    }

    public Set<ETUDIANT> getlistSeance(){
        return listSEANCE;
    }


    }