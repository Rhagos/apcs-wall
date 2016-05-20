import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
/**
 * This class represents an alien which is the base for all enemies in the game 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/

public class Alien extends Person{
	
	  private double locX;
  	  private double locY;
	  private int defaultX;
	  private int defaultY;
	  private int defaultW;
	  private int defaultH;
/**
 * 	Creates a default instance of Alien with a default position as well as starting a tastqueu for the person
 * 	and setting the default hiringprice to 200
 * 	@param x x-coordinate of the alien
 * 	@param y y-coordinate of the alien
 * */
	  public Alien(double x, double y)
	  {
		super(x,y);
	    locX = x;
	    locY= y;
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
				  move(-1 *directionTo(new Person(target.getX(),target.getY())), 2);
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
	  
   /**	Draws a new instance of a Alien object with the origin set at x,y 
   * 	@param drawer the PApplet used to draw the Alien
   *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
   * */
	public void draw(PApplet drawer)
	{
		drawer.stroke(0);
		drawer.fill(Color.ORANGE.getRGB());
		 drawer.ellipse((float)getX(),(float)getY(),20,30); 
		}
}
