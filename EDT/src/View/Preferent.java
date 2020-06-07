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
import Controller.ADD_SEANCE;
import Controller.AJOUTER_GROUPE;
import Controller.AffecterEnseignant;
import Controller.ENSEIGNANT_EDT;
import Controller.EtudiantEDT;
import Controller.GROUPE_EDT;
import Controller.SALLE_EDT;
import Controller.SEANCE_GROUPE;
import Controller.SUPPRIMER_SEANCE;
import Model.COURS;
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
import javax.swing.JLabel;

import Model.ETUDIANT;
import Model.ADMIN;
import Model.GROUPE;
import Model.SALLE;
import Model.SEANCE;
import Model.TYPE_COURS;
import Model.UTILISATEUR;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

//classe affichant le choix d'edt pour un référent
public class Preferent extends JFrame{
  private Color color = Color.white;
  private String message = "";
  private JPanel principal = new JPanel();
  private JPanel intermediaire = new JPanel();
  private JPanel pan1 = new JPanel();
  private JPanel pan2 = new JPanel();
  private JPanel calendrier = new JPanel();
  private JComboBox combo = new JComboBox();
  private ETUDIANT etudiant;
  private JTable tableau;
  private int semaine=1;
  private int COUNT=0;
  private String nameteacher="";
  private String namestudent="";
  private String nameroom="";
  private int typesemaine; 

  public Preferent(){
    //etudiant = recupEtudiant;
    principal.setLayout(new BorderLayout());
    intermediaire.setLayout(new BorderLayout());
    //intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
    //intermediaire.add(edtprof(""),BorderLayout.CENTER);
    principal.add(intermediaire, BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
    //principalscroll.add(principal);
    
  }

 public JPanel menu(){
   //Pan1 correspond a la partie supérieur de la page ou se situe les boutons de choix grille et liste
    JLabel groupe = new JLabel("Etudiant : ");
    pan1.add(groupe);

    JTextField groupefield = new JTextField();
    groupefield.setPreferredSize(new Dimension(100, 20));
    pan1.add(groupefield);

    JButton btngroupe = new JButton("Recherche etudiant");
    pan1.add(btngroupe);

    btngroupe.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){   
        //System.out.println("bouton groupe");
        namestudent = groupefield.getText();
        //calendrier.removeAll();  
        intermediaire.removeAll();
        typesemaine=1;
        intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
        intermediaire.add(edteleve(namestudent),BorderLayout.CENTER);
        principal.add(intermediaire, BorderLayout.CENTER);
        //System.out.println("bouton el");
        //System.out.println(namestudent);
      }
    });
    
    //Liste salle
    JLabel salle = new JLabel("Salle : ");
    pan1.add(salle);

    JTextField sallefield = new JTextField();
    sallefield.setPreferredSize(new Dimension(100, 20));
    pan1.add(sallefield);

    JButton btnsalle = new JButton("Recherche salle");
    pan1.add(btnsalle);

    btnsalle.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        //System.out.println("bouton groupe");
        nameroom = sallefield.getText();
        //calendrier.removeAll();
        typesemaine = 2;
        intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
        intermediaire.add(edtsalle(nameroom),BorderLayout.CENTER);
        principal.add(intermediaire, BorderLayout.CENTER);
        //System.out.println("bouton el");
        //System.out.println(nameroom);
      }
    });

    //Liste prof
    JLabel prof = new JLabel("Professeur : ");
    pan1.add(prof);

    JTextField proffield = new JTextField();
    proffield.setPreferredSize(new Dimension(100, 20));
    pan1.add(proffield);

    JButton btnprof = new JButton("Recherche professeur");
    pan1.add(btnprof);

    btnprof.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){  
        nameteacher = proffield.getText();
        //calendrier.removeAll();
        intermediaire.removeAll();
        typesemaine = 3;
        intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
        intermediaire.add(edtprof(nameteacher),BorderLayout.CENTER);
        principal.add(intermediaire, BorderLayout.CENTER);
        //System.out.println("bouton prof");
        //System.out.println(nameteacher);
      }
    });

    return pan1;
}

public JPanel semaine(){
    //JPanel top = new JPanel();
    for(int i = 1; i <= 52; i++){
        int btnsemaine = i;
        JButton bouton = new JButton(""+i);
        bouton.setPreferredSize(new Dimension(48,20));
        pan2.add(bouton);
        bouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            semaine = btnsemaine;
            calendrier.removeAll();
            if(typesemaine == 1){
                intermediaire.add(edteleve(namestudent),BorderLayout.CENTER);
            }
            else if(typesemaine == 2){
                intermediaire.add(edtsalle(nameroom),BorderLayout.CENTER);
            }
            else if(typesemaine == 3){
                intermediaire.add(edtprof(nameteacher),BorderLayout.CENTER);
            }
            //intermediaire.add(edtprof(nameteacher),BorderLayout.CENTER);
            //System.out.println("je suis sur la semaine prof");
            principal.add(intermediaire, BorderLayout.CENTER);
           }
        });
    }
    return pan2;
  }

