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
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Model.ETUDIANT;
import Model.SEANCE;

import Controller.ADD_SEANCE;
import Controller.AJOUTER_GROUPE;
import Controller.SUPPRIMER_SEANCE;
import Controller.MODIFIER_ETAT_SEANCE;

import Controller.DEPLACER_SEANCE;

import java.awt.GridBagConstraints;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.TableColumn;


/**classe gérant les modifications des séances*/
public class Modification extends JPanel{
  private Color color = Color.white;
  
  private JPanel principal = new JPanel();
  private JPanel modification = new JPanel(); 
  private JPanel pan1 = new JPanel(); 
  private int compt=1;
  CardLayout cl = new CardLayout();
  JPanel content = new JPanel();
  //Liste des noms de nos conteneurs pour la pile de cartes
  String[] listContent = {"CARD_1", "CARD_2", "CARD_3", "CARD_5", "CARD_6"};
  //int indice = 0;

   
  public Modification(){
    
    principal.setLayout(new BorderLayout());
    //principal.add(menu(), BorderLayout.NORTH);
    //principal.add(creer(), BorderLayout.SOUTH);
		
    //création des cartes pour chaque action
    JPanel card1 = new JPanel();
    card1=creer();
    //card1.setBackground(Color.yellow);
    JPanel card2 = new JPanel();
    card2=annuler();
    //card2.setBackground(Color.red);		
    JPanel card3 = new JPanel();
    card3=ajouter();
    //card3.setBackground(Color.green);
    //JPanel card4 = new JPanel();
    //card4=retirer();
    //card4.setBackground(Color.black);		
    JPanel card5 = new JPanel();
    card5=deplacer();
    //card5.setBackground(Color.white);		
    JPanel card6 = new JPanel();
    card6=modifier();
    //card6.setBackground(Color.orange);

    //panel bouton et création des boutons
    JPanel boutonPane = new JPanel();
    JButton creer = new JButton("Ajouter groupe");
    JButton supprimer = new JButton("Supprimer séance");
    JButton ajouter = new JButton("Ajouter séance");
    //JButton retirer = new JButton("Retirer séance");
    JButton deplacer = new JButton("Déplacer séance");
    JButton modifier = new JButton("Modifier état séance");

    //action bouton creer
    creer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[0]);
      }
    });
	
    //action bouton annuler
    supprimer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[1]);
      }
    });

    //action bouton ajouter
    ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){      
        compt = 1;
        cl.show(content, listContent[2]);
      }
    });

    //action bouton retirer
    /*retirer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[3]);
      }
    });*/

    //action bouton deplacer
    deplacer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[3]);
      }
    });

    //action bouton modifier
    modifier.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){       
        cl.show(content, listContent[4]);
      }
    });
	
    //ajout des boutons
    boutonPane.add(creer);
    boutonPane.add(supprimer);
    boutonPane.add(ajouter);
    //boutonPane.add(retirer);
    boutonPane.add(deplacer);
    boutonPane.add(modifier);
    

    content.setLayout(cl);
    //Ajout des cartes
    content.add(card1, listContent[0]);
    content.add(card2, listContent[1]);
    content.add(card3, listContent[2]);
    //content.add(card4, listContent[3]);
    content.add(card5, listContent[3]);
    content.add(card6, listContent[4]);

    principal.add(boutonPane, BorderLayout.NORTH);
    principal.add(content, BorderLayout.CENTER);
      	
  }




