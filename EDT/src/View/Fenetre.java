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

public class Fenetre extends JFrame {

  
   private int id;

  public Fenetre(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneurs");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setDefaultLookAndFeelDecorated(true);
    this.setExtendedState(this.MAXIMIZED_BOTH);

    connexion();


    this.setVisible(true);
  }

    public void connexion(){

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

        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              
                String uname = username.getText();
                String pwd = password.getText();
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
    etudiant.afficherETUDIANT();
    System.out.println("test 1 :");

    eleve(etudiant); 
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

        

        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);               
        this.setVisible(true);
    }

  public void eleve(ETUDIANT etudiant){

    JTabbedPane onglet;
        //Création de plusieurs Panneau
    Panneau tPan = new Panneau(etudiant);
    Recapitulatif recap = new Recapitulatif();
      
    //Création de notre conteneur d'onglets
    onglet = new JTabbedPane();

    //Méthode d'ajout d'onglet
     onglet.add("Emploi du temps", tPan.getPan());
     onglet.add("Récapitulatif de cours", recap);
      
    //On passe ensuite les onglets au content pane
    this.getContentPane().add(onglet);
    System.out.println("test :");
    etudiant.afficherETUDIANT();
    }
   
  public static void main(String[] args){
    Fenetre fen = new Fenetre();
  }   
}