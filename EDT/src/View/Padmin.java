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

public class Padmin extends JFrame{
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
  private List<SEANCE> listSEANCE =new ArrayList<SEANCE>();
  private List<SALLE> listSALLE =new ArrayList<SALLE>();
  private List<UTILISATEUR> listeENSEIGNANT = new ArrayList<UTILISATEUR>();
  private JTable tableau;
  private int semaine=1;
   
  public Padmin(ADMIN admin){
    //etudiant = recupEtudiant;    
    principal.setLayout(new BorderLayout());
    intermediaire.setLayout(new BorderLayout());
    intermediaire.add(new JScrollPane(semaine()),BorderLayout.NORTH);
    intermediaire.add(edt(),BorderLayout.CENTER);
    principal.add(intermediaire, BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
    //etudiant = recupEtudiant;
   // System.out.print("L'etudiant 4 dans panneau est :");
    //System.out.print(etudiant.getID());
    //System.out.print(etudiant.getDROIT());
    //System.out.println(etudiant.getNOM());
  //  principal.add(menu());
   
    //etudiant.afficherETUDIANT();
  }

  public JPanel menu(){
   //Pan1 correspond a la partie supérieur de la page ou se situe les boutons de choix grille et liste
    JLabel groupe = new JLabel("Groupe : ");
    pan1.add(groupe);

    JTextField groupefield = new JTextField();
    groupefield.setPreferredSize(new Dimension(100, 20));
    pan1.add(groupefield);

    JButton btngroupe = new JButton("Recherche groupe");
    pan1.add(btngroupe);

    btngroupe.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        //sgroupe = groupefield.getText();
        //System.out.print("La string sprof : " + sprof);
        //principal.add(edtgroupe(sgroupe), BorderLayout.CENTER);
        
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
        //ssalle = groupefield.getText();
        //System.out.print("La string sprof : " + sprof);
        //principal.add(edtsalle(ssalle), BorderLayout.CENTER);
        
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
        //sprof = groupefield.getText();
        //System.out.print("La string sprof : " + sprof);
        //principal.add(edtprof(sprof), BorderLayout.CENTER);
        
      }
    });

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
    int compteurSALLE=0;
    String infoSEANCE = "";
    calendrier.setLayout(new BorderLayout()); 
    
    /*
    studentEDT.voirETUDIANT_SEANCE(etudiant.getNOM());
    
    listSEANCE = studentEDT.getlistSEANCE();
    listSALLE = studentEDT.getListSALLE();
 
    listeENSEIGNANT = studentEDT.getlistENSEIGNANT();
    */
    

    //Données du tableau
    Object[][] data = {
      {"8h30", "", "", "", "", ""},
      {"10h", "", "", "", "", ""},
      {"10h15", "", "", "", "", ""},
      {"11h45", "", "", "", "", ""},
      {"12h", "", "", "", "", ""},
      {"13h30", "", "", "", "", ""},
      {"13h45", "", "", "", "", ""},
      {"15h15", "", "", "", "", ""},
      {"15h30", "", "", "", "", ""},
      {"17h", "", "", "", "", ""}
    };
/*
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
                y=2;
                break;
            }
            case ("12h") :
            {
                y=4;
                break;
            }
            case ("13h45") :
            {
                y=6;
                break;
            }
            case ("15h30") :
            {
                y=8;
                break;
            }
        }
        //On verifie que le cours n'est pas annulé
        if(i.getETAT()==1){
            infoSEANCE= "Le cours a lieu en salle " + listSALLE.get(compteurSALLE).getNOM()+" avec " + listeENSEIGNANT.get(compteurSALLE).getNOM();
            data[y][x] = infoSEANCE;
        }
        }
        compteurSALLE++;
    }*/
    
    

    

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