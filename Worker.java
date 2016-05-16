import processing.core.PApplet;
/** 
 *  This class represents a worker who is a typer Person and thus has all of Person qualities
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class Worker extends Person{

/**
 *  Createss a Worker with default parameters at x and y 
 *	@param x x-coordinate of the worker
 * 	@param y y-coordinate of the worker
 * */
  public Worker(double x, double y)
  {
    super(x,y);
  }
 /**	Draws a new instance of a Person object with the origin set at x,y 
  * 	@param drawer the PApplet used to draw the Person
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(PApplet drawer, float x, float y)
  {
    super.draw(drawer,x,y);
    drawer.fill(0);
    drawer.ellipse(x-10,y-10,20,20);
  }
}
