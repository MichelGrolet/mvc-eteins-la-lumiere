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
    * Constructeur du terrain de lampes, eteintes
    */
    public Terrain(){
        //Tableau de 25 lampes
        this.lampes=new Lampe[25];

        //On cree des lampes, avec des coordonnees d'un tableau 5x5
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                this.lampes[i*5+j]=new Lampe(j*Lampe.TAILLE,i*Lampe.TAILLE);
            }
        }
    }

    /**
    * Permet d'allumer aleatoirement les lampes du terrain
    */
    public void aleaLampe(){
        //On allume aléatoirement les lampes
        int alea;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                alea=(int)Math.floor(Math.random()*2);
                //Si alea vaut 1, on change l'etat de la lampe, qui est eteinte de base
                if(alea==1){
                    this.lampes[i].changerLampe();
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
    * @return un entier
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

    /**
    * Permet de changer l'etat d'une lampe du tableau
    * en fonction des coordonnees fournies
    * @param x coordonnees x de la lampe a changer
    * @param y coordonnees y de la lampe a changer
    */
    public void changeLampe(int x,int y){
        //On boucle jusqu'a trouver la bonne lampe
        boolean trouve=false;
        int i=0;
        while(!trouve){
            //Si les coordonnees fournies sont comprises dans la lampe, on change on etat
            if(this.lampes[i].getX()<x && this.lampes[i].getY()<y && this.lampes[i].getX()+Lampe.TAILLE>=x
            && this.lampes[i].getY()+Lampe.TAILLE>=y){
                this.lampes[i].changerLampe();
                trouve=true;
            }
            else{
                i++;
            } 
        }
        //On allume les 4 lampes adjacentes, en fonction da la place dans le tableau

        //Celle en haut de la lampe cliquee
        if(i>=5){
            this.lampes[(i+20)%25].changerLampe();
        }

        //Celle a droite de la lampe cliquee
        if((i+1)%5!=0){
            this.lampes[i+1].changerLampe();
        }

        //Celle a gauche de la lampe cliquee
        if(i%4!=0){
            this.lampes[i+1].changerLampe();
        }
        this.lampes[(i+24)%25].changerLampe();

        //Celle en bas de la lampe cliquee
        if(i<20){
            this.lampes[(i+5)%25].changerLampe();
        }

        //On ajoute un clic
        plusNbClic();

        //On met a jour les changements et on notifie les observers
        setChanged();
        notifyObservers();
    }

    /**
    * Retourne le tableau de lampes
    * @return un tableau de lampes
    */
    public Lampe[] getLampes(){
        return this.lampes;
    }

    /**
    * Permet d'eteindre toutes les lampes
    */
    public void reinitialiser(){
        for(int i=0;i<this.lampes.length;i++){
            if(this.lampes[i].getAllume()){
                this.lampes[i].changerLampe();
            }
        }
        this.nbClic=0;
        setChanged();
        notifyObservers();
    }

    /**
    * Change l'etat de la lampe aux coordonnees donnees
    * @param x coordonnee x
    * @param y coordonnee y
    */
    public void configLampe(int x,int y){
        boolean trouve=false;
        int i=0;
        while(!trouve){
            //Si les coordonnees fournies sont comprises dans la lampe, on change on etat
            if(this.lampes[i].getX()<x && this.lampes[i].getY()<y && this.lampes[i].getX()+Lampe.TAILLE>=x
            && this.lampes[i].getY()+Lampe.TAILLE>=y){
                this.lampes[i].changerLampe();
                trouve=true;
            }
            else{
                i++;
            } 
        } 
        setChanged();
        notifyObservers();
    }
}