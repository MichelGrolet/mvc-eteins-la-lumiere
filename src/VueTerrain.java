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

        g.setColor(Color.BLACK);
        for(int i=1;i<6;i++){
			for(int j=0;j<5;j++){
				g.drawRect(this.t.getLampes()[i*j].getX(),this.t.getLampes()[i*j].getY(),
				this.t.getLampes()[i*j].getX()+Lampe.TAILLE,this.t.getLampes()[i*j].getY()+Lampe.TAILLE);
			}
        }

        for(int i=1;i<6;i++){
			for(int j=0;j<5;j++){
				if(this.t.getLampes()[i*j].getAllume()){
					g.setColor(Color.GREEN);
					g.fillRect(this.t.getLampes()[i*j].getX()+1,this.t.getLampes()[i*j].getY()+1,
					(this.t.getLampes()[i*j].getX()+Lampe.TAILLE)-1,(this.t.getLampes()[i*j].getY()+Lampe.TAILLE)-1);
				}
				else{
					g.setColor(Color.GRAY);
					g.fillRect(this.t.getLampes()[i*j].getX()+1,this.t.getLampes()[i*j].getY()+1,
					(this.t.getLampes()[i*j].getX()+Lampe.TAILLE)-1,(this.t.getLampes()[i*j].getY()+Lampe.TAILLE)-1);
				}
			} 
        }
    }
	
}
