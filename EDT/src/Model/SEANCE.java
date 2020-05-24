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
public class SEANCE {
    private int ID=0;
    private String SEMAINE="";
    private String DATE="";
    private String HEURE_DEBUT="";
    private String HEURE_FIN="";
    private int ETAT=0;
    
    private Set<COURS> listCOURS =new HashSet<COURS>();
    private Set<TYPE_COURS> listTYPE_COURS =new HashSet<TYPE_COURS>();

    
    public SEANCE(){}
    public SEANCE(int ID, String SEMAINE, String DATE, String HEURE_DEBUT, String HEURE_FIN, int ETAT){
        this.ID=ID;
        this.SEMAINE=SEMAINE;
        this.DATE=DATE;
        this.HEURE_DEBUT=HEURE_DEBUT;
        this.HEURE_FIN=HEURE_FIN;
        this.ETAT=ETAT;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setID(int ID){
        this.ID=ID;
    }
    
        public String getSEMAINE(){
        return SEMAINE;
    }
    
    public void setSEMAINE(String SEMAINE){
        this.SEMAINE=SEMAINE;
    }
    
    public String getDATE(){
        return DATE;
    }
    
    public void setDATE(String DATE){
        this.DATE=DATE;
    }
    
    public String getHEURE_DEBUT(){
        return HEURE_DEBUT;
    }
    
    public void setHEURE_DEBUT(String HEURE_DEBUT){
        this.HEURE_DEBUT=HEURE_DEBUT;
    }
    
    public String getHEURE_FIN(){
        return SEMAINE;
    }
    
    public void setHEURE_FIN(String HEURE_FIN){
        this.HEURE_FIN=HEURE_FIN;
    }
    
    public int getETAT(){
        return ETAT;
    }
    
    public void setETAT(int ETAT){
        this.ETAT=ETAT;
    }
    
    
    
    public Set<COURS> COURS(){
        return listCOURS;
    }
    //setterlistETUDIANT    
    public void setlistCOURS(Set<COURS> listCOURS){
        this.listCOURS=listCOURS;
    }
    //ajouter un etudiant dans la liste
    public void addCOURS (COURS cours){
        if(this.listCOURS.contains(cours)!=true)
            this.listCOURS.add(cours);
    }
    
    public void removeCOURS(COURS cours){
        if(this.listCOURS.contains(cours) == true)
            this.listCOURS.remove(cours);
    }
    
    public boolean equals(COURS cls){
        return this.getID()== cls.getID();
    }
    
    
    
    
        public Set<TYPE_COURS> TYPE_COURS(){
        return listTYPE_COURS;
    }
    //setterlistETUDIANT    
    public void setlistTYPE_COURS(Set<TYPE_COURS> listTYPE_COURS){
        this.listTYPE_COURS=listTYPE_COURS;
    }
    //ajouter un etudiant dans la liste
    public void addTYPE_COURS (TYPE_COURS type_cours){
        if(this.listTYPE_COURS.contains(type_cours)!=true)
            this.listTYPE_COURS.add(type_cours);
    }
    
    public void removeTYPE_COURS(TYPE_COURS type_cours){
        if(this.listTYPE_COURS.contains(type_cours) == true)
            this.listTYPE_COURS.remove(type_cours);
    }
    
    public boolean equals(TYPE_COURS cls){
        return this.getID()== cls.getID();
    }

    public void afficherSEANCE(){
System.out.println("Seance du jour:"); 
for (COURS cours : listCOURS)
{
    System.out.println(cours.getNOM());
}

for(TYPE_COURS type_cours : listTYPE_COURS)
{
    System.out.println(type_cours.getNOM());
}

}
    
}
