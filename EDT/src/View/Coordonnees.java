/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Antoine
 */
//classe pour l'utilisation des coordonnées du tableau
public class Coordonnees {
    private int x=0;
    private int y=0;
    public Coordonnees(){}

    public void setx(int valeurx){
        x=valeurx;
    }

    public void sety(int valeury){
        y=valeury;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
}
