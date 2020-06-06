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
import Controller.DEPLACER_SEANCE;
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

import Model.ETUDIANT;
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
  private JTable tableauL;
  private JTable tableauM;
  private JTable tableauMe;
  private JTable tableauJ;
  private JTable tableauV;
   
  public Panneau(ETUDIANT recupEtudiant){
    etudiant = recupEtudiant;
    principal.setLayout(new BorderLayout());
    intermediaire.setLayout(new BorderLayout());
    intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
    intermediaire.add(edt(),BorderLayout.CENTER);
    principal.add(intermediaire, BorderLayout.CENTER);
    //principal.add(edt(), BorderLayout.SOUTH);
    //principal.add(semaine(), BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
  }

  public JPanel menu(){
    //Pan1 correspond a la partie supérieur de la page ou se situe les boutons de choix grille et liste
    pan1.add(combo);    
    //this.add(top, BorderLayout.NORTH);
    combo.addItem("En grille");
    combo.addItem("En liste");
    combo.addActionListener(new ItemAction());
  /*
    //combo.addItemListener(new ItemState());
     

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
        int btnsemaine = i;
        JButton bouton = new JButton(""+i);
        bouton.setPreferredSize(new Dimension(48,20));
        pan2.add(bouton);
        bouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            semaine = btnsemaine;
            edt().removeAll();
            intermediaire.add(edt(),BorderLayout.CENTER);
            principal.add(intermediaire, BorderLayout.CENTER);
        //sgroupe = groupefield.getText();
            //System.out.print("Le bouton est : " + semaine);
        //principal.add(edtgroupe(sgroupe), BorderLayout.CENTER);
           }
        });
    }
    return pan2;
    
}

public JPanel edt(){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle

    int ID=2;
    
    DEPLACER_SEANCE dep =new DEPLACER_SEANCE();
    dep.DEPLACER_SEANCE_INSTANCE(2, "MARDI", "10h15", "104", 1, "LUNDI", "10h15", "11h30");
    
    
    int compteurSALLE=0;
    List <GROUPE> listGROUPE = new ArrayList<>();


 //   AffecterEnseignant affecter = new AffecterEnseignant(ID);

 SEANCE_GROUPE seancegroupe =new SEANCE_GROUPE(1);
 listGROUPE =  seancegroupe.getlistGROUPE();
 

 
 
 
 
//AJOUTER_GROUPE ajout = new AJOUTER_GROUPE();
//System.out.println(ajout.AJOUTER_GROUPE_INSTANCE (1, "Jeudi", "15h30", "105", "TD02", "2022"));

    String infoSEANCE = "";

    calendrier.setLayout(new BorderLayout()); 

    if(COUNT == 0){
    //Creation de la classe pour mettre les donne
    EmploiTemps edtutilisateur = new EmploiTemps();
    ZModel model = new ZModel(edtutilisateur.emploidutempsetudiant(etudiant,semaine), edtutilisateur.setTitle());
    
        tableau = new JTable(model);
        //Definition de la taille des lignes
        tableau.setRowHeight(125);
        //Changement de la taille des colonnes
        setWidthAsPercentages(tableau, 0.04, 0.196, 0.196,0.196,0.196,0.196);
        //calendrier.removeAll();
        calendrier.add(new JScrollPane(tableau));
    }
    else if(COUNT == 1){

    JPanel calendrier1 = new JPanel();
    JPanel calendrier2 = new JPanel();
    JPanel calendrier3 = new JPanel();
    calendrier.setLayout(new BorderLayout());
    calendrier1.setLayout(new BorderLayout());
    calendrier2.setLayout(new BorderLayout());
    calendrier3.setLayout(new BorderLayout());

      Object[][] dataL = {
      {""},
      {""}
      
    };

    //Les titres des colonnes
    String  titleL[] = {"Lundi"};
    
    ZModel modelL = new ZModel(dataL, titleL);
    
    tableauL = new JTable(modelL);
    //Definition de la taille des lignes
    tableauL.setRowHeight(125);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    //calendrier.removeAll();
    calendrier1.add(new JScrollPane(tableauL),BorderLayout.NORTH);

    /////////////////Mardi//////////////

    Object[][] dataM = {
      {""},
      {""}
     
    };

    //Les titres des colonnes
    String  titleM[] = {"Mardi"};
    
    ZModel modelM = new ZModel(dataM, titleM);
    
    tableauM = new JTable(modelM);
    //Definition de la taille des lignes
    tableauM.setRowHeight(125);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    //calendrier.removeAll();
    calendrier1.add(new JScrollPane(tableauM),BorderLayout.CENTER);

    /////////////////Mercredi//////////////

    Object[][] dataMe = {
      {""},
      {""}
     
    };

    //Les titres des colonnes
    String  titleMe[] = {"Mercredi"};
    
    ZModel modelMe = new ZModel(dataMe, titleMe);
    
    tableauMe = new JTable(modelMe);
    //Definition de la taille des lignes
    tableauMe.setRowHeight(125);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    
    calendrier1.add(new JScrollPane(tableauMe),BorderLayout.SOUTH);
    calendrier.add(calendrier1, BorderLayout.NORTH);

    //////////Jeudi////////////

    Object[][] dataJ = {
      {""},
      {""}
     
    };

    //Les titres des colonnes
    String  titleJ[] = {"Jeudi"};
    
    ZModel modelJ = new ZModel(dataJ, titleJ);
    
    tableauJ = new JTable(modelJ);
    //Definition de la taille des lignes
    tableauJ.setRowHeight(125);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    
    calendrier2.add(new JScrollPane(tableauJ),BorderLayout.NORTH);
    

    /////////////////Vendredi/////////////////

    Object[][] dataV = {
      {""},
      {""}
     
    };

    //Les titres des colonnes
    String  titleV[] = {"Vendredi"};
    
    ZModel modelV = new ZModel(dataV, titleV);
    
    tableauV = new JTable(modelMe);
    //Definition de la taille des lignes
    tableauV.setRowHeight(125);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    //calendrier.removeAll();
    calendrier2.add(new JScrollPane(tableauV),BorderLayout.CENTER);
    calendrier.add(calendrier2,BorderLayout.CENTER);
    }
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



class ItemAction implements ActionListener{
    public void actionPerformed(ActionEvent e) {

      if(combo.getSelectedItem() == "En grille")
      {
        COUNT=0;
      }

      else if(combo.getSelectedItem() == "En liste")
      {
        COUNT=1;
      }
      edt().removeAll();
      intermediaire.add(new JScrollPane(edt()),BorderLayout.CENTER);
      principal.add(intermediaire, BorderLayout.CENTER);
    }
  }

    public JPanel getPan(){
        return principal;
    }
    
}