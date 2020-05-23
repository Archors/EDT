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
public class TYPE_COURS {
        private int ID=0;
    //String correspond au type du cours, TD,CI,TP etc. 
    private String NOM="";
    
    public TYPE_COURS(){
    }
    
    public TYPE_COURS(int ID, String NOM)
    {
        this.ID=ID;
        this.NOM=NOM;
    }
    
    //getter ID
    public int getID(){
        return ID;
    }
    //setter ID
    public void setID(int ID){
            this.ID=ID;
    }
    
    //getter NOM
    public String getNOM(){
        return NOM;
    }
    //setter NOM
    public void setNOM(String NOM){
        this.NOM=NOM;
    }
}
