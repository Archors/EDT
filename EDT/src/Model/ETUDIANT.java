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
    private String NUMERO;
    
    public ETUDIANT()
    {
        super();
        NUMERO="";
    }

   public ETUDIANT(int ID,String NUMERO, String EMAIL, String PASSWD, String NOM, String PRENOM, int DROIT){
        super(ID, EMAIL, PASSWD, NOM, PRENOM, DROIT);
        this.NUMERO=NUMERO;
    }
    
    //getter PRENOM
    public String NUMERO(){
        return NUMERO;
    }
    //setterPRENOM
    public void setNUMERO(String NUMERO){
        this.NUMERO=NUMERO;
    }
    
    public void afficher(){
        System.out.print(this.NUMERO);
    }
    
   }

