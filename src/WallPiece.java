
import java.awt.Color;

import processing.core.PApplet;
/** 
 *  This class represents a piece of the wall which forms an arraylist for the Wall class
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class WallPiece{
  public static final double MAX_HP = 10000;
  private double hp;
  private double x,y;
  /** 
   *  Wallpiece constructor sets up the default HP value for each part of wall
   * */
  public WallPiece(double x, double y)
  {
    hp = MAX_HP;
    this.x = x;
    this.y = y;
  }
  /**
   *  GetHp returns the curret HP of the Wallpiece
   *  @return returns the current health of the wall piece
   * */
  public double getHP(){
    return hp;
  }
  
  /**
   * Adds health to the wall piece
   * @param h hp that is added to the wall piece's current health
   * @pre h is a non-negative number
   * @post the hp of the wall will be higher than before but not higher than the MAX_HP
   */
  public void healWall(double h){
	  hp += h;
	  if(hp > MAX_HP)
		  hp = MAX_HP;
  }
  
  /**
   * Gets the direction to the target
   * @param p Person that is the target
   * @return direction in degrees
   */
  public double directionTo(Person p){
	  return Math.toDegrees(Math.atan2(p.getX() - x, p.getY() - y));
  }
  
  /**
   * Gets the distance to the target
   * @param p target person
   * @return distance between the two
   */
  public double distanceTo(Person p){
	  return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
  }
  
   /**	Draws a new instance of a Wallpiece object with the origin set at x,y 
  * 	 @param drawer the PApplet used to draw the Wallpiece
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(PApplet drawer, float x, float y){
    drawer.stroke(Color.RED.getRGB());
    drawer.fill(Color.LIGHT_GRAY.getRGB());
    drawer.rect(x,y,50,50);
  }
}
