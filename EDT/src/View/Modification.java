/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


/**
 *
 * @author Aurélien
 */
import Controller.EtudiantEDT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;

import Model.ETUDIANT;
import Model.SEANCE;

import Controller.ADD_SEANCE;

import java.awt.GridBagConstraints;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.TableColumn;

public class Modification extends JPanel{
  private Color color = Color.white;
  
  private JPanel principal = new JPanel();
  private JPanel modification = new JPanel(); 
  private JPanel pan1 = new JPanel(); 
  private int compt=1;
  CardLayout cl = new CardLayout();
  JPanel content = new JPanel();
  //Liste des noms de nos conteneurs pour la pile de cartes
  String[] listContent = {"CARD_1", "CARD_2", "CARD_3", "CARD_4", "CARD_5", "CARD_6"};
  //int indice = 0;

   
  public Modification(){
    
    principal.setLayout(new BorderLayout());
    //principal.add(menu(), BorderLayout.NORTH);
    //principal.add(creer(), BorderLayout.SOUTH);
		
    //création des cartes pour chaque action
    JPanel card1 = new JPanel();
    //card1=creer();
    card1.setBackground(Color.yellow);
    JPanel card2 = new JPanel();
    //card1=annuler();
    card2.setBackground(Color.red);		
    JPanel card3 = new JPanel();
    card3=ajouter();
    //card3.setBackground(Color.green);
    JPanel card4 = new JPanel();
    //card1=retirer();
    card4.setBackground(Color.black);		
    JPanel card5 = new JPanel();
    //card1=deplacer();
    card5.setBackground(Color.white);		
    JPanel card6 = new JPanel();
    //card1=modifier();
    card6.setBackground(Color.orange);

    //panel bouton et création des boutons
    JPanel boutonPane = new JPanel();
    JButton creer = new JButton("Ajouter groupe");
    JButton annuler = new JButton("Annuler séance");
    JButton ajouter = new JButton("Ajouter séance");
    JButton retirer = new JButton("Retirer séance");
    JButton deplacer = new JButton("Déplacer séance");
    JButton modifier = new JButton("Modifier état séance");

    //action bouton creer
    creer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[0]);
      }
    });
	
    //action bouton annuler
    annuler.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[1]);
      }
    });

    //action bouton ajouter
    ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){      
        compt = 1;
        cl.show(content, listContent[2]);
      }
    });

    //action bouton retirer
    retirer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[3]);
      }
    });

    //action bouton deplacer
    deplacer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[4]);
      }
    });

    //action bouton modifier
    modifier.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[5]);
      }
    });
	
    //ajout des boutons
    boutonPane.add(creer);
    boutonPane.add(annuler);
    boutonPane.add(ajouter);
    boutonPane.add(retirer);
    boutonPane.add(deplacer);
    boutonPane.add(modifier);
    

    content.setLayout(cl);
    //Ajout des cartes
    content.add(card1, listContent[0]);
    content.add(card2, listContent[1]);
    content.add(card3, listContent[2]);
    content.add(card4, listContent[3]);
    content.add(card5, listContent[4]);
    content.add(card6, listContent[5]);

    principal.add(boutonPane, BorderLayout.NORTH);
    principal.add(content, BorderLayout.CENTER);
      	
  }




//public JPanel creer(){}

//public JPanel annuler(){}

public JPanel ajouter(){

        JPanel ajouter = new JPanel();

        JLabel semaine = new JLabel("Semaine : ");
        ajouter.add(semaine);

        JTextField textsemaine = new JTextField();
        textsemaine.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textsemaine);

        JLabel date = new JLabel("Date : ");
        ajouter.add(date);
         
        JTextField textdate = new JTextField();
        textdate.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textdate);

        JLabel heuredeb = new JLabel("Heure de début : ");
        ajouter.add(heuredeb);
         
        JTextField textheuredeb = new JTextField();
        textheuredeb.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textheuredeb);

        JLabel heurefin = new JLabel("Heure de fin : ");
        ajouter.add(heurefin);

        JTextField textheurefin = new JTextField();
        textheurefin.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textheurefin);

        JLabel etat = new JLabel("Etat : ");
        ajouter.add(etat);

        JTextField textetat = new JTextField();
        textetat.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textetat);

        JLabel nom = new JLabel("Nom du cours : ");
        ajouter.add(nom);
         
        JTextField textnom = new JTextField();
        textnom.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textnom);

        JLabel type = new JLabel("Type du cours : ");
        ajouter.add(type);
         
        JTextField texttype = new JTextField();
        texttype.setPreferredSize(new Dimension(80, 20));
        ajouter.add(texttype);

        JLabel enseignant = new JLabel("Enseignant : ");
        ajouter.add(enseignant);
         
        JTextField textenseignant = new JTextField();
        textenseignant.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textenseignant);

        JLabel groupe = new JLabel("Goupe : ");
        ajouter.add(groupe);
         
        JTextField textegroupe = new JTextField();
        textegroupe.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textegroupe);

        JLabel salle = new JLabel("Salle : ");
        ajouter.add(salle);
         
        JTextField textesalle = new JTextField();
        textesalle.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textesalle);


        JButton ajou = new JButton("Ajouter");
        ajouter.add(ajou); 

       ajou.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            String testr = textsemaine.getText();
            int resultat = Integer.parseInt(testr);
            System.out.println("le résultat est : " + testr);
           }
        });

        return ajouter;
}

//public JPanel retirer(){}

//public JPanel deplacer(){}

//public JPanel modifier(){}

    public JPanel getPan(){
        return principal;
    }
    
}
