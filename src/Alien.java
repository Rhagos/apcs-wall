import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import processing.core.PApplet;
/**
 * This class represents an alien which is the base for all enemies in the game 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/

public class Alien extends Entity{
	
	private double HP;
	private double maxHP;
	/**
	 * 	Creates a default instance of Alien with a given position and set dimensions of 30x20
	 * 	@param x x-coordinate of the alien
	 * 	@param y y-coordinate of the alien
	 * */
	  public Alien(double x, double y)
	  {
		  super("Dungeon Floor Updated/Wall_5.png", (int) x, (int) y, 30, 20);
	    
	  }
	  
	  /**
	   * Moves the alien towards the wall
	   * @param p Player object containing the other objects
	   */
	  public void act(Player p){
		  Wall targetWall = p.getWall();
		  WallPiece target = getClosest(targetWall);
		  if(target != null){
			  if(distanceTo(new Person(target.getX(),target.getY())) < 60){
				  target.damageWall(10);
			  }else{
				  move((int)(-1 *directionTo(new Person(target.getX(),target.getY()))), 2);
			  }
		  }
	  }
	  
	  public WallPiece getClosest(Wall w){
		  double maxDist = Integer.MAX_VALUE;
		  WallPiece target = new WallPiece(999,999,999);
		  for(int i = 0; i < w.getWallParts().size(); i++){
			  WallPiece temp = w.getWallParts().get(i);
			  if(temp != null)
			  if(distanceTo(new Person(temp.getX(),temp.getY())) < maxDist){
				  maxDist = distanceTo(new Person(target.getX(),target.getY()));
				  target = w.getWallParts().get(i);
			  }
		  }
		  return target;
	  }
}