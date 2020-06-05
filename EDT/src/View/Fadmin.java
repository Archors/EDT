/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import Controller.CONNEXION_UTILISATEUR;
import Model.ADMIN;
import Model.ETUDIANT;
import Model.REFERENT;
import Model.UTILISATEUR;


/**
 *
 * @author Aurélien
 */
public class Fadmin extends JFrame {

    //ETUDIANT student = new ETUDIANT();
    public Fadmin(){}
    public Fadmin(ADMIN admin){
        
        this.setLocationRelativeTo(null);
        this.setTitle("Admin");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        JTabbedPane onglet;
        //Création de plusieurs Panneau
        Padmin tPan = new Padmin(admin);
        Radmin recap = new Radmin();
        Modification modif = new Modification();
        Reporting report = new Reporting();
        //System.out.println("test methode :");
        //Création de notre conteneur d'onglets
        onglet = new JTabbedPane();

        //Méthode d'ajout d'onglet
        onglet.add("Emploi du temps", tPan.getPan());
        onglet.add("Récapitulatif de cours", recap.getPan());
        onglet.add("Modification", modif.getPan());
        onglet.add("Reporting", report.getPan());

        this.getContentPane().add(onglet);
        this.setVisible(true);

    }

}
