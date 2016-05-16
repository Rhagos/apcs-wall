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
   /**	Draws a new instance of a Alien object with the origin set at x,y 
   * 	@param drawer the PApplet used to draw the Alien
   *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
   * */
	public void draw(PApplet drawer, float x, float y)
	{
	drawer.stroke(0);
	 locX = x; 
	 locY = y;
		 
	// float yRatio = drawer.height/500f; // float can be either cast via (float) or f behind the integer
	// float xRatio = drawer.width/500f; // java sees 500 as an automatic int type
	// drawer.scale(xRatio,yRatio)

	 drawer.ellipse(x,y,20,30); 
	 //drawer.popMatrix();
		}
}

