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
import Controller.DEPLACER_SEANCE;
import Controller.ENSEIGNANT_EDT;
import Controller.EtudiantEDT;
import Controller.GROUPE_EDT;
import Controller.MODIFIER_ETAT_SEANCE;
import Controller.REPORTING_DONNEE;
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
import javax.swing.ScrollPaneLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/** Classe permettant l'affichage et la gestion de l'emploi du temps par un etudiant*/
public class Panneau extends JFrame{
  private Color color = Color.white;
  private String message = "";
  private JPanel principal = new JPanel();
  private JPanel intermediaire = new JPanel();
  private JPanel intermediairebis = new JPanel();
  private JPanel pan1 = new JPanel();
  private JPanel pan2 = new JPanel();
  private JPanel calendrier = new JPanel();
  private JPanel calendrierscroll = new JPanel();
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
  JScrollPane testscroll = new JScrollPane(); 
  //private 
   
  /** Intialise les valeurs des données d'un etudiant*/
  public Panneau(ETUDIANT recupEtudiant){
    etudiant = recupEtudiant;
    principal.setLayout(new BorderLayout());
    intermediaire.setLayout(new BorderLayout());
    intermediairebis.setLayout(new BorderLayout());
    intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
    //intermediaire.add(edt(),BorderLayout.CENTER);
    principal.add(intermediaire, BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
  }

  /** Affiche le menu d'un etudiant*/
  public JPanel menu(){
    //Pan1 correspond a la partie supérieur de la page ou se situe les boutons de choix grille et liste
    pan1.add(combo);    
    combo.addItem("En grille");
    combo.addItem("En liste");
    combo.addActionListener(new ItemAction());


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
            //testscroll.removeAll()
            edt().removeAll();
            intermediairebis.removeAll();
            //intermediaire.paint();
            intermediairebis.add(new JScrollPane(edt()),BorderLayout.CENTER);
            intermediaire.add(intermediairebis,BorderLayout.CENTER);
            
            principal.add(intermediaire, BorderLayout.CENTER);
            
           }
        });
    }
    return pan2;
  }

