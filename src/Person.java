import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
/**
 * This class represents a person which is the base for all people in the game 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/

 
public class Person extends Entity
{
  private double hiringPrice;
  private int level;
  private int xp;
  private int threshold;
  
/**
 * 	Creates a default instance of Person with a default position as well as starting a tastqueu for the person
 * 	and setting the default hiringprice to 200
 * 	@param x x-coordinate of the person
 * 	@param y y-coordinate of the person
 * */
  public Person(String image,double x, double y)
  {
	  super(image,(int)x,(int)y,30,30);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	  hiringPrice = 200;
	  level = 0;
	  xp = 0;
	  threshold = 1000;
  }
  
  /**
   *  Returns the hiringPrice of the person
   */
  public double getPrice(){
	  return hiringPrice;
  }
  
  public String getType(){
	  return "Person";
  }
  
  /**
   * Performs the action that the person is designed to do
   */
  public void act(Player p){
	  super.act(p);
	  if(xp > threshold){
		  level += 1;
		  xp = 0;
		  System.out.println("Level " + level);
		  threshold += level * 1000;
	  }
  }
   
}