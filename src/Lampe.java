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

    
}