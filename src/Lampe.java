import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.math.*;
import java.util.*;
import java.util.Observable;

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
        this.estAllume=false;
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
    */
    public int getX(){
        return this.x;
    }

    /**
    * Retourne la coordonnee y de la lampe
    */
    public int getY(){
        return this.y;
    }

    /**
    * Retourne l'etat de la lampe
    */
    public int getAllume(){
        return this.estAllume;
    }
}