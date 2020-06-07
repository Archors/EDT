/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import Controller.REPORTING_DONNEE;
import Model.UTILISATEUR;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/** Classe qui affiche le reporting*/
public class Reporting extends JPanel{
  private Color color = Color.white;
  private static int COUNT = 0;
  private String message = "";
  private JPanel principal = new JPanel();
  private JPanel pan1 = new JPanel();
  private JPanel graph = new JPanel();
  private JComboBox combo = new JComboBox();

  public Reporting(){
    //principal.add(menu());
    principal.setLayout(new BorderLayout());
    //principal.add(menu(),BorderLayout.NORTH);
    principal.add(graphgroupe(),BorderLayout.CENTER);
 
  }


public JPanel graphgroupe(){
     graph = new JPanel(new BorderLayout());
     List <Integer> nbSeance =new ArrayList<Integer>();
     List<UTILISATEUR> listENSEIGNANT =new ArrayList<UTILISATEUR>();


    //setContentPane(graph); 
    setSize(400, 250); 
    
     DefaultPieDataset pieDataset = new DefaultPieDataset();
     
    REPORTING_DONNEE rep = new REPORTING_DONNEE();
    rep.REPORTING_DONNEE();
    nbSeance = rep.getnbSeance();
    listENSEIGNANT = rep.getlistENSEIGNANT();
    int i=0;
    
    for(UTILISATEUR enseignant : listENSEIGNANT)
    {
        

        pieDataset.setValue(enseignant.getNOM(), new Integer(nbSeance.get(i)));

        
        
        i++;
        
    }
    

    JFreeChart pieChart = ChartFactory.createPieChart("Nombre de séances par professeur", 
     pieDataset, true, true, true); 
    
    ChartPanel cPanel = new ChartPanel(pieChart); 
    
    graph.add(cPanel);
    
    
    return graph;
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


