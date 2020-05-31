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
public class GROUPE {
    private int ID=0;
    private String NOM="";
    
    //Utilisation de Set (extends collection) pour faire une liste d'étudiants appartenant a un groupe
    private Set<ETUDIANT> listETUDIANT =new HashSet<ETUDIANT>();
    
    public GROUPE(){}
    
    public GROUPE(int ID, String NOM){
        this.ID=ID;
        this.NOM=NOM;
    }
    
    public int getID()
    {return ID;}    
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
    
    //On s'occupe de la collection d'étudiants
    //getterlistETUDIANT
    public Set<ETUDIANT> getlistETUDIANT(){
        return listETUDIANT;
    }
    //setterlistETUDIANT    
    public void setlistETUDIANT(Set<ETUDIANT> listETUDIANT){
        this.listETUDIANT=listETUDIANT;
    }
    //ajouter un etudiant dans la liste
    public void addETUDIANT (ETUDIANT etudiant){
        if(this.listETUDIANT.contains(etudiant)!=true)
            this.listETUDIANT.add(etudiant);
    }
    
    public void removeETUDIANT(ETUDIANT etudiant){
        if(this.listETUDIANT.contains(etudiant) == true)
            this.listETUDIANT.remove(etudiant);
    }
    
    public boolean equals(GROUPE cls){
        return this.getID()== cls.getID();
    }
    
        public void afficherLISTEETUDIANT(){
           
for (ETUDIANT etudiant : listETUDIANT)
{
    System.out.println(etudiant.getNOM());
}

}
        
public void afficherGROUPE(){
           
    System.out.println("Le nom du groupe : " + this.NOM);


}
    
}
    