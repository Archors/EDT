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
public class SALLE {
    
    private int ID=0;
    private String NOM="";
    private int CAPACITE=0;
    
    public SALLE(){
    }
    
    public SALLE (int ID, String NOM, int CAPACITE){
        this.ID=ID;
        this.NOM=NOM;
        this.CAPACITE=CAPACITE;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setID(int ID){
        this.ID=ID;
    }
    
    public String getNOM(){
        return NOM;
    }
    
    public void setNOM(String NOM){
        this.NOM=NOM;
    }
    
    public void afficherSALLE(){
        System.out.println(this.NOM);
    }
}
