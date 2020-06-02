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
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Milou
 */
public class GROUPE_EDT extends GROUPEDAO {
    public GROUPE_EDT(){}

    private Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
    private Set<UTILISATEUR> listENSEIGNANT =new HashSet<UTILISATEUR>();
    private Set<PROMOTION> listPROMOTION =new HashSet<PROMOTION>();
    private Set<TYPE_COURS> listTYPE_COURS = new HashSet<TYPE_COURS>();
    private Set<COURS> listCOURS = new HashSet<COURS>();
    private Set <SALLE> listSALLE = new HashSet<SALLE>();

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
          
       
        PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM GROUPE JOIN SEANCE_GROUPE a ON GROUPE.ID = a.ID_GROUPE JOIN SEANCE b ON a.ID_SEANCE = b.ID JOIN SEANCE_SALLE d ON b.ID = d.ID_SEANCE JOIN SALLE e ON d.ID_SALLE = e.ID JOIN SEANCE_ENSEIGNANT f ON b.ID = f.ID_SEANCE JOIN ENSEIGNANT g ON f.ID_ENSEIGNANT = g.ID_UTILISATEUR WHERE GROUPE.ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1,ID);
        ResultSet result = ps.executeQuery();
        
        while(result.next()) 
            
        
        {    
            
        //on créee un objet séance contenant les informations récupérés (ID_SEANCE) de la BDD
        SEANCE seancetest= new SEANCE();
        DAO<SEANCE> seancedaotest = new SEANCEDAO();
        seancetest=seancedaotest.find(result.getInt("ID_SEANCE"));
        listSEANCE.add(seancetest);
        
        //On récupere dans la BDD, le type_cours associé à la séance 
        TYPE_COURS test = new TYPE_COURS();
        DAO<TYPE_COURS> test2 = new TYPE_COURSDAO();
        test=test2.find(result.getInt("ID_TYPE"));
        //on remplit une liste TYPE_COURS afin de la retourner au vue
        listTYPE_COURS.add(test);
        
        //Meme systeme que pour type_cours
        COURS recupcours= new COURS();
        DAO<COURS> recupcoursdao = new COURSDAO();
        recupcours=recupcoursdao.find(result.getInt("ID_COURS"));
        listCOURS.add(recupcours);
        
        UTILISATEUR saignant = new UTILISATEUR();
        DAO <UTILISATEUR> testsaignant = new UTILISATEURDAO();
        saignant=testsaignant.find(result.getInt("ID_ENSEIGNANT"));
        listENSEIGNANT.add(saignant);
        
        PROMOTION promotion = new PROMOTION();
        DAO <PROMOTION> promotiondao = new PROMOTIONDAO();
        promotion=promotiondao.find(result.getInt("ID_PROMOTION"));
        listPROMOTION.add(promotion);

        SALLE sallete = new SALLE();
        DAO<SALLE> testsalle =new SALLEDAO();
        sallete=testsalle.find(result.getInt("ID_SALLE"));
        listSALLE.add(sallete);


        }

    }catch (SQLException e){
        e.printStackTrace();
    }
    /*afficherLISTEENSEIGNANT();
    afficherLISTEPROMOTION();
    afficherLISTESEANCE();*/
}
public void afficherLISTESEANCE(){
           
    for (SEANCE seance : listSEANCE)
    {
        System.out.println(seance.getSEMAINE());
    }
    
    }
public void afficherLISTEENSEIGNANT(){
           
    for (UTILISATEUR enseignant : listENSEIGNANT)
    {
        System.out.println(enseignant.getEMAIL());
    }
    
}
public void afficherLISTEPROMOTION(){
           
    for (PROMOTION promotion : listPROMOTION)
    {
        System.out.println(promotion.getNOM());
    }
    
    }
    public void addSEANCE (SEANCE seance){
        if(this.listSEANCE.contains(seance)!=true)
            this.listSEANCE.add(seance);
    }
    
    public void addCOURS (COURS cours){
        if(this.listCOURS.contains(cours)!=true)
            this.listCOURS.add(cours);
    }
    
    public void addTYPE_COURS (TYPE_COURS type_cours){
        if(this.listTYPE_COURS.contains(type_cours)!=true)
            this.listTYPE_COURS.add(type_cours);
    }
    

    public void addUTILISATEUR (UTILISATEUR utilisateur){
        if(this.listENSEIGNANT.contains(utilisateur)!=true)
            this.listENSEIGNANT.add(utilisateur);
    }

    public void addPROMOTION (PROMOTION promotion){
        if(this.listPROMOTION.contains(promotion)!=true)
            this.listPROMOTION.add(promotion);
    }
    
    public void addSALLE (SALLE salle){
        if(this.listSALLE.contains(salle)!=true)
            this.listSALLE.add(salle);
    }

    public Set<UTILISATEUR> getlistENSEIGNANT(){
        return listENSEIGNANT;
    }
    public Set<SEANCE> getlistSEANCE(){
        return listSEANCE;
    }
    public Set<PROMOTION> getlistPROMOTION(){
        return listPROMOTION;
    }

    public Set<TYPE_COURS> getListTYPE_COURS() {
        return listTYPE_COURS;
    }

    public void setListTYPE_COURS(Set<TYPE_COURS> listTYPE_COURS) {
        this.listTYPE_COURS = listTYPE_COURS;
    }

    public Set<COURS> getListCOURS() {
        return listCOURS;
    }

    public void setListCOURS(Set<COURS> listCOURS) {
        this.listCOURS = listCOURS;
    }

    public Set<SALLE> getListSALLE() {
        return listSALLE;
    }

    public void setListSALLE(Set<SALLE> listSALLE) {
        this.listSALLE = listSALLE;
    }


    }