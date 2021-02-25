package algo;

import model.InterList;

import java.util.ArrayList;

class Etat {
    int temps;
    int interserction;
    String rue;

    public Etat(int temps, int interserction, String rue) {
        this.temps = temps;
        this.interserction = interserction;
        this.rue = rue;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getInterserction() {
        return interserction;
    }

    public void setInterserction(int interserction) {
        this.interserction = interserction;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }
}

public class Algo 
{
    InterList inters;
    ArrayList<Etat> reponse;
    
    public void Algo(InterList inters)
    {
        this.inters=inters;
    }
    public void algotrèsnaif()
    {
        boolean fin = true;
        while(fin)
        {
            //for inter in this.inters.getIn(){}
        }
    //Pour chaque temps
        //Pour chaque noeud
            //Pour chaque intersection entrante
                //Pour chaque voiture *
                    //calcul de ce qui reste à parcourir *
                //calcul de la moyenne *
            //Selection de l'intersection avec la plus grande moyenne *
            //Vert pour l'intersection sélectionnée
    }

 public void algomoinsnaif() {

 }

}
