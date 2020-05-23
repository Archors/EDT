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
public class PROMOTION {
    private int ID=0;
    //String sous la forme de l'année de la promotion
    private String NOM="";
    
    public PROMOTION(){
    }
    
    public PROMOTION(int ID, String NOM)
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
