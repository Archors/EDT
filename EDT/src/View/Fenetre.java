/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Antoine
 */
public class Fenetre extends JFrame {

    //Contient une liste d'objet Seance à afficher par le view
    private Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
    //Contient une liste d'objet Utilisateur à afficher par le view
    private Set<UTILISATEUR> listUTILISATEUR =new HashSet<UTILISATEUR>();
    //Contient une liste d'objet Promotion à afficher par le view
    private Set<PROMOTION> listPROMOTION =new HashSet<PROMOTION>();
  
   
  public Fenetre(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneurs");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setDefaultLookAndFeelDecorated(true);
    this.setExtendedState(this.MAXIMIZED_BOTH);

    eleve();

    this.setVisible(true);
  }

  public void eleve(){

    JTabbedPane onglet;
        //Création de plusieurs Panneau
    Panneau[] tPan = {new Panneau(Color.RED), new Panneau(Color.GREEN)};
      
    //Création de notre conteneur d'onglets
    onglet = new JTabbedPane();

    //Méthode d'ajout d'onglet
     onglet.add("Emploi du temps", tPan[0]);
     onglet.add("Récapitulatif de cours", tPan[1]);
      
    //On passe ensuite les onglets au content pane
    this.getContentPane().add(onglet);
    }
   
  public static void main(String[] args){
    Fenetre fen = new Fenetre();
  }   
}