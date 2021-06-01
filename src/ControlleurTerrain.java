import javax.swing.event.MouseInputAdapter;

public class ControlleurTerrain extends MouseInputAdapter {

    private VueBoutons vue;

    private Terrain modele;

    /**
     *
     * @param vue VueBoutons sur laquelle on ajoute les listeners.
     * @param modele Terrain
     */
    public ControlleurTerrain(VueBoutons vue, Terrain modele) {
        this.vue = vue;
        this.modele = modele;
    }
}
