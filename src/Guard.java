import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import processing.core.PApplet;
/** 
 *  This class represents a guard who is a typer Person and thus has all of Person qualities
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class Guard extends Person{
	public static final int PATROL_TIME = 100;
	private int patrolDir;
	private int patrolTimer;

/**
 *  Createss a Guard with default parameters at x and y 
 *	@param x x-coordinate of the guard
 * 	@param y y-coordinate of the guard
 * */
  public Guard(double x, double y){
    super("Dungeon Floor Updated/Wall_7.png",x,y);
    patrolDir = 0;
    patrolTimer = 0;
  }
	/**
	 *  Checks to see if an alien is within a set range of the Guard object 
	 * */
  public boolean inRange()
  {
    return false;
  }
    public Image getImage()
  {
	  return new ImageIcon("GuardSprite/Guard_1.png").getImage();
	  
  }
  /**
   * Moves the guard towards the aliens
   * @param pl Player object containing the other objects
   */
  public void act(Player pl){
	  super.act(pl);
	  Alien target = getClosest(pl);
	  if(target!= null)
	  if(distanceTo(target) < 65){
		  target.setHP(target.getHP()-50);
		  System.out.println(target.getHP());
	  }
	  if(target != null)
		  move((int)(-1 * directionTo(target)),5);
	  else{
		  move(patrolDir,5);
		  patrolTimer++;
		  if(patrolTimer >= PATROL_TIME){
			  patrolDir += 90;
			  patrolTimer = 0;
		  }
	  }
	  
	  
  }
  public Alien getClosest(Player pl){
	  Alien[][] grid = pl.getEnemies();
	  ArrayList<Alien> aliens = new ArrayList<Alien>();
	  for(int i = -50; i < 50; i++){
		  for(int j = -50; j < 50; j++){
			  

			  if(getY() + j >=0 && getY() + j < 500 && getX() + i >= 0 && getX()+i < 500){
				if(grid[(int) (i + getX())][(int) (j + getY())] != null)
				aliens.add(grid[(int) (i + getX())][(int) (j + getY())]);
			  }
			  else{
				  continue;
			  }
			  
		  }
	  }
	  double minDist = Integer.MAX_VALUE;
	  Alien target = null;
	  for(int i = 0; i < aliens.size(); i++){
		  Alien ay = aliens.get(i);
		  if(distanceTo(ay) < minDist){
			  target = ay;
		  }
	  }
	  return target;
  }

}
