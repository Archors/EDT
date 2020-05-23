/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milou
 */
package Model;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    PROMOTION vingtdeux = new PROMOTION();
    GROUPE TD01 = new GROUPE(1, "TD01");

    ETUDIANT Delahegue= new ETUDIANT(15,1,"delahegue@gmail.com","delahegue","Delahegue","Emilien",4);
    ETUDIANT Boulan= new ETUDIANT(24,2,"boulan@gmail.com","Boulan","Boulan","Maxime",4);
    ETUDIANT Debois=new ETUDIANT(29,3,"debois@gmail.com", "Debois", "Debois", "Julien",4);
    vingtdeux.addGROUPES(TD01);
    TD01.addETUDIANT(Delahegue);
    TD01.addETUDIANT(Boulan);
    TD01.addETUDIANT(Debois);
    vingtdeux.afficherPROMOTION();
    }
    
}
