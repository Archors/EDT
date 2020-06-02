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
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Milou
 */
public class PROMOTION_EDT extends ETUDIANTDAO {
    private Set<GROUPE> listGROUPE =new HashSet<GROUPE>();
    private Set<ETUDIANT> listETUDIANT =new HashSet<ETUDIANT>();
    private GROUPE_EDT groupeedt = new GROUPE_EDT();
    private Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
    private Set<UTILISATEUR> listENSEIGNANT =new HashSet<UTILISATEUR>();
    private Set<PROMOTION> listPROMOTION =new HashSet<PROMOTION>();
    private Set<TYPE_COURS> listTYPE_COURS = new HashSet<TYPE_COURS>();
    private Set<COURS> listCOURS = new HashSet<COURS>();
    private Set <SALLE> listSALLE = new HashSet<SALLE>();

    
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
    public Set<GROUPE> getlistGROUPE(){
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

    public Set<GROUPE> getListGROUPE() {
        return listGROUPE;
    }

    public void setListGROUPE(Set<GROUPE> listGROUPE) {
        this.listGROUPE = listGROUPE;
    }

    public Set<ETUDIANT> getListETUDIANT() {
        return listETUDIANT;
    }

    public void setListETUDIANT(Set<ETUDIANT> listETUDIANT) {
        this.listETUDIANT = listETUDIANT;
    }

    public Set<SEANCE> getListSEANCE() {
        return listSEANCE;
    }

    public void setListSEANCE(Set<SEANCE> listSEANCE) {
        this.listSEANCE = listSEANCE;
    }

    public Set<UTILISATEUR> getListENSEIGNANT() {
        return listENSEIGNANT;
    }

    public void setListENSEIGNANT(Set<UTILISATEUR> listENSEIGNANT) {
        this.listENSEIGNANT = listENSEIGNANT;
    }

    public Set<PROMOTION> getListPROMOTION() {
        return listPROMOTION;
    }

    public void setListPROMOTION(Set<PROMOTION> listPROMOTION) {
        this.listPROMOTION = listPROMOTION;
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