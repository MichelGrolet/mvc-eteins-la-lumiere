import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.math.*;
import java.util.*;
import java.util.Observable;

public class Lampe{
    /**
    * Tableau representant les lampes avec des booleens
    */
    private boolean[] lampes;

    /**
    * Constructeur aleatoire du terrain de lampes
    */
    public Terrain(){
        this.lampes=new boolean[25];

        //On allume aléatoirement les lampes
        int alea;
        for(int i=0;i<25;i++){
            alea=(int)Math.floor(Math.random()*2);
            if(alea==0){
                this.lampes[i]=false;
            }
            else{
                this.lampes[i]=true;
            }
        }
    }

    /**
    * Constructeur prenant un tableau de booleen choisis en parametre
    */
    public Terrain(boolean[] lampes){
        this.lampes=lampes;
    }

    
}