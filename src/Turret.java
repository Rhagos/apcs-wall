import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * This class represents a turret of type WallPiece 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/
public class Turret extends WallPiece{
	/**
	 *   Constructs a turret object with a changable X,Y Coords, Piecenum, 
	 *   @param xCoord sets the turret at this xCoord
	 *   @param yCoord sets the turret at this yCoord 
	 *   @param pieceNam onto which piece it is on 
	 *   @param w what number wall it is 
	 * */
	public Turret(double x, double y, int pieceNum, Wall w) {
		super(x, y, pieceNum, w);
		// TODO Auto-generated constructor stub
	}
	/**
	 *  Shooots at aliens
	 *  @param p type player objects 
	 * */
	public void act(Player p){
		super.act(p);
		for(int i = 0; i < p.getEnemy().size(); i++){
			Alien a = p.getEnemy().get(i);
			if(distanceTo(a) < 100){
				a.takeDamage(1);
			}
		}
	}
	
	/**
	 *  Returns image of Turret
	 * */
	public Image getImage(){
		return new ImageIcon("Dungeon Floor Updated/Wall_9.png").getImage();
	}

}
