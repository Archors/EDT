/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CONNEXION_UTILISATEUR;
import Model.ADMIN;
import Model.ETUDIANT;
import Model.REFERENT;
import Model.UTILISATEUR;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Aurélien
 */
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

public class Fconnexion extends JFrame {

  
   private int id;
    private int con = 0;
    ETUDIANT student = new ETUDIANT();
    private JPanel pr = new JPanel();

    public Fconnexion(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneurs");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setDefaultLookAndFeelDecorated(true);
    this.setExtendedState(this.MAXIMIZED_BOTH);
    
    //private ETUDIANT etudiant;
    //private ETUDIANT etudiant;
    //private ETUDIANT etudiant;
    pr.setPreferredSize(new Dimension(1350, 510));
    pr.setBackground(Color.ORANGE); 
    
  
       JPanel pan = new JPanel();

        JLabel labuser = new JLabel("Username");
        pan.add(labuser);

        JLabel labpassword = new JLabel("Password");
        pan.add(labpassword);

        JTextField username = new JTextField("Username");
        pan.add(username);
        

        JPasswordField password = new JPasswordField("Password");
        pan.add(password);

        JButton login = new JButton("Login");
        
        
        pan.add(login);  

        pr.add(pan);      
        this.setContentPane(pr);

        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              
                String uname = username.getText();
                String pwd = String.valueOf(password.getPassword());
                CONNEXION_UTILISATEUR connect = new CONNEXION_UTILISATEUR();
                connect.VERIFCONNEXION_UTILISATEUR(uname, pwd);
    if (connect.isConnexion()==false)
    {
         //Boîte du message d'information
         JOptionPane jop1 = new JOptionPane();
         jop1.showMessageDialog(null, "Identifiants incorrects", "Connexion", JOptionPane.INFORMATION_MESSAGE);
    }
    else {
        if(connect.getDroit()==4)
        {
            System.out.println("test 3:");
            ETUDIANT etudiant = new ETUDIANT();
            etudiant=connect.getEtudiant();
            //etudiant.afficherETUDIANT(); 
            con = 1;
            //student = etudiant; 
            
            //pr.removeAll();
            //Panneau tPan = new Panneau(etudiant);
            //pr.paint();
            Fetudiant fetudiant = new Fetudiant(etudiant);
            //fenetre.dispose();
            //this.dispose();
            //eleve(student); 
            
            //pr.add(tPan.getPan());
            //pr.repaint();
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
      }
    });
       //this.setContentPane(pr);
       this.setVisible(true);
  }

    
    public void connexion(){

        

        //On prévient notre JFrame que notre JPanel sera son content pane
        
       // this.setVisible(true);
    }

  public void eleve(ETUDIANT etudiant){
    
    JTabbedPane onglet;
    //Création de plusieurs Panneau
    Panneau tPan = new Panneau(etudiant);
    Recapitulatif recap = new Recapitulatif();
    //System.out.println("test methode :");
    //Création de notre conteneur d'onglets
    onglet = new JTabbedPane();

    //Méthode d'ajout d'onglet
     onglet.add("Emploi du temps", tPan.getPan());
     onglet.add("Récapitulatif de cours", recap);
      
    
    this.getContentPane().add(onglet);
    //etudiant.afficherETUDIANT();
    }

  
}