import java.awt.Color;

import javax.swing.ImageIcon;

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
    super("Dungeon Floor Updated/Wall_9.png",x,y);
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
	  super.act(p);
	  Wall targetWall = p.getWall();
	  WallPiece target = targetWall.getDamaged();
	  if(target != null && target.getHP() < WallPiece.MAX_HP){
		  if(distanceTo(new Person(null,target.getX(),target.getY())) <= 10){
			  repair(target);
		  }else
			  move((int)directionTo(new Person(null,target.getX(),target.getY())), 5);
	  }
	 
  }

}
