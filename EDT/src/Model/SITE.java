/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Milou
 */
public class SITE {
        private int ID=0;
    //String du nom du site, E1,E2,E3 etc. 
    private String NOM="";
    
    private Set<SALLE> listSALLE =new HashSet<SALLE>();

    
    public SITE(){
    }
    
    public SITE(int ID, String NOM)
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
    
    public Set<SALLE> getlistSALLE(){
        return listSALLE;
    }
    //setterlistETUDIANT    
    public void setlistSALLE(Set<SALLE> listSALLE){
        this.listSALLE=listSALLE;
    }
    //ajouter un etudiant dans la liste
    public void addSALLE (SALLE salle){
        if(this.listSALLE.contains(salle)!=true)
            this.listSALLE.add(salle);
    }
    
    public void removeSALLE(SALLE salle){
        if(this.listSALLE.contains(salle) == true)
            this.listSALLE.remove(salle);
    }
    
    public boolean equals(SALLE cls){
        return this.getID()== cls.getID();
    }
    
        public void afficherSITE(){
System.out.println("Nom du site : " + this.getNOM());
System.out.println("Composé de "+ listSALLE.size()+ "salles");

for (SALLE salle : listSALLE)
{
    System.out.println(salle.getNOM());
}
        }
    
    
    
    
    
}
