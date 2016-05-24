import java.awt.Color;

import javax.swing.ImageIcon;

/** 
 *  This class represents a worker who is a typer Person and thus has all of Person qualities
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class Worker extends Person{
	private int patrolDir;
	private int patrolTimer;
/**
 *  Creates a Worker with default parameters at x and y 
 *	@param x x-coordinate of the worker
 * 	@param y y-coordinate of the worker
 * */
  public Worker(double x, double y)
  {
    super("WorkerSprites/Worker_1.png",x,y);
    patrolDir = 0;
    patrolTimer = 0;
  }
  
  public String getType(){
	  return "Worker";
  }
  
  /**
   * Repairs the target wall piece
   * @param w WallPiece that is to be repaired
   * @pre w is damaged and not null
   */
  public void repair(WallPiece w){
	  w.healWall(getLevel() * 10);
	  addXP(50);
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
		  if(distanceTo(new Person(null,target.getX(),target.getY())) <= 60){
			  repair(target);
		  }else{
			  if(!move((int)directionTo(new Person(null,target.getX(),target.getY())), 5,p)){
				  move(patrolDir,5,p);
				  patrolTimer++;
				  if(patrolTimer >= 25){
					  patrolDir += 90;
					  patrolTimer = 0;
				  }
			  }
		  }
	  }
	 
  }

}
