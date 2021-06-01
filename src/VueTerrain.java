import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class VueTerrain extends JPanel implements Observer {
	/**
    * Terrain contenant les lampes
    */
	private Terrain t;

	/**
	* Constructeur de la VueTerrain
	* @param t un terrain
	*/
	public VueTerrain(Terrain t) {
		this.t=t;
		this.setPreferredSize(new Dimension(500,500));
	}

	/**
	* Met a jour graphiquement les changements du modele
	*/
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	/**
	* Permet de dessiner le modele
	*/
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

		for(int i=0;i<25;i++){
			if(this.t.getLampes()[i].getAllume()){
				g.setColor(Color.GREEN);
				g.fillRect(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),
				(this.t.getLampes()[i].getX()+Lampe.TAILLE),(this.t.getLampes()[i].getY()+Lampe.TAILLE));
			}
			else{
				g.setColor(Color.GRAY);
				g.fillRect(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),
				(this.t.getLampes()[i].getX()+Lampe.TAILLE),(this.t.getLampes()[i].getY()+Lampe.TAILLE));
			}
		} 

        g.setColor(Color.BLACK);
        for(int i=0;i<25;i++){
			g.drawRect(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),
			this.t.getLampes()[i].getX()+Lampe.TAILLE,this.t.getLampes()[i].getY()+Lampe.TAILLE);
        }
    }
}
