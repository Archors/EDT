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

public class Retudiant extends JPanel{
  private Color color = Color.white;
  private static int COUNT = 0;
  private String message = "";
  private JPanel principal = new JPanel();
  private JPanel calendrier = new JPanel();
  private JTable tableau;

  public Retudiant(){
    principal.setLayout(new BorderLayout());
    principal.add(edt(), BorderLayout.CENTER);
    //principal.add(menu(), BorderLayout.NORTH);
 
  }

  public JPanel menu(){
    JPanel menu = new JPanel();

  JComboBox combo2 = new JComboBox();
  
    menu.add(combo2);
    //this.add(top, BorderLayout.NORTH);
    
    
    combo2.setPreferredSize(new Dimension(100, 20));
    combo2.addItem("Saisie du nom");
    combo2.addItem("Option 2");

    return menu;
}

public JPanel edt(){
    
    calendrier.setLayout(new BorderLayout()); 
    Object[][] data = {
      {"", "", "", "", "", ""},
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