public JPanel creer(){
    JPanel creer = new JPanel();

        JLabel semaine = new JLabel("Semaine : ");
        creer.add(semaine);

        JTextField textsemaine = new JTextField();
        textsemaine.setPreferredSize(new Dimension(80, 20));
        creer.add(textsemaine);

        JLabel date = new JLabel("Date : ");
        creer.add(date);
         
        JTextField textdate = new JTextField();
        textdate.setPreferredSize(new Dimension(80, 20));
        creer.add(textdate);

        JLabel heuredeb = new JLabel("Heure de début : ");
        creer.add(heuredeb);
         
        JTextField textheuredeb = new JTextField();
        textheuredeb.setPreferredSize(new Dimension(80, 20));
        creer.add(textheuredeb);

        JLabel salle = new JLabel("Salle : ");
        creer.add(salle);
         
        JTextField textesalle = new JTextField();
        textesalle.setPreferredSize(new Dimension(80, 20));
        creer.add(textesalle);

        JLabel groupe = new JLabel("Goupe : ");
        creer.add(groupe);
         
        JTextField textegroupe = new JTextField();
        textegroupe.setPreferredSize(new Dimension(80, 20));
        creer.add(textegroupe);

        JLabel promo = new JLabel("Promo : ");
        creer.add(promo);
         
        JTextField textpromo = new JTextField();
        textpromo.setPreferredSize(new Dimension(80, 20));
        creer.add(textpromo);


        JButton create = new JButton("Creer");
        creer.add(create); 

       create.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            String ssemaine = textsemaine.getText();
            int isemaine = Integer.parseInt(ssemaine);
            String sdate = textdate.getText();
            String sheuredeb = textheuredeb.getText();
            String ssalle = textesalle.getText();
            String sgroupe = textegroupe.getText();
            String spromo = textpromo.getText();
            //System.out.println("le résultat est : " + testr);
            AJOUTER_GROUPE ajout = new AJOUTER_GROUPE();
            String aj = ajout.AJOUTER_GROUPE_INSTANCE (isemaine, sdate, sheuredeb, ssalle, sgroupe, spromo);
            JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, aj, "Ajout", JOptionPane.INFORMATION_MESSAGE);
           }
        });

        return creer;

}

public JPanel annuler(){
    JPanel supprimer = new JPanel();

        JLabel semaine = new JLabel("Semaine : ");
        supprimer.add(semaine);

        JTextField textsemaine = new JTextField();
        textsemaine.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textsemaine);

        JLabel date = new JLabel("Date : ");
        supprimer.add(date);
         
        JTextField textdate = new JTextField();
        textdate.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textdate);

        JLabel heuredeb = new JLabel("Heure de début : ");
        supprimer.add(heuredeb);
         
        JTextField textheuredeb = new JTextField();
        textheuredeb.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textheuredeb);

        /*JLabel heurefin = new JLabel("Heure de fin : ");
        supprimer.add(heurefin);

        JTextField textheurefin = new JTextField();
        textheurefin.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textheurefin);

        JLabel etat = new JLabel("Etat : ");
        supprimer.add(etat);

        JTextField textetat = new JTextField();
        textetat.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textetat);

        JLabel nom = new JLabel("Nom du cours : ");
        supprimer.add(nom);
         
        JTextField textnom = new JTextField();
        textnom.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textnom);

        JLabel type = new JLabel("Type du cours : ");
        supprimer.add(type);
         
        JTextField texttype = new JTextField();
        texttype.setPreferredSize(new Dimension(80, 20));
        supprimer.add(texttype);

        JLabel enseignant = new JLabel("Enseignant : ");
        supprimer.add(enseignant);
         
        JTextField textenseignant = new JTextField();
        textenseignant.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textenseignant);

        JLabel groupe = new JLabel("Goupe : ");
        supprimer.add(groupe);
         
        JTextField textegroupe = new JTextField();
        textegroupe.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textegroupe);*/

        JLabel salle = new JLabel("Salle : ");
        supprimer.add(salle);
         
        JTextField textesalle = new JTextField();
        textesalle.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textesalle);

        /*JLabel promo = new JLabel("Promo : ");
        supprimer.add(promo);
         
        JTextField textpromo = new JTextField();
        textpromo.setPreferredSize(new Dimension(80, 20));
        supprimer.add(textpromo);*/


        JButton delete = new JButton("Supprimer");
        supprimer.add(delete); 

       delete.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            String ssemaine = textsemaine.getText();
            int isemaine = Integer.parseInt(ssemaine);
            String sdate = textdate.getText();
            String sheuredeb = textheuredeb.getText();
            String ssalle = textesalle.getText();
            //System.out.println("le résultat est : " + testr);
            SUPPRIMER_SEANCE supp_seance = new SUPPRIMER_SEANCE();
            String sp = supp_seance.SUPPRIMER_SEANCE_INSTANCE(isemaine,sdate,sheuredeb,ssalle);
            JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, sp, "Suppression", JOptionPane.INFORMATION_MESSAGE);
           }
        });

        return supprimer;
}

