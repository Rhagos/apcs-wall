import processing.core.PApplet;
/** 
 *  This class represents a guard who is a typer Person and thus has all of Person qualities
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class Guard extends Person{

/**
 *  Createss a Guard with default parameters at x and y 
 *	@param x x-coordinate of the guard
 * 	@param y y-coordinate of the guard
 * */
  public Guard(double x, double y){
    super(x,y);
  }
/**
 *  Checks to see if an alien is within a set range of the Guard object 
 * */
  public boolean inRange()
  {
    return false;
  }
 /**	Draws a new instance of a Person object with the origin set at x,y 
  * 	@param drawer the PApplet used to draw the Person
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(PApplet drawer, float x, float y){
    super.draw(drawer,x,y);
    drawer.fill(0);
    drawer.rect(x-10,y-10,20,20);
  }
}
