import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.math.*;
import java.util.*;
import java.util.Observable;

/**
* Classe representant une lampe
*/

public class Lampe{
    /**
    * Constante pour la taille d'une lampe
    */
    public final static int TAILLE=100;

    /**
    * Coordonnee x d'une lampe
    */
    private int x;

    /**
    * Coordonnee y d'une lampe
    */
    private int y;

    /**
    * Booleen indiquant si la lampe est allume
    */
    private boolean estAllume;

    /**
    * Constructeur qui prends des coordonnees x y pour creer une lampe
    * @param x coordonnee x de depart
    * @param y coordonnee y de depart
    */
    public Lampe(int x,int y){
        this.x=x;
        this.y=y;
        this.estAllume=true;
    }

    /**
    * Permet de changer l'etat d'un lampe (allume/eteinte)
    */
    public void changerLampe(){
        if(this.estAllume){
            this.estAllume=false;
        }
        else{
            this.estAllume=true;
        }
    }

    /**
    * Retourne la coordonnee x de la lampe
    * @return un entier
    */
    public int getX(){
        return this.x;
    }

    /**
    * Retourne la coordonnee y de la lampe
    * @return un entier
    */
    public int getY(){
        return this.y;
    }

    /**
    * Retourne l'etat de la lampe
    * @return un boolean
    */
    public boolean getAllume(){
        return this.estAllume;
    }

    /**
    * Permet de changer l'etat de la lampe (allume/eteint)
    * @param estAllume un boolean qui indique si on allume ou non
    */
    public void setEstAllume(boolean estAllume) {
        this.estAllume = estAllume;
    }
}