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
public class SALLE_EDT extends SALLEDAO {
    public SALLE_EDT(){}

    private Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
    private Set<UTILISATEUR> listENSEIGNANT =new HashSet<UTILISATEUR>();
    private Set<PROMOTION> listPROMOTION =new HashSet<PROMOTION>();
    private Set<TYPE_COURS> listTYPE_COURS = new HashSet<TYPE_COURS>();
    private Set<COURS> listCOURS = new HashSet<COURS>();
    private Set <SALLE> listSALLE = new HashSet<SALLE>();
    private Set <GROUPE> listGROUPE = new HashSet<GROUPE>();

    public void voirSALLE_EDT(String Nom)
    {
      try{
          

        
        PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM SALLE a JOIN SEANCE_SALLE b ON a.ID = b.ID_SALLE JOIN SEANCE c ON c.ID = b.ID_SEANCE JOIN SEANCE_ENSEIGNANT d ON d.ID_SEANCE = c.ID JOIN ENSEIGNANT f ON f.ID_UTILISATEUR = d.ID_ENSEIGNANT JOIN SEANCE_GROUPE g ON g.ID_SEANCE = c.ID JOIN GROUPE h ON h.ID=g.ID_GROUPE WHERE a.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setString(1,Nom);
        ResultSet result = ps.executeQuery();
        while(result.next())         
        {    
        SALLE sallete = new SALLE();
        DAO<SALLE> testsalle =new SALLEDAO();
        sallete=testsalle.find(result.getInt("ID_SALLE"));
        
            
        UTILISATEUR saignant = new UTILISATEUR();
        DAO <UTILISATEUR> testsaignant = new UTILISATEURDAO();
        saignant=testsaignant.find(result.getInt("ID"));
        listENSEIGNANT.add(saignant);
        
        GROUPE groupe = new GROUPE();
        DAO <GROUPE> groupedao = new GROUPEDAO();
        groupe=groupedao.find(result.getInt("ID_GROUPE"));
        listGROUPE.add(groupe);
        
        //on créee un objet séance contenant les informations récupérés (ID_SEANCE) de la BDD
        SEANCE seancetest= new SEANCE();
        DAO<SEANCE> seancedaotest = new SEANCEDAO();
        seancetest=seancedaotest.find(result.getInt("ID_SEANCE"));
        listSEANCE.add(seancetest);
        
        
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
        
        PROMOTION promotion = new PROMOTION();
        DAO <PROMOTION> promotiondao = new PROMOTIONDAO();
        promotion = promotiondao.find(result.getInt("ID_PROMOTION"));
        listPROMOTION.add(promotion);
        
        
        
        




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

    public Set<GROUPE> getListGROUPE() {
        return listGROUPE;
    }

    public void setListGROUPE(Set<GROUPE> listGROUPE) {
        this.listGROUPE = listGROUPE;
    }


    }