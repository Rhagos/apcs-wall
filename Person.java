import java.util.ArrayList;
import processing.core.PApplet;
/**
 * This class represents a person which is the base for all people in the game 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/

 
public class Person
{
  
  private ArrayList<String> taskQueue;
  private double HP;
  private double hiringPrice;
  private double locX;
  private double locY;
  private int defaultX;
  private int defaultY;
  private int defaultW;
  private int defaultH;
  
/**
 * 	Creates a default instance of Person with a default position as well as starting a tastqueu for the person
 * 	and setting the default hiringprice to 200
 * 	@param x x-coordinate of the person
 * 	@param y y-coordinate of the person
 * */
  public Person(double x, double y)
  {
    locX = x;
    locY = y;
    taskQueue = new ArrayList<String>();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    hiringPrice = 200;
  }
  /**
   * Moves the person to a new location by changing the x and y coordinate given an angle and distance 
   * Person needs to move
   * @param dir angle that the person changes in angle 
   * @param distance length that the person moves 
   * */
  public void move(double dir, double distance)
  {
    //Timer in main thread
    locX = Math.cos(dir) * distance;
    locY = Math.sin(dir) * distance;
  }
  /**
   * Adds on tasks that are then followed in sequential order that the Person recieves them in
   * @param task specific task the person needs to complete at when it reaches the end of the taskqueue
   * */
  public void addQueue(String task)
  {
    taskQueue.add(task);
  }
  /**
   * Person goes through the specific tasks and adds more if it reaches the end as denoted by a null string
   * */
  public void processQueue()
  {
    for(String s:taskQueue)
    {
    	if(s.equals("")){
    		addQueue(s);
    	}
    }
  }
  /**
   *  Returns the current HP of the person
   * */
  public double getHP(){
    return HP;
  }
  /**
   *  Sets the HP of the person
   *  @param health specific double value Person is set to
   * */
  public void setHP(double health){
    HP = health;
  }
  
  /**
   *  Returns the hiringPrice of the person
   * */
  public double getPrice(){
	  return hiringPrice;
  }
  /**	Draws a new instance of a Person object with the origin set at x,y 
   * 	@param drawer the PApplet used to draw the Person
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
		
		
	 drawer.ellipse((float)locX,(float)locY,(float)30,(float)30); 
	     //drawer.popMatrix();
	}
  
}