public JPanel ajouter(){

        JPanel ajouter = new JPanel();

        JLabel semaine = new JLabel("Semaine : ");
        ajouter.add(semaine);

        JTextField textsemaine = new JTextField();
        textsemaine.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textsemaine);

        JLabel date = new JLabel("Date : ");
        ajouter.add(date);
         
        JTextField textdate = new JTextField();
        textdate.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textdate);

        JLabel heuredeb = new JLabel("Heure de début : ");
        ajouter.add(heuredeb);
         
        JTextField textheuredeb = new JTextField();
        textheuredeb.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textheuredeb);

        JLabel heurefin = new JLabel("Heure de fin : ");
        ajouter.add(heurefin);

        JTextField textheurefin = new JTextField();
        textheurefin.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textheurefin);

        JLabel etat = new JLabel("Etat : ");
        ajouter.add(etat);

        JTextField textetat = new JTextField();
        textetat.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textetat);

        JLabel nom = new JLabel("Nom du cours : ");
        ajouter.add(nom);
         
        JTextField textnom = new JTextField();
        textnom.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textnom);

        JLabel type = new JLabel("Type du cours : ");
        ajouter.add(type);
         
        JTextField texttype = new JTextField();
        texttype.setPreferredSize(new Dimension(80, 20));
        ajouter.add(texttype);

        JLabel enseignant = new JLabel("Enseignant : ");
        ajouter.add(enseignant);
         
        JTextField textenseignant = new JTextField();
        textenseignant.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textenseignant);

        JLabel groupe = new JLabel("Goupe : ");
        ajouter.add(groupe);
         
        JTextField textegroupe = new JTextField();
        textegroupe.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textegroupe);

        JLabel salle = new JLabel("Salle : ");
        ajouter.add(salle);
         
        JTextField textesalle = new JTextField();
        textesalle.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textesalle);

        JLabel promo = new JLabel("Promo : ");
        ajouter.add(promo);
         
        JTextField textpromo = new JTextField();
        textpromo.setPreferredSize(new Dimension(80, 20));
        ajouter.add(textpromo);


        JButton ajou = new JButton("Ajouter");
        ajouter.add(ajou); 

       ajou.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            String ssemaine = textsemaine.getText();
            int isemaine = Integer.parseInt(ssemaine);
            String sdate = textdate.getText();
            String sheuredeb = textheuredeb.getText();
            String sheurefin = textheurefin.getText();
            String setat = textetat.getText();
            int ietat = Integer.parseInt(setat);
            String snom = textnom.getText();
            String stype = texttype.getText();
            String senseignant = textenseignant.getText();
            String sgroupe = textegroupe.getText();
            String ssalle = textesalle.getText();
            String spromo = textpromo.getText();
            //System.out.println("le résultat est : " + testr);
            ADD_SEANCE nvlseance = new ADD_SEANCE();
            String ns = nvlseance.AJOUTER_SEANCE(isemaine, sdate, sheuredeb, sheurefin, ietat, snom, stype, senseignant, sgroupe, ssalle, spromo);
            JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, ns, "Ajout", JOptionPane.INFORMATION_MESSAGE);
           }
        });

        return ajouter;
}

//public JPanel retirer(){}

