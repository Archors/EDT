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
public class ETUDIANT extends UTILISATEUR{
    private int NUMERO;
    
    ETUDIANT()
    {
        super();
        NUMERO=0;
    }

    ETUDIANT(int NUMERO, int ID, String EMAIL, String PASSWD, String NOM, String PRENOM, int DROIT){
        super(ID, EMAIL, PASSWD, NOM, PRENOM, DROIT);
        this.NUMERO=NUMERO;
    }
    
    //getter PRENOM
    public int NUMERO(){
        return NUMERO;
    }
    //setterPRENOM
    public void setNUMERO(int NUMERO){
        this.NUMERO=NUMERO;
    }
    
    public void afficher(){
        System.out.print(this.NUMERO);
    }
    
   }

