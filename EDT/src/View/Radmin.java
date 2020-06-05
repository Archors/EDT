/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Radmin extends JPanel{
  private Color color = Color.white;
  private static int COUNT = 0;
  private String message = "";
  private JPanel principal = new JPanel();
  private JPanel calendrier = new JPanel();
  private JTable tableau;
  private String sprof = "";
  private String ssalle = "";
  private String sgroupe = "";
  

  public Radmin(){
    principal.setLayout(new BorderLayout());
    //principal.add(edt(), BorderLayout.CENTER);
    principal.add(menu(), BorderLayout.NORTH);
 
  }

  public JPanel menu(){
    JPanel menu = new JPanel();
    
    //Pan1 correspond a la partie supérieur de la page ou se situe les boutons de choix grille et liste
    JLabel groupe = new JLabel("Groupe : ");
    menu.add(groupe);

    JTextField groupefield = new JTextField();
    groupefield.setPreferredSize(new Dimension(100, 20));
    menu.add(groupefield);

    JButton btngroupe = new JButton("Recherche groupe");
    menu.add(btngroupe);

    btngroupe.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        sgroupe = groupefield.getText();
        //System.out.print("La string sprof : " + sprof);
        principal.add(edtgroupe(sgroupe), BorderLayout.CENTER);
        
      }
    });
    
    //Liste salle
    JLabel salle = new JLabel("Salle : ");
    menu.add(salle);

    JTextField sallefield = new JTextField();
    sallefield.setPreferredSize(new Dimension(100, 20));
    menu.add(sallefield);

    JButton btnsalle = new JButton("Recherche salle");
    menu.add(btnsalle);

    btnsalle.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        ssalle = groupefield.getText();
        //System.out.print("La string sprof : " + sprof);
        principal.add(edtsalle(ssalle), BorderLayout.CENTER);
        
      }
    });

    //Liste prof
    JLabel prof = new JLabel("Professeur : ");
    menu.add(prof);

    JTextField proffield = new JTextField();
    proffield.setPreferredSize(new Dimension(100, 20));
    menu.add(proffield);

    JButton btnprof = new JButton("Recherche professeur");
    menu.add(btnprof);

    btnprof.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        sprof = groupefield.getText();
        //System.out.print("La string sprof : " + sprof);
        principal.add(edtprof(sprof), BorderLayout.CENTER);
        
      }
    });

    return menu;
}

public JPanel edtgroupe(String groupe){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle
    calendrier.setLayout(new BorderLayout()); 

    String tes = "test";

    

    if(groupe.equals("minot")){
        tes = "minot";
    }


    Object[][] data = {
      {tes, "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""}
    };

    //Les titres des colonnes

    String  title[] = {"Matières", "Première séance", "Dernière séance", "Durée", "Nb"};
    
    ZModel model = new ZModel(data, title);
    
    tableau = new JTable(model);
    tableau.setRowHeight(65);
    calendrier.add(new JScrollPane(tableau));
    
    //this.getContentPane().add(calendrier);

    return calendrier; 

}

public JPanel edtsalle(String salle){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle
    calendrier.setLayout(new BorderLayout()); 

    String tes = "test";

    

    if(salle.equals("minot")){
        tes = "minot";
    }


    Object[][] data = {
      {tes, "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""}
    };

    //Les titres des colonnes

    String  title[] = {"Matières", "Première séance", "Dernière séance", "Durée", "Nb"};
    
    ZModel model = new ZModel(data, title);
    
    tableau = new JTable(model);
    tableau.setRowHeight(65);
    calendrier.add(new JScrollPane(tableau));
    
    //this.getContentPane().add(calendrier);

    return calendrier; 

}

public JPanel edtprof(String prof){
    //Permet de compter le nombre de seance afin de lier la seance avec le bon prof et la bonne salle
    calendrier.setLayout(new BorderLayout()); 

    String tes = "test";

    

    if(prof.equals("minot")){
        tes = "minot";
    }


    Object[][] data = {
      {tes, "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""},
      {"", "", "", "", "", ""}
    };

    //Les titres des colonnes

    String  title[] = {"Matières", "Première séance", "Dernière séance", "Durée", "Nb"};
    
    ZModel model = new ZModel(data, title);
    
    tableau = new JTable(model);
    tableau.setRowHeight(65);
    calendrier.add(new JScrollPane(tableau));
    
    //this.getContentPane().add(calendrier);

    return calendrier; 

}


 public JPanel getPan(){
        return principal;
    }

  public void paintComponent(Graphics g){
    
    g.setColor(this.color);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.setColor(Color.white);
    g.setFont(new Font("Arial", Font.BOLD, 15));
    g.drawString(this.message, 10, 20);
  }
}
