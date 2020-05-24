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
public class PROMOTION {
    private int ID=0;
    //String sous la forme de l'année de la promotion
    private String NOM="";
    private Set<GROUPE> listGROUPES =new HashSet<GROUPE>();
    
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
        public Set<GROUPE> getlistGROUPES(){
        return listGROUPES;
    }
    //setterlistETUDIANT    
    public void setlistGROUPES(Set<GROUPE> listGROUPES){
        this.listGROUPES=listGROUPES;
    }
    //ajouter un etudiant dans la liste
    public void addGROUPES (GROUPE groupe){
        if(this.listGROUPES.contains(groupe)!=true)
            this.listGROUPES.add(groupe);
    }
    
    public void removeETUDIANT(GROUPE groupe){
        if(this.listGROUPES.contains(groupe) == true)
            this.listGROUPES.remove(groupe);
    }
    
    public boolean equals(GROUPE cls){
        return this.getID()== cls.getID();
    }

        public void afficherGROUPE(){
           
for (GROUPE groupe : listGROUPES)
{
    System.out.println(groupe.getNOM());
}

}
public void afficherPROMOTION(){
           
for (GROUPE groupe : listGROUPES)
{
    System.out.println(groupe.getNOM());
}

}
    
}
