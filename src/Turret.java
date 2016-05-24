import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Turret extends WallPiece{

	public Turret(double x, double y, int pieceNum, Wall w) {
		super(x, y, pieceNum, w);
		// TODO Auto-generated constructor stub
	}
	public void act(Player p){
		super.act(p);
		for(int i = 0; i < p.getEnemy().size(); i++){
			Alien a = p.getEnemy().get(i);
			if(distanceTo(a) < 100){
				a.takeDamage(1);
			}
		}
	}
	public Image getImage(){
		return new ImageIcon("Dungeon Floor Updated/Wall_9.png").getImage();
	}

}