public JPanel edt(){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle

    //calendrier.removeAll();
    int ID=2;


    int compteurSALLE=0;

    String infoSEANCE = "";

    EmploiTemps edtutilisateur = new EmploiTemps();

    
  //  DEPLACER_SEANCE dep =new DEPLACER_SEANCE();
 //   dep.DEPLACER_SEANCE_INSTANCE(1, "LUNDI", "10h15", "104", 1, "MERCREDI", "10h15", "11h30");
    
    //int compteurSALLE=0;
    List <GROUPE> listGROUPE = new ArrayList<>();


 //   AffecterEnseignant affecter = new AffecterEnseignant(ID);

 SEANCE_GROUPE seancegroupe =new SEANCE_GROUPE(1);
 listGROUPE =  seancegroupe.getlistGROUPE();

 
//AJOUTER_GROUPE ajout = new AJOUTER_GROUPE();
//System.out.println(ajout.AJOUTER_GROUPE_INSTANCE (1, "Jeudi", "15h30", "105", "TD02", "2022"));

    //String infoSEANCE = "";

    calendrier.setLayout(new BorderLayout()); 
    calendrierscroll.setLayout(new BorderLayout()); 
    

    if(COUNT == 0){
    //Creation de la classe pour mettre les donne
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
    testscroll.setLayout(new ScrollPaneLayout());
    ListeEDT edtenListe = new ListeEDT();
    edtenListe.ListeEtudiant(etudiant,semaine);
    
      Object[][] dataL={
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"","", "", "", "", ""}
    };
      dataL[0]= edtenListe.getL();
      int compteur = 0;
      for(Object i : edtenListe.getL())
        {
            dataL[compteur][0] = i;
            compteur++;
            
        }

    //Les titres des colonnes
    if(dataL[0][0] !=""){
    String  titleL[] = {"Lundi"};
    ZModel modelL = new ZModel(dataL, titleL);
    
    tableauL = new JTable(modelL);
    //Definition de la taille des lignes
    tableauL.setRowHeight(25);
    //tableauL.setPreferredSize(new Dimension(1350, 200));
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    //calendrier.removeAll();
    calendrier1.add(new JScrollPane(tableauL),BorderLayout.NORTH);
    }
    
    /////////////////Mardi//////////////

    Object[][] dataM = {
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"","", "", "", "", ""}
    };
    dataM[0] = edtenListe.getM();
    compteur = 0;
      for(Object i : edtenListe.getM())
        {
            dataM[compteur][0] = i;
            compteur++;
            
        }
    //Les titres des colonnes
    if(dataM[0][0] !=""){
    String  titleM[] = {"Mardi"};

    ZModel modelM = new ZModel(dataM, titleM);
    
    tableauM = new JTable(modelM);
    //Definition de la taille des lignes
    tableauM.setRowHeight(25);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    //calendrier.removeAll();
    calendrier1.add(new JScrollPane(tableauM),BorderLayout.CENTER);
}
    

    /////////////////Mercredi//////////////

    Object[][] dataMe = {
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"","", "", "", "", ""}
    };
    dataMe[0]= edtenListe.getMe();
    compteur = 0;
      for(Object i : edtenListe.getMe())
        {
            dataMe[compteur][0] = i;
            compteur++;
            
        }
    //Les titres des colonnes
    if(dataMe[0][0] !=""){
    String  titleMe[] = {"Mercredi"};
    
    ZModel modelMe = new ZModel(dataMe, titleMe);
    
    tableauMe = new JTable(modelMe);
    //Definition de la taille des lignes
    tableauMe.setRowHeight(25);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    //calendrier.removeAll();
    calendrier1.add(new JScrollPane(tableauMe),BorderLayout.SOUTH);
    }
    //calendrier1.setPreferredSize(new Dimension(800, 1100));
    
    calendrier.add(calendrier1, BorderLayout.NORTH);

    //////////Jeudi////////////

    Object[][] dataJ = {
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"","", "", "", "", ""}
    };
    dataJ[0]= edtenListe.getJ();
    compteur = 0;
      for(Object i : edtenListe.getJ())
        {
            dataJ[compteur][0] = i;
            compteur++;
            
        }
    //Les titres des colonnes
    if(dataJ[0][0] !=""){
    String  titleJ[] = {"Jeudi"};
    
    ZModel modelJ = new ZModel(dataJ, titleJ);
    
    tableauJ = new JTable(modelJ);
    //Definition de la taille des lignes
    tableauJ.setRowHeight(25);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    
    calendrier2.add(new JScrollPane(tableauJ),BorderLayout.NORTH);
    }    

    /////////////////Vendredi/////////////////

    Object[][] dataV = {
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"","", "", "", "", ""}
    };
    dataV[0]= edtenListe.getV();
    compteur = 0;
      for(Object i : edtenListe.getV())
        {
            dataV[compteur][0] = i;
            compteur++;
            
        }
    //Les titres des colonnes
    if(dataV[0][0] !=""){
    String  titleV[] = {"Vendredi"};
    
    ZModel modelV = new ZModel(dataV, titleV);
    
    tableauV = new JTable(modelV);
    //Definition de la taille des lignes
    tableauV.setRowHeight(25);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    //calendrier.removeAll();
    calendrier2.add(new JScrollPane(tableauV),BorderLayout.CENTER);
      }
    calendrier.add(calendrier2,BorderLayout.CENTER);
    //calendrier.add(testscroll,BorderLayout.CENTER);
    }
   // edt().removeAll();
    //calendrierscroll.add(new JScrollPane(calendrier));
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
      edt().removeAll();
        COUNT=0;
        //intermediaire.add(new JScrollPane(edt()),BorderLayout.CENTER);
      //principal.add(intermediaire, BorderLayout.CENTER);
      }

      else if(combo.getSelectedItem() == "En liste")
      {
      edt().removeAll();
        COUNT=1;
        //intermediaire.add(new JScrollPane(edt()),BorderLayout.CENTER);
        //principal.add(intermediaire, BorderLayout.CENTER);
      }
       //calendrier.removeAll();
      
      
    }
  }

    public JPanel getPan(){
        return principal;
    }
    
}