public JPanel deplacer(){
    JPanel deplacer = new JPanel();

        JLabel semaine = new JLabel("Semaine : ");
        deplacer.add(semaine);

        JTextField textsemaine = new JTextField();
        textsemaine.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textsemaine);

        JLabel date = new JLabel("Date : ");
        deplacer.add(date);
         
        JTextField textdate = new JTextField();
        textdate.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textdate);

        JLabel heuredeb = new JLabel("Heure de début : ");
        deplacer.add(heuredeb);
         
        JTextField textheuredeb = new JTextField();
        textheuredeb.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textheuredeb);

        JLabel nom = new JLabel("Nom de la salle : ");
        deplacer.add(nom);
         
        JTextField textnom = new JTextField();
        textnom.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textnom);

        JLabel newsemaine = new JLabel("Nouvelle semaine : ");
        deplacer.add(newsemaine);
         
        JTextField textnewsemaine = new JTextField();
        textnewsemaine.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textnewsemaine);

        JLabel newdate = new JLabel("Nouvelle date : ");
        deplacer.add(newdate);
         
        JTextField textnewdate = new JTextField();
        textnewdate.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textnewdate);

        JLabel newheuredeb = new JLabel("Nouvelle heure début : ");
        deplacer.add(newheuredeb);
         
        JTextField textnewheuredeb = new JTextField();
        textnewheuredeb.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textnewheuredeb);

        JLabel newheurefin = new JLabel("Nouvelle heure fin : ");
        deplacer.add(newheurefin);
         
        JTextField textnewheurefin = new JTextField();
        textnewheurefin.setPreferredSize(new Dimension(80, 20));
        deplacer.add(textnewheurefin);


        JButton move = new JButton("Déplacer");
        deplacer.add(move); 

       move.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            String ssemaine = textsemaine.getText();
            int isemaine = Integer.parseInt(ssemaine);
            String sdate = textdate.getText();
            String sheuredeb = textheuredeb.getText();
            String snom = textnom.getText();
            String snsemaine = textnewsemaine.getText();
            int insemaine = Integer.parseInt(snsemaine);
            String snewdate = textnewdate.getText();
            String snewheuredeb = textnewheuredeb.getText();
            String snewheurefin = textnewheurefin.getText();
            //System.out.println("le résultat est : " + testr);
            DEPLACER_SEANCE depp = new DEPLACER_SEANCE();
            String depla = depp.DEPLACER_SEANCE_INSTANCE(isemaine, sdate, sheuredeb, snom, insemaine, snewdate, snewheuredeb, snewheurefin);
            JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, depla, "Ajout", JOptionPane.INFORMATION_MESSAGE);
           }
        });

        return deplacer;
}

public JPanel modifier(){
    JPanel modif = new JPanel();

        JLabel semaine = new JLabel("Semaine : ");
        modif.add(semaine);

        JTextField textsemaine = new JTextField();
        textsemaine.setPreferredSize(new Dimension(80, 20));
        modif.add(textsemaine);

        JLabel date = new JLabel("Date : ");
        modif.add(date);
         
        JTextField textdate = new JTextField();
        textdate.setPreferredSize(new Dimension(80, 20));
        modif.add(textdate);

        JLabel heuredeb = new JLabel("Heure de début : ");
        modif.add(heuredeb);
         
        JTextField textheuredeb = new JTextField();
        textheuredeb.setPreferredSize(new Dimension(80, 20));
        modif.add(textheuredeb);

        JLabel nom = new JLabel("Nom de la salle : ");
        modif.add(nom);
         
        JTextField textnom = new JTextField();
        textnom.setPreferredSize(new Dimension(80, 20));
        modif.add(textnom);

        JLabel type = new JLabel("Etat : ");
        modif.add(type);
         
        JTextField texttype = new JTextField();
        texttype.setPreferredSize(new Dimension(80, 20));
        modif.add(texttype);

        JButton move = new JButton("Modifier");
        modif.add(move); 

       move.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            String ssemaine = textsemaine.getText();
            int isemaine = Integer.parseInt(ssemaine);
            String sdate = textdate.getText();
            String sheuredeb = textheuredeb.getText();
            String snom = textnom.getText();
            String stype = texttype.getText();
            int itype = Integer.parseInt(stype);
            
            //System.out.println("le résultat est : " + testr);
            MODIFIER_ETAT_SEANCE mod = new MODIFIER_ETAT_SEANCE();
            String modi = mod.MODIFIER_ETAT_SEANCE(isemaine, sdate, sheuredeb, snom, itype);
            JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, modi, "Ajout", JOptionPane.INFORMATION_MESSAGE);
           }
        });

        return modif;
}

    public JPanel getPan(){
        return principal;
    }
    
}
