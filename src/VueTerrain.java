import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class VueTerrain extends JPanel implements Observer{
	/**
    * Terrain contenant les lampes
    */
	private Terrain t;

	/**
	* Indique si la partie est gagnee
	*/
	private boolean gagne;

	/**
	* Constructeur de la VueTerrain
	* @param t un terrain
	*/
	public VueTerrain(Terrain t){
		this.t=t;
		this.setPreferredSize(new Dimension(500,500));
		this.gagne=false;
	}

	/**
	* Met a jour graphiquement les changements du modele
	*/
	@Override
	public void update(Observable o, Object arg){
		if(t.modeValeur("jeu")){
			this.gagne=this.t.cGagne();
		}
		repaint();
	}

	/**
	* Permet de dessiner le modele
	*/
	@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

		if(!this.gagne){
			//On dessine un carre pour chaque lampes,
			//Gris si eteinte, vert si allumee
			for(int i=0;i<25;i++){
				if(this.t.getLampes()[i].getAllume()){
					g.setColor(Color.decode("#FEFFDB"));
					g.fillRect(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),
					Lampe.TAILLE,Lampe.TAILLE);
				}
				else{
					g.setColor(Color.GRAY);
					g.fillRect(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),
					Lampe.TAILLE,Lampe.TAILLE);
				}
			}

			//On dessine une grille pour distinguer les lampes
			g.setColor(Color.BLACK);
			for(int i=0;i<25;i++){
				g.drawRect(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),
				Lampe.TAILLE,Lampe.TAILLE);
        	}
		}
		else{
			g.setColor(Color.BLUE);
			g.drawString("Bravo",100,100);
			g.drawString("C GAGNE",100,300);
		}
    }
}
