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

import Model.ETUDIANT;
import Model.SEANCE;
import java.awt.BorderLayout;

import java.awt.GridBagConstraints;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class Panneau extends JFrame{
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
  private ETUDIANT etudiant;
  private EtudiantEDT studentEDT = new EtudiantEDT();
  private Set<SEANCE> listSEANCE =new HashSet<SEANCE>();
  private JTable tableau;
   
  public Panneau(ETUDIANT recupEtudiant){
      etudiant = recupEtudiant;
      System.out.print("L'etudiant 3 dans panneau est :");
    System.out.print(recupEtudiant.getID());
    System.out.print(recupEtudiant.getDROIT());
    System.out.println(recupEtudiant.getNOM());
    
    principal.setLayout(new BorderLayout());
    intermediaire.setLayout(new BorderLayout());
    intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
    intermediaire.add(edt(),BorderLayout.CENTER);
    principal.add(intermediaire, BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
    etudiant = recupEtudiant;
    System.out.print("L'etudiant 4 dans panneau est :");
    System.out.print(etudiant.getID());
    System.out.print(etudiant.getDROIT());
    System.out.println(etudiant.getNOM());
  //  principal.add(menu());


   
    etudiant.afficherETUDIANT();
  }

  public JPanel menu(){
    //Pan1 correspond a la partie supérieur de la page ou se situe les boutons de choix grille et liste
    pan1.add(combo);
    
    //this.add(top, BorderLayout.NORTH);
    combo.addItem("En grille");
    combo.addItem("En liste");
  
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
    
    
    //this.color = color;
    return pan1;
}

public JPanel semaine(){

    //JPanel top = new JPanel();
    for(int i = 1; i <= 52; i++){
        JButton bouton = new JButton(""+i);
        bouton.setPreferredSize(new Dimension(48,20));
        pan2.add(bouton);
    }

    return pan2;
    
}

public JPanel edt(){
    int semaine=1;
    
    calendrier.setLayout(new BorderLayout()); 
    System.out.print("L'etudiant dans fetudiant est :");
    System.out.print(etudiant.getID());
    System.out.print(etudiant.getDROIT());
    System.out.print(etudiant.getNOM());
    //etudiant.afficherETUDIANT();
    //System.out.print(etudiant.getNOM());
    studentEDT.voirETUDIANT_SEANCE(etudiant.getNOM());
    listSEANCE = studentEDT.getlistSEANCE();
    /*
    //Les données du tableau
    //JPanel top = new JPanel(new BorderLayout());
    //Recuperation de la liste de cours de l'etudiant
    studentEDT.voirETUDIANT_SEANCE(etudiant.NUMERO());
    listSEANCE = studentEDT.getlistSEANCE();
    Set<SEANCE> listSEANCESEMAINE =new HashSet<SEANCE>();
    Set<SEANCE> listSEANCEDATE =new HashSet<SEANCE>();
    Set<SEANCE> listSEANCEHEURE =new HashSet<SEANCE>();
    
    pan3.setPreferredSize(new Dimension(3000, 510 ));
    pan3.setBackground(Color.ORANGE);
    
    //pan3.setLocation(2730, 20);
    //pan3.setMinimumSize(new Dimension(900, 400));
    //pan3.setMaximumSize(new Dimension(900, 400));
    */
    Object[][] data = {
      {"8h30 - 10h", "", "", "", "", ""},
      {"10h15 - 11h45", "", "", "", "", ""},
      {"12h - 13h30", "", "", "", "", ""},
      {"13h45 - 15h15", "", "", "", "", ""},
      {"15h30 - 17h", "", "", "", "", ""}
    };
    for(SEANCE i : listSEANCE)
    {
        System.out.println("l'eleve a 1 cours");
        if(i.getSEMAINE() == semaine)
        {
            System.out.println("Un cours dans la semaine :");
            int x = 0,y=0;
            switch(i.getDATE())
        {
            case ("LUNDI") :
            {
                y=1;
                break;
            }
            case ("MARDI") :
            {
                y=2;
                break;
            }
            case ("MERCREDI") :
            {
                y=3;
                break;
            }
            case ("JEUDI") :
            {
                y=4;
                break;
            }
            case ("VENDREDI") :
            {
                y=5;
                break;
            }
        }
        switch(i.getHEURE_DEBUT())
        {
            case ("8h30") :
            {
                x=0;
                break;
            }
            case ("10h15") :
            {
                x=1;
                break;
            }
            case ("12h") :
            {
                x=2;
                break;
            }
            case ("13h45") :
            {
                x=3;
                break;
            }
            case ("15h30") :
            {
                x=4;
                break;
            }
        }
        System.out.print("ici : ");
        System.out.println(i.getID());
        data[x][y]=i.getID();
        }
    }
    
    

    

    //Les titres des colonnes

    String  title[] = {"heure","Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    
    ZModel model = new ZModel(data, title);
    
    tableau = new JTable(model);
    tableau.setRowHeight(65);
    calendrier.add(new JScrollPane(tableau));
    
    //this.getContentPane().add(calendrier);
    

/*
 Object[][] data1 = {
      {""},
      {""}
    }; 

    //Les titres des colonnes
    String  title1[] = {"Lundi"};
    JTable tableau1 = new JTable(data1, title1);
    tableau1.setPreferredSize(new Dimension(pan3.getWidth(), pan3.getHeight()));

    //Nous ajoutons notre tableau à notre contentPane dans un scroll
    //Sinon les titres des colonnes ne s'afficheront pas !

    if(COUNT == 0){
        pan3.removeAll();  
        pan3.add(new JScrollPane(tableau));
    }
    else if(COUNT == 1){
        pan3.removeAll();  
        pan3.add(new JScrollPane(tableau1)); 
    }
*/
    return calendrier; 
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
        
        principal.add(edt());
      }
      
      else if(combo.getSelectedItem() == "En liste")
      {
        COUNT=1;
        
        principal.add(edt());
      }
    }               
  }

    public JPanel getPan(){
        return principal;
    }
    
}