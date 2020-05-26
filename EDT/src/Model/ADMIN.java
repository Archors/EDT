/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Milou
 */
public class ADMIN extends UTILISATEUR{
    
    public ADMIN()
    {
        super();
    }

   public ADMIN(int ID, String EMAIL, String PASSWD, String NOM, String PRENOM, int DROIT){
        super(ID, EMAIL, PASSWD, NOM, PRENOM, DROIT);

    }
    
    //getter PRENOM

    
    public void afficherADMIN(){
        System.out.println(this.ID);
        System.out.println(this.EMAIL);
        System.out.println(this.NOM);
        System.out.println(this.DROIT);
    }
    
   }

