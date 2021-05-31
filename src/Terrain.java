import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.math.*;
import java.util.*;
import java.util.Observable;

public class Terrain extends Observable{
    /**
    * Tableau contenant les lampes
    */
    private Lampe[] lampes;

    /**
    * Nombre de clics sur le tableau lors d'une partie
    */
    private int nbClic;

    /**
    * Constructeur aleatoire du terrain de lampes
    */
    public Terrain(){
        this.lampes=new Lampe[25];

        //On allume aléatoirement les lampes
        int alea;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                alea=(int)Math.floor(Math.random()*2);
                //Si alea vaut 1, on change l'etat de la lampe, qui est eteinte de base
                if(alea==1){
                    this.lampes[i]=new Lampe(j*Lampe.TAILLE,i*Lampe.TAILLE);
                    this.lampes[i].changerLampe();
                }
                //Sinon on cree une lampe eteinte
                else{
                    this.lampes[i]=new Lampe(j*Lampe.TAILLE,i*Lampe.TAILLE);
                }
            }
        }
    }

    /**
    * Constructeur prenant un tableau de lampes choisis en parametre
    * @param lampes un tableau de lampes
    */
    public Terrain(Lampe[] lampes){
        this.lampes=lampes;
    }

    /**
    * Retourne le nombre de clics
    */
    public int getNbClic(){
        return this.nbClic;
    }

    /**
    * Incremente de 1 le nombre de clic
    */
    public void plusNbClic(){
        this.nbClic++;
    }
}