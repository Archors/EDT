/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milou
 */
import Controller.CONNEXION_UTILISATEUR;
import Controller.GROUPE_EDT;
import Model.ADMIN;
import Model.ETUDIANT;
import Model.REFERENT;
import Model.SEANCE;
import Model.TYPE_COURS;
import Model.UTILISATEUR;
import View.Fenetre;
import java.util.HashSet;
import java.util.Set;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /*
      GROUPE_EDT test = new GROUPE_EDT();
      test.voirGROUPE_SEANCE(1);
      Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
      listSEANCE = test.getlistSEANCE(); */
      
    /*EtudiantEDT etudiantedt = new EtudiantEDT();
    etudiantedt.voirETUDIANT_SEANCE("Bernard");
    Set<SEANCE> listSEANCE = new HashSet<SEANCE>();
    listSEANCE= etudiantedt.getlistSEANCE();

    for (SEANCE seance : listSEANCE)
    {
        System.out.println("COUCOU");
        System.out.println(seance.getHEURE_DEBUT());
    }*/

      GROUPE_EDT test = new GROUPE_EDT();
      test.voirGROUPE_SEANCE(1);
      Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
      Set <TYPE_COURS> listTYPE_COURS =new HashSet <TYPE_COURS>();
      listSEANCE = test.getlistSEANCE(); 
    listTYPE_COURS = test.getListTYPE_COURS();

          for (SEANCE seance : listSEANCE)
    {

        System.out.println(seance.getHEURE_DEBUT());
    }

              for (TYPE_COURS type_cours : listTYPE_COURS)
    {

        System.out.println(type_cours.getNOM());
    }

     Fenetre fenetre = new Fenetre();

    
    
    CONNEXION_UTILISATEUR connect = new CONNEXION_UTILISATEUR();
    connect.VERIFCONNEXION_UTILISATEUR("davodet@gmail.com", "davodet");
    if (connect.isConnexion()==false)
    {
        System.out.println("MAUVAISE INFO");
    }
    else {
        if(connect.getDroit()==4)
        {
    ETUDIANT etudiant = new ETUDIANT();
    etudiant=connect.getEtudiant();
    etudiant.afficherETUDIANT(); 
        }
        else if (connect.getDroit()==1)
        {
            ADMIN admin = new ADMIN();
            admin=connect.getAdmin();
            admin.afficherADMIN();
        }
        
        else if (connect.getDroit()==2)
        {
            REFERENT referent = new REFERENT();
            referent=connect.getReferent();
            referent.afficherREFERENT();
        }
        else if (connect.getDroit()==3)
        {
            UTILISATEUR utilisateur =new UTILISATEUR();
            utilisateur = connect.getUtilisateur();
            utilisateur.afficherUTILISATEUR();
        }
        
        }
        //Fenetre fenetre = new Fenetre();

      
     // PROMOTION_EDT promotionedt =new PROMOTION_EDT();
     // promotionedt.voirPROMOTION_SEANCE("2022");
    /*  String SEMAINE = "Semaine";
      String DATE = "DATE";
      String HEURE_DEBUT ="heure_debut";
      String HEURE_FIN ="heure_fin";
      int ETAT = 0;
      int id_cours = 1;
      int id_type = 1; 
      ADD_SEANCE add_seance = new ADD_SEANCE();
      add_seance.AJOUTER_SEANCE(SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT,id_cours, id_type); */
      
      
    }
    
}