public JPanel semaineetudiant(){
    //JPanel top = new JPanel();
    for(int i = 1; i <= 52; i++){
        int btnsemaine = i;
        JButton bouton = new JButton(""+i);
        bouton.setPreferredSize(new Dimension(48,20));
        pan2.add(bouton);
        bouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            semaine = btnsemaine;
            calendrier.removeAll();
            
             intermediaire.add(edteleve(namestudent),BorderLayout.CENTER);
            principal.add(intermediaire, BorderLayout.CENTER);
           }
        });
    }
    return pan2;
  }

public JPanel semainesalle(){
    //JPanel top = new JPanel();
    for(int i = 1; i <= 52; i++){
        int btnsemaine = i;
        JButton bouton = new JButton(""+i);
        bouton.setPreferredSize(new Dimension(48,20));
        pan2.add(bouton);
        bouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            semaine = btnsemaine;
            calendrier.removeAll();
            
             intermediaire.add(edtsalle(nameroom),BorderLayout.CENTER);
            principal.add(intermediaire, BorderLayout.CENTER);
           }
        });
    }
    return pan2;
  }

public JPanel edtprof(String nomprof){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle

    //calendrier.removeAll();
    int ID=2;

    int compteurSALLE=0;

    String infoSEANCE = "";

    EmploiTemps edtprof = new EmploiTemps();
    
    AffecterEnseignant affecter = new AffecterEnseignant(ID);

    calendrier.setLayout(new BorderLayout()); 

    //Creation de la classe pour mettre les donne
    ZModel model = new ZModel(edtprof.voiremploidutempsenseignant(nomprof,semaine), edtprof.setTitle());
    
        tableau = new JTable(model);
        //Definition de la taille des lignes
        tableau.setRowHeight(125);
        //Changement de la taille des colonnes
        setWidthAsPercentages(tableau, 0.04, 0.196, 0.196,0.196,0.196,0.196);
        //calendrier.removeAll();
        calendrier.add(new JScrollPane(tableau));
   
   // edt().removeAll();
    return calendrier; 
}

public JPanel edteleve(String nomeleve){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle

    //calendrier.removeAll();
    int ID=2;

    int compteurSALLE=0;

    String infoSEANCE = "";

    EmploiTemps edtet = new EmploiTemps();
    
    AffecterEnseignant affecter = new AffecterEnseignant(ID);

    calendrier.setLayout(new BorderLayout()); 


    //Creation de la classe pour mettre les donne
    ZModel model = new ZModel(edtet.voiremploidutempsetudiant(nomeleve,semaine), edtet.setTitle());
    
        tableau = new JTable(model);
        //Definition de la taille des lignes
        tableau.setRowHeight(125);
        //Changement de la taille des colonnes
        setWidthAsPercentages(tableau, 0.04, 0.196, 0.196,0.196,0.196,0.196);
        //calendrier.removeAll();
        calendrier.add(new JScrollPane(tableau));
   
   // edt().removeAll();
    return calendrier; 
}

public JPanel edtsalle(String nomsalle){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle

    //calendrier.removeAll();
    int ID=2;

    int compteurSALLE=0;

    String infoSEANCE = "";

    EmploiTemps edtet = new EmploiTemps();
    
    AffecterEnseignant affecter = new AffecterEnseignant(ID);

    calendrier.setLayout(new BorderLayout()); 


    //Creation de la classe pour mettre les donne
    ZModel model = new ZModel(edtet.voiremploidutempssalle(nomsalle,semaine), edtet.setTitle());
    
        tableau = new JTable(model);
        //Definition de la taille des lignes
        tableau.setRowHeight(125);
        //Changement de la taille des colonnes
        setWidthAsPercentages(tableau, 0.04, 0.196, 0.196,0.196,0.196,0.196);
        //calendrier.removeAll();
        calendrier.add(new JScrollPane(tableau));
   
   // edt().removeAll();
    return calendrier; 
}

//Fonction pour choisir la taille des colonnes du tableau avec des pourcentages
//Source : https://kahdev.wordpress.com/2011/10/30/java-specifying-the-column-widths-of-a-jtable-as-percentages/
private static void setWidthAsPercentages(JTable table,
        double... percentages) {
    final double factor = 10000;
 
    TableColumnModel model = table.getColumnModel();
    for (int columnIndex = 0; columnIndex < percentages.length; columnIndex++) {
        TableColumn column = model.getColumn(columnIndex);
        column.setPreferredWidth((int) (percentages[columnIndex] * factor));
    }
}

    public JPanel getPan(){
        return principal;
    }
    
}