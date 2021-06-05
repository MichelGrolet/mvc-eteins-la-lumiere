import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurTerrain implements MouseListener {

    private final VueTerrain vueTerrain;

    private final Terrain modele;

    /**
     * Ajoute les listeners sur les boutons.
     * @param vueTerrain
     * @param modele Terrain
     */
    public ControleurTerrain(VueTerrain vueTerrain, Terrain modele) {
        this.vueTerrain = vueTerrain;
        this.modele = modele;
    }

    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x<=500 && y<=500) {
            if (this.modele.modeValeur("configuration")) modele.configLampe(x, y);
            else if (this.modele.modeValeur("jeu")){ modele.changeLampe(x, y)
            this.modele.cGagne();
            if(this.modele.modeValeur("jeu") && this.modele.getGagne()){
                this.modele.modeValeur("configuration");
                this.modele.setGagne();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
