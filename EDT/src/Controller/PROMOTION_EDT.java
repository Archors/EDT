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
public class PROMOTION_EDT extends ETUDIANTDAO {
    private List<GROUPE> listGROUPE =new ArrayList<GROUPE>();
    private List<ETUDIANT> listETUDIANT =new ArrayList<ETUDIANT>();
    private GROUPE_EDT groupeedt = new GROUPE_EDT();
    private List<SEANCE> listSEANCE =new ArrayList<SEANCE>();
    private List<UTILISATEUR> listENSEIGNANT =new ArrayList<UTILISATEUR>();
    private List<PROMOTION> listPROMOTION =new ArrayList<PROMOTION>();
    private List<TYPE_COURS> listTYPE_COURS = new ArrayList<TYPE_COURS>();
    private List<COURS> listCOURS = new ArrayList<COURS>();
    private List <SALLE> listSALLE = new ArrayList<SALLE>();

    
    public PROMOTION_EDT(){}

    public void voirPROMOTION_SEANCE(String Nom)
    {
        //retrouver le groupe en question

        try{ 
       PreparedStatement ps= this.connection.prepareStatement("SELECT u.ID FROM PROMOTION JOIN GROUPE u ON PROMOTION.ID = u.ID_PROMOTION WHERE PROMOTION.NOM = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       // ps.setString(Nom);
       ps.setString(1,Nom);
       ResultSet resultat = ps.executeQuery();

      while(resultat.next())
        { 
        groupeedt.voirGROUPE_SEANCE(resultat.getInt("ID")); 
        listSEANCE=groupeedt.getlistSEANCE();
        listTYPE_COURS=groupeedt.getListTYPE_COURS();
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
        


    }
    public List<GROUPE> getlistGROUPE(){
        return listGROUPE;
    }
    public void addGROUPE (GROUPE groupe){
      if(this.listGROUPE.contains(groupe)!=true)
          this.listGROUPE.add(groupe);
        }
public void afficherLISTEGROUPE(){
           
    for (GROUPE groupe : listGROUPE)
    {
        System.out.println("............"+groupe.getNOM());
    }
}

    public List<GROUPE> getListGROUPE() {
        return listGROUPE;
    }

    public void setListGROUPE(List<GROUPE> listGROUPE) {
        this.listGROUPE = listGROUPE;
    }

    public List<ETUDIANT> getListETUDIANT() {
        return listETUDIANT;
    }

    public void setListETUDIANT(List<ETUDIANT> listETUDIANT) {
        this.listETUDIANT = listETUDIANT;
    }

    public List<SEANCE> getListSEANCE() {
        return listSEANCE;
    }

    public void setListSEANCE(List<SEANCE> listSEANCE) {
        this.listSEANCE = listSEANCE;
    }

    public List<UTILISATEUR> getListENSEIGNANT() {
        return listENSEIGNANT;
    }

    public void setListENSEIGNANT(List<UTILISATEUR> listENSEIGNANT) {
        this.listENSEIGNANT = listENSEIGNANT;
    }

    public List<PROMOTION> getListPROMOTION() {
        return listPROMOTION;
    }

    public void setListPROMOTION(List<PROMOTION> listPROMOTION) {
        this.listPROMOTION = listPROMOTION;
    }

    public List<TYPE_COURS> getListTYPE_COURS() {
        return listTYPE_COURS;
    }

    public void setListTYPE_COURS(List<TYPE_COURS> listTYPE_COURS) {
        this.listTYPE_COURS = listTYPE_COURS;
    }

    public List<COURS> getListCOURS() {
        return listCOURS;
    }

    public void setListCOURS(List<COURS> listCOURS) {
        this.listCOURS = listCOURS;
    }

    public List<SALLE> getListSALLE() {
        return listSALLE;
    }

    public void setListSALLE(List<SALLE> listSALLE) {
        this.listSALLE = listSALLE;
    }

}