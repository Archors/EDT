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
public class UTILISATEUR {
    //Attributs
    private int ID=0;
    //Email de l'utilisateur, nom@gmail.com
    private String EMAIL = "";
    //mot de passe de l'utilisateur = nom
    private String PASSWD="";
    //nom de famille de l'utilisateur, utilisé pour mdp
    private String NOM="";
    //prénom de l'utilisateur
    private String PRENOM="";
    // si 1--> admin || 2--> referent || 3--> prof || 4--> etudiant
    private int DROIT =0;
    
    //Méthodes
    //constructeur
    public UTILISATEUR(){}; 
    
    public UTILISATEUR(int ID, String EMAIL, String PASSWD, String NOM, String PRENOM, int DROIT){
        this.ID=ID;
        this.EMAIL=EMAIL;
        this.PASSWD=PASSWD;
        this.NOM=NOM;
        this.PRENOM=PRENOM;
        this.DROIT=DROIT;         
    }
    
    //getter ID
    public int getID(){
        return ID;
    }
    //setter ID
    public void setID(int ID){
            this.ID=ID;
    }
    
    //getter EMAIL
    public String getEMAIL(){
        return EMAIL;
    }
    //setterPRENOM
    public void setEMAIL(String EMAIL){
        this.EMAIL=EMAIL;
    }
    
    //getter PRENOM
    public String getPASSWD(){
        return PASSWD;
    }
    //setterPRENOM
    public void setPASSWD(String PASSWD){
        this.PASSWD=PASSWD;
    }
    
    //getter Nom
    public String getNOM(){
        return NOM;
    }
    //setterNOM
    public void setNOM(String NOM){
        this.NOM=NOM;
    }
    
    //getter PRENOM
    public String getPRENOM(){
        return PRENOM;
    }
    //setterPRENOM
    public void setPRENOM(String PRENOM){
        this.PRENOM=PRENOM;
    }
    
    //getter DROIT
    public int getDROIT(){
        return DROIT;
    }
    //setter DROIT
    public void SetDROIT(int DROIT){
        this.DROIT= DROIT;
    }
    
    
    
            
}
