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
import java.awt.Font;
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
import java.awt.BorderLayout;


//classe de la fenêtre de connexion
public class Fconnexion extends JFrame {

  
   private int id;
    private int con = 0;
    ETUDIANT student = new ETUDIANT();
    private JPanel pr = new JPanel();

    public Fconnexion(){
    
    this.setLocationRelativeTo(null);
    this.setTitle("Connexion");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setDefaultLookAndFeelDecorated(true);
    this.setExtendedState(this.MAXIMIZED_BOTH);
    
    //private ETUDIANT etudiant;
    //private ETUDIANT etudiant;
    //private ETUDIANT etudiant;
    pr.setPreferredSize(new Dimension(1350, 510));
    pr.setBackground(Color.ORANGE); 
    pr.setLayout(new BorderLayout());   
  
       JPanel log = new JPanel();
       JPanel south = new JPanel();
       JPanel north = new JPanel();
       
       log.setLayout(new BorderLayout());
       log.setPreferredSize(new Dimension(1350, 50));
       south.setPreferredSize(new Dimension(1350, 50));
       north.setPreferredSize(new Dimension(1350, 250));

       JLabel titre = new JLabel("Hyperplaning");
       Font font = new Font("Arial",Font.BOLD,72);
        titre.setFont(font);
        north.add(titre);
        
       JPanel use = new JPanel();
       JPanel pw = new JPanel();
       JPanel btnlog = new JPanel();
       
        JLabel labuser = new JLabel("Username");
        use.add(labuser);

        JLabel labpassword = new JLabel("Password");
        pw.add(labpassword);

        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(110, 20));
        use.add(username);
         
        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(110, 20));
        pw.add(password);

        JButton login = new JButton("Login");
        btnlog.add(login); 

        log.add(use, BorderLayout.NORTH);
        log.add(pw, BorderLayout.CENTER);
        log.add(btnlog, BorderLayout.SOUTH);

        pr.add(log, BorderLayout.CENTER);  
        pr.add(south, BorderLayout.SOUTH); 
        pr.add(north, BorderLayout.NORTH); 
        this.setContentPane(pr);

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
            //System.out.println("test 3:");
            ETUDIANT etudiant = new ETUDIANT();
            etudiant=connect.getEtudiant();
            //etudiant.afficherETUDIANT(); 
            //con = 1;

            System.out.print("L'etudiant 1 dans fetudiant est :");
            System.out.print(etudiant.getID());
            System.out.print(etudiant.getDROIT());
            System.out.print(etudiant.getNOM());
            
            Fetudiant fetudiant = new Fetudiant(etudiant);
       
        }
        else if (connect.getDroit()==1)
        {
            ADMIN admin = new ADMIN();
            admin=connect.getAdmin();
            //admin.afficherADMIN();
            Fadmin fadmin = new Fadmin(admin);
        }
        
        else if (connect.getDroit()==2)
        {
            /*REFERENT referent = new REFERENT();
            referent=connect.getReferent();
            referent.afficherREFERENT();*/
            Freferent fref = new Freferent();
            
        }
        else if (connect.getDroit()==3)
        {
            UTILISATEUR utilisateur =new UTILISATEUR();
            utilisateur = connect.getUtilisateur();
            utilisateur.afficherUTILISATEUR();
            Fprof fprof = new Fprof(utilisateur);
        }
        
        }
      }
    });
       //this.setContentPane(pr);
       this.setVisible(true);
  }

}



