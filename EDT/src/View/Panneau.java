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
import Controller.AffecterEnseignant;
import Controller.ENSEIGNANT_EDT;
import Controller.EtudiantEDT;
import Controller.GROUPE_EDT;
import Controller.SALLE_EDT;
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

import Model.ETUDIANT;
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

public class Panneau extends JFrame{
  private Color color = Color.white;
  private String message = "";
 // private GridBagConstraints gbc = new GridBagConstraints();
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
   
  public Panneau(ETUDIANT recupEtudiant){
    etudiant = recupEtudiant;    
    principal.setLayout(new BorderLayout());
    intermediaire.setLayout(new BorderLayout());
    intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
    intermediaire.add(edt(),BorderLayout.CENTER);
    principal.add(intermediaire, BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
  }

  public JPanel menu(){
    //Pan1 correspond a la partie supérieur de la page ou se situe les boutons de choix grille et liste
    pan1.add(combo);    
    //this.add(top, BorderLayout.NORTH);
    combo.addItem("En grille");
    combo.addItem("En liste");
  /*
    //combo.addItemListener(new ItemState());
     combo.addActionListener(new ItemAction());

  JComboBox combo2 = new JComboBox();
  
    pan1.add(combo2);
    //this.add(top, BorderLayout.NORTH);
    
    combo2.setPreferredSize(new Dimension(100, 20));
    combo2.addItem("Saisie du nom");
    combo2.addItem("Option 2");

    JTextField textfield = new JTextField(" Edit me !!! ");
    pan1.add(textfield);
    //this.add(new JTextField());
    */
    
    //this.color = color;
    return pan1;
}

public JPanel semaine(){

    //JPanel top = new JPanel();
    for(int i = 1; i <= 52; i++){
        int numerobtn = i;
        JButton bouton = new JButton(""+i);
        bouton.setPreferredSize(new Dimension(48,20));
        pan2.add(bouton);
        bouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){       
        
        //sgroupe = groupefield.getText();
        System.out.print("Le bouton est : " + numerobtn);
        //principal.add(edtgroupe(sgroupe), BorderLayout.CENTER);
           }
        });
    }
    return pan2;
    
}

public JPanel edt(){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle

    int ID=2;
    AffecterEnseignant affecter = new AffecterEnseignant(ID);
  //  ADD_SEANCE add = new ADD_SEANCE();
  //  add.AJOUTER_SEANCE(1, "MARDI", "10h15", "11h45", 1, "Web", "CI", "Hina", "TD01","104");
    
    String infoSEANCE = "";

    calendrier.setLayout(new BorderLayout()); 
    
    
    //Creation de la classe pour mettre les donnees en tableau
    EmploiDuTemps edtutilisateur = new EmploiDuTemps();
    ZModel model = new ZModel(edtutilisateur.emploidutempsetudiant(etudiant,semaine), edtutilisateur.setTitle());
    
    tableau = new JTable(model);
    //Definition de la taille des lignes
    tableau.setRowHeight(125);
    //Changement de la taille des colonnes
     setWidthAsPercentages(tableau, 0.04, 0.196, 0.196,0.196,0.196,0.196);
        
    calendrier.add(new JScrollPane(tableau));
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



class ItemAction implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      
      if(combo.getSelectedItem() == "En grille")
      {
        COUNT=0;
        intermediaire.add(edt(),BorderLayout.CENTER);
        principal.add(intermediaire, BorderLayout.CENTER);
      }
      
      else if(combo.getSelectedItem() == "En liste")
      {
        COUNT=1;
        intermediaire.add(edt(),BorderLayout.CENTER);
        principal.add(intermediaire, BorderLayout.CENTER);
      }
    }               
  }

    public JPanel getPan(){
        return principal;
    }
    
}