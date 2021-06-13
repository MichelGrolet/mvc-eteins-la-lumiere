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
	*/
	@Override
	public void update(Observable o, Object arg){
		repaint();
	}

	/**
	* Permet de dessiner le modele
	*/
	@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

		//if(!this.t.getGagne() || this.t.modeValeur("configuration") || this.t.modeValeur("inactif")){
			//On dessine un carre pour chaque lampes,
			
			for(int i=0;i<25;i++){
				int[] x={this.t.getLampes()[i].getX()+decalage,this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage,
						this.t.getLampes()[i].getX()+Lampe.TAILLE,this.t.getLampes()[i].getX()+Lampe.TAILLE,
						this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage,this.t.getLampes()[i].getX()+decalage,
						this.t.getLampes()[i].getX(),this.t.getLampes()[i].getX()};
				int[] y={this.t.getLampes()[i].getY(),this.t.getLampes()[i].getY(),
						this.t.getLampes()[i].getY()+decalage,this.t.getLampes()[i].getY()-decalage+Lampe.TAILLE,
						this.t.getLampes()[i].getY()+Lampe.TAILLE,this.t.getLampes()[i].getY()+Lampe.TAILLE,
						this.t.getLampes()[i].getY()-decalage+Lampe.TAILLE,this.t.getLampes()[i].getY()+decalage};

				if(this.t.getLampes()[i].getAllume()){
					g.setColor(new Color(0,250,0));
					g.fillPolygon(x,y,8);
					g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),decalage*2,decalage*2);
					g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY(),decalage*2,decalage*2);
					g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
					g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
				
				for(int j=Lampe.TAILLE/2-decalage/2;j>0;j--){
					int v=125;
					Color coul=new Color(0,v+3*j,0);
					g.setColor(coul);
					g.fillRect((this.t.getLampes()[i].getX()+Lampe.TAILLE)-Lampe.TAILLE/2-j,(this.t.getLampes()[i].getY()+Lampe.TAILLE)-Lampe.TAILLE/2-j,j*2,j*2);
				}
				}
				else{
					g.setColor(new Color(0,130,0));
					g.fillPolygon(x,y,8);
					g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY(),decalage*2,decalage*2);
					g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY(),decalage*2,decalage*2);
					g.fillOval(this.t.getLampes()[i].getX()+Lampe.TAILLE-decalage*2,this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
					g.fillOval(this.t.getLampes()[i].getX(),this.t.getLampes()[i].getY()+Lampe.TAILLE-decalage*2,decalage*2,decalage*2);
				
					for(int j=Lampe.TAILLE/2-decalage/2;j>0;j--){
						int v=5;
						Color coul=new Color(0,v+3*j,0);
						g.setColor(coul);
						g.fillRect((this.t.getLampes()[i].getX()+Lampe.TAILLE)-Lampe.TAILLE/2-j,(this.t.getLampes()[i].getY()+Lampe.TAILLE)-Lampe.TAILLE/2-j,j*2,j*2);
					}
				}	
			}
		
		if(this.t.getGagne()){
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Verdana", Font.BOLD, 28));
			String txt;
			if((int)(t.getCompteur()/1000)<2){
				txt = "Temps : "+(int)(t.getCompteur()/1000)+" seconde !";
			}
			else{
				txt = "Temps : "+(int)(t.getCompteur()/1000)+" secondes !";
			}
			g.drawString("Vous avez gagne ! ",100,200);
			g.drawString(txt,65,280);
			g.drawString("Nombre de clic : "+this.t.getNbClic()+" !",65,320);
			t.setGagne();
			t.setMode("inactif");
		}
    }
}
