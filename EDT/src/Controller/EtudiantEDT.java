/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.COURS;
import Model.COURSDAO;

import Model.DAO;
import Model.Connexion;

import Model.ETUDIANT;
import Model.ETUDIANTDAO;

import Model.GROUPE;
import Model.GROUPEDAO;

import Model.PROMOTION;
import Model.PROMOTIONDAO;

import Model.SALLE;
import Model.SALLEDAO;

import Model.SEANCE;
import Model.SEANCEDAO;

import Model.SITE;
import Model.SITEDAO;

import Model.TYPE_COURS;
import Model.TYPE_COURSDAO;

import Model.UTILISATEUR;
import Model.UTILISATEURDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Milou
 */
public class EtudiantEDT extends ETUDIANTDAO {
    private List<ETUDIANT> listETUDIANT =new ArrayList<ETUDIANT>();
    GROUPE_EDT groupeedt = new GROUPE_EDT();
    private List<SEANCE> listSEANCE =new ArrayList<SEANCE>();
    private List<UTILISATEUR> listENSEIGNANT =new ArrayList<UTILISATEUR>();
    private List<PROMOTION> listPROMOTION =new ArrayList<PROMOTION>();
    private List<TYPE_COURS> listTYPE_COURS = new ArrayList<TYPE_COURS>();
    private List<COURS> listCOURS = new ArrayList<COURS>();
    private List <SALLE> listSALLE = new ArrayList<SALLE>();

    
    public EtudiantEDT(){}

    public void voirETUDIANT_SEANCE(String Nom, int Semaine)
    {
        //retrouver le groupe en question

        try{ 
      PreparedStatement ps= this.connection.prepareStatement("SELECT * FROM ETUDIANT JOIN UTILISATEUR u ON ETUDIANT.ID_UTILISATEUR = u.ID WHERE u.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       // ps.setString(Nom);
       ps.setString(1,Nom);
       ResultSet resultat = ps.executeQuery();

       while(resultat.next())
       {
        
        ETUDIANT etudiant = new ETUDIANT();
        DAO <ETUDIANT> etudiantdao = new  ETUDIANTDAO();
        etudiant=etudiantdao.find(resultat.getInt("ID"));
        System.out.println("Étudiant : ");
        etudiant.afficherETUDIANT();
        listETUDIANT.add(etudiant);
        
       groupeedt.voirGROUPE_SEANCE(resultat.getInt("ID_GROUPE"), Semaine);
       listSEANCE=groupeedt.getlistSEANCE();  
       listTYPE_COURS=groupeedt.getListTYPE_COURS();
       listCOURS=groupeedt.getListCOURS();
       listENSEIGNANT=groupeedt.getlistENSEIGNANT();
       listPROMOTION=groupeedt.getlistPROMOTION();
       listSALLE=groupeedt.getListSALLE();
       
       }
       /*for(TYPE_COURS i : listTYPE_COURS){
        
       }*/
 
    }catch (SQLException e){
        e.printStackTrace();
    }
        
        
    }
    public List<ETUDIANT> getlistETUDIANT(){
        return listETUDIANT;
    }
    public void addETUDIANT (ETUDIANT etudiant){
      if(this.listETUDIANT.contains(etudiant)!=true)
          this.listETUDIANT.add(etudiant);
        }
    


    public GROUPE_EDT getGroupeedt() {
        return groupeedt;
    }

    public void setGroupeedt(GROUPE_EDT groupeedt) {
        this.groupeedt = groupeedt;
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

    public List<UTILISATEUR> getlistENSEIGNANT(){
        return listENSEIGNANT;
    }
    public List<SEANCE> getlistSEANCE(){
        return listSEANCE;
    }
    public List<PROMOTION> getlistPROMOTION(){
        return listPROMOTION;
    }

    public List<TYPE_COURS> getListTYPE_COURS() {
        return listTYPE_COURS;
    }


    public List<COURS> getListCOURS() {
        return listCOURS;
    }


    public List<SALLE> getListSALLE() {
        return listSALLE;
    }


}