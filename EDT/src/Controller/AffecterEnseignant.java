/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ADMIN;
import Model.ADMINDAO;
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
import Model.REFERENT;
import Model.REFERENTDAO;

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

// classe faisant partie du controller qui recoit l'identifiant d'une séance en parametre
// et qui affecte un Enseignant capable d'enseigner et libre sur le créneau
//ID correspond donc à l'identifiant de la séance

public class AffecterEnseignant extends SEANCEDAO {
   private List<SEANCE> listSEANCE =new ArrayList<SEANCE>();
   private List<UTILISATEUR> listENSEIGNANT =new ArrayList<UTILISATEUR>();
   private ETUDIANT etudiant = new ETUDIANT();
   private ADMIN admin = new ADMIN();
   private REFERENT referent= new REFERENT();
   private UTILISATEUR utilisateur = new UTILISATEUR();
   private SEANCE SEANCEinitial = new SEANCE();
   private SEANCE SEANCEFINAL=new SEANCE();
   private List<SEANCE> SEANCEfinal =new ArrayList<SEANCE>();
   private List<SEANCE> listfinale = new ArrayList<SEANCE>();
   private List<UTILISATEUR> enseignantdispo = new ArrayList<UTILISATEUR>();
   private int i;

    public AffecterEnseignant(){}
    
    public AffecterEnseignant (int ID)
    {
  
    SEANCE SEANCEinitial= new SEANCE();
    DAO<SEANCE> testdao = new SEANCEDAO();
    SEANCEinitial=testdao.find(ID);
        
            try {    
    PreparedStatement cours2 =this.connection.prepareStatement("SELECT ID_COURS FROM COURS c JOIN SEANCE s ON s.ID_COURS=c.ID WHERE s.ID= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    cours2.setInt(1,ID);
    ResultSet recupcours = cours2.executeQuery();

    if (recupcours.first()==false)
    {
    }
    else {
        COURS coursinitial = new COURS();
        DAO <COURS> coursdaoinitial = new COURSDAO();
        coursinitial = coursdaoinitial.find(recupcours.getInt("ID_COURS"));    }
    
    PreparedStatement enseignantrecup =this.connection.prepareStatement("SELECT DISTINCT ID_UTILISATEUR FROM ENSEIGNANT e JOIN COURS c ON e.ID_COURS=c.ID WHERE c.ID= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    enseignantrecup.setInt(1,recupcours.getInt("ID_COURS"));
    ResultSet recupenseignant = enseignantrecup.executeQuery();
    int j=0;
    while(recupenseignant.next())
    {
        UTILISATEUR enseignant = new UTILISATEUR();
        DAO <UTILISATEUR> enseignantdao = new UTILISATEURDAO();
        enseignant = enseignantdao.find(recupenseignant.getInt("ID_UTILISATEUR"));
        listENSEIGNANT.add(enseignant);
    }

    for (UTILISATEUR enseignanttest : listENSEIGNANT)
 {
    i=0;
    PreparedStatement finale =this.connection.prepareStatement("SELECT ID_SEANCE FROM UTILISATEUR a JOIN ENSEIGNANT b ON b.ID_UTILISATEUR = a.ID JOIN SEANCE_ENSEIGNANT c ON c.ID_ENSEIGNANT = b.ID_UTILISATEUR JOIN SEANCE d ON d.ID = c.ID_SEANCE WHERE a.ID = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    finale.setInt(1,enseignanttest.getID());
    ResultSet seancerecup = finale.executeQuery();

    while(seancerecup.next())
    { 
        SEANCE seancefinals = new SEANCE();
        DAO <SEANCE> seancetrouver = new SEANCEDAO();
        seancefinals = seancetrouver.find(seancerecup.getInt("ID_SEANCE"));
        SEANCEfinal.add(seancefinals);
    }
    
    
 
    for (SEANCE seanceaffichage : SEANCEfinal)
    {
        System.out.println("AFFICHAGE " + seanceaffichage.getDATE());
        
        if(SEANCEinitial.getHEURE_DEBUT().equals(seanceaffichage.getHEURE_DEBUT()) && (SEANCEinitial.getDATE().equals(seanceaffichage.getDATE())))
        {
           i=1; 
        }

    }
    
    if(i!=1)
    {
        enseignantdispo.add(enseignanttest);
    }
    
  SEANCEfinal.clear(); 
 }
    
    
       }catch (SQLException e){
        e.printStackTrace();
    }
            for(UTILISATEUR dispo : enseignantdispo)
            {
                System.out.println("PROF DISPO " + dispo.getNOM());
            }
    } 
               }




