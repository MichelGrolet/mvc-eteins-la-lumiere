import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

/**
 * Classe gerant l'affichage du terrain
 */

public class VueTerrain extends JPanel implements Observer{
	/**
    * Terrain contenant les lampes
    */
	private Terrain t;

	/**
	* Decalage pour la construction des formes de lampe
	*/
	private final static int decalage=20;

	/**
	* Constructeur de la VueTerrain
	* @param t un terrain
	*/
	public VueTerrain(Terrain t){
		this.t=t;
		this.setPreferredSize(new Dimension(500,500));
		this.setBackground(Color.BLUE);
	}

	/**
	* Met a jour graphiquement les changements du modele
	* @param o un observer
	* @param arg un objet
	*/
	@Override
	public void update(Observable o, Object arg){
		repaint();
	}

	/**
	* Permet de dessiner le modele
	* @param g le contexte graphique
	*/
	@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

		//On dessine un polygone pour chaque lampe
			
		for(int i=0;i<25;i++){
			//Coordonneees pour les polygones
			int[] x={this.t.getLampes()[i].getX()+decalage,this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage,
					this.t.getLampes()[i].getX()+Lampe.TAILLE,this.t.getLampes()[i].getX()+Lampe.TAILLE,
					this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage,this.t.getLampes()[i].getX()+decalage,
					this.t.getLampes()[i].getX(),this.t.getLampes()[i].getX()};
			int[] y={this.t.getLampes()[i].getY(),this.t.getLampes()[i].getY(),
					this.t.getLampes()[i].getY()+decalage,this.t.getLampes()[i].getY()-decalage+Lampe.TAILLE,
					this.t.getLampes()[i].getY()+Lampe.TAILLE,this.t.getLampes()[i].getY()+Lampe.TAILLE,
					this.t.getLampes()[i].getY()-decalage+Lampe.TAILLE,this.t.getLampes()[i].getY()+decalage};

			//Si elle est allume, on applique un degrade centre vert clair
			if(this.t.getLampes()[i].getAllume()){
				//Polygone
				g.setColor(new Color(0,250,0));
				g.fillPolygon(x,y,8);
				g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),decalage*2,decalage*2);
				g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY(),decalage*2,decalage*2);
				g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
				g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
				
				//Degrade
				for(int j=Lampe.TAILLE/2-decalage/2;j>0;j--){
					int v=125;
					Color coul=new Color(0,v+3*j,0);
					g.setColor(coul);
					g.fillRect((this.t.getLampes()[i].getX()+Lampe.TAILLE)-Lampe.TAILLE/2-j,(this.t.getLampes()[i].getY()+Lampe.TAILLE)-Lampe.TAILLE/2-j,j*2,j*2);
				}
			}

			//Sinon on applique un degrade centre vert fonce
			else{
				//Polygone
				g.setColor(new Color(0,130,0));
				g.fillPolygon(x,y,8);
				g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),decalage*2,decalage*2);
				g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY(),decalage*2,decalage*2);
				g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
				g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
				
				//Degrade
				for(int j=Lampe.TAILLE/2-decalage/2;j>0;j--){
					int v=5;
					Color coul=new Color(0,v+3*j,0);
					g.setColor(coul);
					g.fillRect((this.t.getLampes()[i].getX()+Lampe.TAILLE)-Lampe.TAILLE/2-j,(this.t.getLampes()[i].getY()+Lampe.TAILLE)-Lampe.TAILLE/2-j,j*2,j*2);
				}
			}	
		}
		
		//Si c'est gagne, on ajoute un affichage
		if(this.t.getGagne()){
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Verdana", Font.BOLD, 28));
			g.drawString("Vous avez gagne ! ",105,210);

			//On affiche le temps passe
			String txt;
			if((int)(t.getCompteur()/1000)<2){
				txt = "Temps : "+(int)(t.getCompteur()/1000)+" seconde !";
				g.drawString(txt,90,260);
			}
			else{
				txt = "Temps : "+(int)(t.getCompteur()/1000)+" secondes !";
				g.drawString(txt,80,260);
			}

			//On affiche le nombre de clics
			if(this.t.getNbClic()<10){
				g.drawString("Nombre de clic : "+this.t.getNbClic()+" !",95,310);
			}
			else{
				if(this.t.getNbClic()>=10 && this.t.getNbClic()<100){
					g.drawString("Nombre de clic : "+this.t.getNbClic()+" !",85,310);
				}
				else{
					g.drawString("Nombre de clic : "+this.t.getNbClic()+" !",80,310);
				}
			}
			t.setGagne();
			t.setMode("gagne");
		}
    }
}
