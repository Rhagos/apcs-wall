import java.awt.Color;

import processing.core.PApplet;
/** 
 *  This class represents a worker who is a typer Person and thus has all of Person qualities
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class Worker extends Person{

/**
 *  Creates a Worker with default parameters at x and y 
 *	@param x x-coordinate of the worker
 * 	@param y y-coordinate of the worker
 * */
  public Worker(double x, double y)
  {
    super(x,y);
  }
  
  /**
   * Repairs the target wall piece
   * @param w WallPiece that is to be repaired
   * @pre w is damaged and not null
   */
  public void repair(WallPiece w){
	  w.healWall(getLevel() * 10);
	  addXP(10);
  }
  /**
   * Moves the worker towards the wall
   * @param p Player object containing the other objects
   */
  public void act(Player p){
	  Wall targetWall = p.getWall();
	  WallPiece target = targetWall.getDamaged();
	  move(-1* directionTo(new Person(0,200)), 5);
  }
  
 /**	Draws a new instance of a Person object with the origin set at x,y 
  * 	@param drawer the PApplet used to draw the Person
  *    @pre drawer must not be null and appropriate settings should already be initialized (color, fill,etc)
  **/
  public void draw(PApplet drawer)
  {
    super.draw(drawer);
    drawer.fill(Color.YELLOW.getRGB());
    drawer.ellipse((float)getX()-10,(float)getY()-10,20,20);
  }
}
