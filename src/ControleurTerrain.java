import javax.swing.event.MouseInputAdapter;

public class ControleurTerrain extends MouseInputAdapter {

    private VueBoutons vue;

    private Terrain modele;

    /**
     *
     * @param vue VueBoutons sur laquelle on ajoute les listeners.
     * @param modele Terrain
     */
    public ControleurTerrain(VueBoutons vue, Terrain modele) {
        this.vue = vue;
        this.modele = modele;
    }
}
