import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
* Classe qui controle le terrain
*/

public class ControleurTerrain implements MouseListener {
    /**
    * Le terrain de lampes
    */
    private final Terrain modele;

    /**
     * Ajoute les listeners sur les boutons.
     * @param modele Terrain
     */
    public ControleurTerrain( Terrain modele) {
        this.modele = modele;
    }

    /**
    * vide
    * @param e un MouseEvent
    */
    public void mouseClicked(MouseEvent e){

    }

    /**
    * Recupere l'evenement lorsque l'on appuie sur le bouton gauche de la souris
    * @param e un MouseEvent
    */
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x<=500 && y<=500 && e.getButton()==MouseEvent.BUTTON1) {
            if (this.modele.modeValeur("configuration")) modele.configLampe(x, y);
            else if (this.modele.modeValeur("jeu")) modele.changeLampe(x, y);
            if(this.modele.modeValeur("jeu")) this.modele.cGagne();
        }
    }

    /**
    * vide
    * @param e un MouseEvent
    */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
    * vide
    * @param e un MouseEvent
    */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
    * vide
    * @param e un MouseEvent
    */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
