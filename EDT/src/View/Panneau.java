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
import Controller.EtudiantEDT;
import Controller.GROUPE_EDT;
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
  private EtudiantEDT studentEDT = new EtudiantEDT();
  private List<SEANCE> listSEANCE =new ArrayList<SEANCE>();
  private List<SALLE> listSALLE =new ArrayList<SALLE>();
  private List<UTILISATEUR> listeENSEIGNANT = new ArrayList<UTILISATEUR>();
  private List<TYPE_COURS> listeTYPE_COURS = new ArrayList<TYPE_COURS>();
  private List<COURS> listeCOURS = new ArrayList<COURS>();
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
<<<<<<< HEAD
    etudiant = recupEtudiant;
    System.out.print("L'etudiant 4 dans panneau est :");
    System.out.print(etudiant.getID());
    System.out.print(etudiant.getDROIT());
    System.out.println(etudiant.getNOM());
  //  principal.add(menu());
   
    etudiant.afficherETUDIANT();
=======
>>>>>>> 29ce808d5fe2dc1d60c55dc98657484fbe55cdf9
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

  //  int ID=2;
  //  AffecterEnseignant affecter = new AffecterEnseignant(ID);
  //  ADD_SEANCE add = new ADD_SEANCE();
  //  System.out.println(add.AJOUTER_SEANCE(1, "MARDI", "15h30", "17h", 1, "Web", "CI","Hina",1,"104"));
    
    String infoSEANCE = "";
    int compteur=0;

    calendrier.setLayout(new BorderLayout()); 
    
    //Creation de l'objet qui contient les données de l'etudiant
    studentEDT.voirETUDIANT_SEANCE(etudiant.getNOM());
    //Recuperation des données sur les cours de l'etudiant dans la classe
    listSEANCE = studentEDT.getlistSEANCE();
    listSALLE = studentEDT.getListSALLE();
    listeTYPE_COURS = studentEDT.getListTYPE_COURS();
    listeCOURS = studentEDT.getListCOURS();
    listeENSEIGNANT = studentEDT.getlistENSEIGNANT();

    //GROUPE_EDT grpedt = new GROUPE_EDT();
    //grpedt.voirGROUPE_SEANCE();
    //System.out.println("Affichage  ici !! :");
    //grpedt.afficherLISTESEANCE();
    //grpedt.afficherLISTESALLE();

    //Données du tableau
    Object[][] data = {
      {"8h30-10h", "", "", "", "", ""},
      {"10h15-11h45", "", "", "", "", ""},
      {"12h-13h30", "", "", "", "", ""},
      {"13h45-15h15", "", "", "", "", ""},
      {"15h30-17h", "", "", "", "", ""}
    };
    for(SEANCE i : listSEANCE)
    {
        if(i.getSEMAINE() == semaine)
        {
            int x = 0,y=0;
            switch(i.getDATE())
        {
            case ("LUNDI") :
            {
                x=1;
                break;
            }
            case ("MARDI") :
            {
                x=2;
                break;
            }
            case ("MERCREDI") :
            {
                x=3;
                break;
            }
            case ("JEUDI") :
            {
                x=4;
                break;
            }
            case ("VENDREDI") :
            {
                x=5;
                break;
            }
        }
        switch(i.getHEURE_DEBUT())
        {
            case ("8h30") :
            {
                y=0;
                break;
            }
            case ("10h15") :
            {
                y=1;
                break;
            }
            case ("12h") :
            {
                y=2;
                break;
            }
            case ("13h45") :
            {
                y=3;
                break;
            }
            case ("15h30") :
            {
                y=4;
                break;
            }
        }
        //On verifie que le cours n'est pas annulé
        if(i.getETAT()==1){
            infoSEANCE= "Le cours de " + listeCOURS.get(compteur).getNOM()+" en "+ listeTYPE_COURS.get(compteur).getNOM()+" a lieu en salle " + listSALLE.get(compteur).getNOM()+" avec " + listeENSEIGNANT.get(compteur).getNOM();
            data[y][x] = infoSEANCE;
        }
        }
        compteur++;
    }

    //Les titres des colonnes
    String  title[] = {"Heure","Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    
    ZModel model = new ZModel(data, title);
    
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

/*
  public void paintComponent(Graphics g){
    
    g.setColor(this.color);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.setColor(Color.white);
    g.setFont(new Font("Arial", Font.BOLD, 15));
    g.drawString(this.message, 10, 20);
  }*/
  

  /*class ItemState implements ItemListener{
    public void itemStateChanged(ItemEvent e) {
      
      
   
    }               
    }*/

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