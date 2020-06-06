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
import Controller.MODIFIER_ETAT_SEANCE;
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
import Model.SALLE;
import Model.SEANCE;
import Model.UTILISATEUR;
import java.awt.BorderLayout;
import java.util.ArrayList;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Pprof extends JFrame{
  private Color color = Color.white;
  private int COUNT = 0;
  private String message = "";
 // private GridBagConstraints gbc = new GridBagConstraints();
  private JPanel principal = new JPanel();
  private JPanel intermediaire = new JPanel();
  private JPanel pan1 = new JPanel();
  private JPanel pan2 = new JPanel();
  private JPanel calendrier = new JPanel();
  private JComboBox combo = new JComboBox();
  private UTILISATEUR prof;
  private EtudiantEDT studentEDT = new EtudiantEDT();
  private List<SEANCE> listSEANCE =new ArrayList<SEANCE>();
  private List<SALLE> listSALLE =new ArrayList<SALLE>();
  private List<UTILISATEUR> listeENSEIGNANT = new ArrayList<UTILISATEUR>();
  private JTable tableau;
  private int semaine=1;
  private JTable tableauL;
  private JTable tableauM;
  private JTable tableauMe;
  private JTable tableauJ;
  private JTable tableauV;
   
  public Pprof(UTILISATEUR utilisateur){
       prof = utilisateur;
    principal.setLayout(new BorderLayout());
    intermediaire.setLayout(new BorderLayout());
    intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
    intermediaire.add(edt(),BorderLayout.CENTER);
    principal.add(intermediaire, BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
  }

  public JPanel menu(){
    pan1.add(combo);    
    //this.add(top, BorderLayout.NORTH);
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
            edt().removeAll();
            intermediaire.add(edt(),BorderLayout.CENTER);
            principal.add(intermediaire, BorderLayout.CENTER);
           }
        });
    }
    return pan2;
  }

public JPanel edt(){
    EmploiTemps edtprof = new EmploiTemps();

    calendrier.setLayout(new BorderLayout()); 
    if(COUNT == 0){
    //Creation de la classe pour mettre les donne
    ZModel model = new ZModel(edtprof.emploidutempsenseignant(prof,semaine), edtprof.setTitle());
    
        tableau = new JTable(model);
        //Definition de la taille des lignes
        tableau.setRowHeight(125);
        //Changement de la taille des colonnes
        setWidthAsPercentages(tableau, 0.04, 0.196, 0.196,0.196,0.196,0.196);
        
        calendrier.add(new JScrollPane(tableau));
    }
    else if(COUNT == 1)
    {
        JPanel calendrier1 = new JPanel();
    JPanel calendrier2 = new JPanel();
    JPanel calendrier3 = new JPanel();
    calendrier.setLayout(new BorderLayout());
    calendrier1.setLayout(new BorderLayout());
    calendrier2.setLayout(new BorderLayout());
    calendrier3.setLayout(new BorderLayout());
    ListeEDT edtenListe = new ListeEDT();
    edtenListe.ListeProfesseur(prof,semaine);

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
    String  titleV[] = {"Vendredi"};
    
    ZModel modelV = new ZModel(dataV, titleV);
    
    tableauV = new JTable(modelV);
    //Definition de la taille des lignes
    tableauV.setRowHeight(125);
    //Changement de la taille des colonnes
     //setWidthAsPercentages(tableauL, 0.04, 0.196, 0.196,0.196,0.196,0.196);
    
    calendrier2.add(new JScrollPane(tableauV),BorderLayout.CENTER);
    calendrier.add(calendrier2,BorderLayout.CENTER);
    }
    return calendrier; 
}

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
