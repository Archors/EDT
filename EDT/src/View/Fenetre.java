/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Antoine
 */
public class Fenetre extends JFrame{
    public Fenetre(){
        super("EDT" );
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Ferme l'application quand la dernière fenetre de cette derniere est fermée
        this.setSize(600,400); //Definit la taille de la fenetre
        this.setLocationRelativeTo(null); //Centre la fenetre au centre de l'ecran
        JPanel pan = (JPanel) this.getContentPane();
        this.setContentPane(pan);
        this.setVisible(true);
      
    }
}
