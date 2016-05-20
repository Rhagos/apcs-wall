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
  private int level;
  private int xp;
  private int threshold;
  
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
    level = 0;
    xp = 0;
    threshold = 1000;
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
    locX += Math.cos(Math.toRadians(dir)) * distance;
    locY += Math.sin(Math.toRadians(dir)) * distance;
    
  }

  
  /**
   * Returns x-coord
   * @return returns x-coord
   */
  public double getX(){
	  return locX;
  }
  /**
   * Returns y-coord
   * @return returns y-coord
   */
  public double getY(){
	  return locY;
  }
  
  /**
   * Sets a value to the x-coord
   * @param x new x value
   */
  public void setX(double x){
	  locX = x;
  }

  /**
   * Sets a value to the y-coord
   * @param y new y value
   */
  public void setY(double y){
	  locY = y;
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
  /**
   * Returns the current level of the person
   * @return current level of the person
   */
  public int getLevel(){
	return level;  
  }
  /**
   * Adds experience to the person
   * @param xp Amount of experience added
   * @pre xp is a nonnegative amount
   */
  public void addXP(int exp){
	  xp += exp;
  }
  /**
   * Performs the action that the person is designed to do
   */
  public void act(Player p){
	  if(xp > threshold){
		  level += 1;
		  xp = 0;
		  System.out.println("Level " + level);
	  }
  }
  /**
   * Gets the direction to the target
   * @param p Person that is the target
   * @return direction in degrees
   */
  public double directionTo(Person p){
	  double angle = Math.toDegrees(Math.atan2(p.getX() - getX(), p.getY() - getY()));
	  if(p.getX() > getX()){
		  if(p.getY() > getY()){
			  angle += 180;
		  }
		  angle *= -1;
		  angle += 180;
	  }
	  return angle;
  }
  
  /**
   * Gets the distance to the target
   * @param p target person
   * @return distance between the two
   */
  public double distanceTo(Person p){
	  return Math.sqrt(Math.pow(p.getX() - getX(), 2) + Math.pow(p.getY() - getY(), 2));
  }
  
  /**	Draws a new instance of a Person object with the origin set at x,y 
   * 	@param drawer the PApplet used to draw the Person
   *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
   * */
   public void draw(PApplet drawer)
   {
	 drawer.stroke(0);
	 drawer.noFill();
	 drawer.ellipse((float)locX,(float)locY,(float)30,(float)30); 
	}
}
