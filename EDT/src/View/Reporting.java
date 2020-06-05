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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
    principal.add(menu(),BorderLayout.NORTH);
    //principal.add(graph(),BorderLayout.CENTER);
 
  }

    public JPanel menu(){
    
    pan1.add(combo);    

    combo.addItem("groupe");
    combo.addItem("professeur");
    combo.addItem("salle");

    combo.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        if(combo.getSelectedItem() == "groupe")
        {
          principal.add(graphgroupe(), BorderLayout.CENTER);
        }

        else if(combo.getSelectedItem() == "professeur")
        {
          principal.add(graphprof(), BorderLayout.CENTER);
        }
        else if(combo.getSelectedItem() == "salle")
        {
          principal.add(graphsalle(), BorderLayout.CENTER);
        }
      }
    });

    return pan1;
}

public JPanel graphgroupe(){
     graph = new JPanel(new BorderLayout()); 
    //setContentPane(graph); 
    setSize(400, 250); 

    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    pieDataset.setValue("Valeur1", new Integer(27)); 
    pieDataset.setValue("Valeur2", new Integer(10)); 
    pieDataset.setValue("Valeur3", new Integer(50)); 
    pieDataset.setValue("Valeur4", new Integer(5)); 

    JFreeChart pieChart = ChartFactory.createPieChart("Groupes", 
     pieDataset, true, true, true); 
    ChartPanel cPanel = new ChartPanel(pieChart); 
    graph.add(cPanel); 
    return graph;
}

public JPanel graphprof(){
     graph = new JPanel(new BorderLayout()); 
    //setContentPane(graph); 
    setSize(400, 250); 

    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    pieDataset.setValue("Valeur1", new Integer(27)); 
    pieDataset.setValue("Valeur2", new Integer(10)); 
    pieDataset.setValue("Valeur3", new Integer(50)); 
    pieDataset.setValue("Valeur4", new Integer(5)); 

    JFreeChart pieChart = ChartFactory.createPieChart("Professeurs", 
     pieDataset, true, true, true); 
    ChartPanel cPanel = new ChartPanel(pieChart); 
    graph.add(cPanel); 
    return graph;
}

public JPanel graphsalle(){
     graph = new JPanel(new BorderLayout()); 
    //setContentPane(graph); 
    setSize(400, 250); 

    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    pieDataset.setValue("Valeur1", new Integer(27)); 
    pieDataset.setValue("Valeur2", new Integer(10)); 
    pieDataset.setValue("Valeur3", new Integer(50)); 
    pieDataset.setValue("Valeur4", new Integer(5)); 

    JFreeChart pieChart = ChartFactory.createPieChart("Salles", 
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


