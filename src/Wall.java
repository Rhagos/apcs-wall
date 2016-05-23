import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import processing.core.PApplet;
/** 
 *  This class represents a Wall which is made up of Wallpieces 
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class Wall{
  private ArrayList<WallPiece> wall;
  private double wallX;
  private double wallY;
  private static int numbers;
  /** 
   *  Wall by default sets the start of the wall with WallX and end of the wall with WallY as well as set the wall as an array
   *  made of wallpieces
   * */
  public Wall()
  {
    wall = new ArrayList<WallPiece>();
    wallX = 0;
    wallY = 200;
    numbers = 0;
  }
  /**
   *  Builds a wall piece at the end of the wall
   * */
  public void buildWall()
  {
	WallPiece tenfeethigher = new WallPiece(wall.size() * 50 + wallX, wallY, numbers,this);
	numbers++;
	wall.add(tenfeethigher);
  }
  /** 
   *  Returns the most damaged wallpiece by comparing from the start of the Wallpiece Array the damaged parts of each individual 
   * wallpiece until the end of the program 
   * */
  public WallPiece getDamaged()
  {
    double lowestHP = WallPiece.MAX_HP;
    WallPiece damaged = null;
    for(int i = 0; i < wall.size(); i++)
    {
		WallPiece w = wall.get(i);
		if(w != null)
		if(w.getHP() <= lowestHP){
		    lowestHP = w.getHP();
		    damaged = w;
		}
    }
    return damaged;  
  }
  
  public ArrayList<WallPiece> getWallParts(){
	  return wall;
  }
  public int getUpperBound(){
	  return (int) (wallY - 50);
  }
  public int getLowerBound(){
	  return (int) (wallY + 50);
  }
  public int getLeftBound(){
	  return (int) (wallX - 50);
  }
  public int getRightBount(){
	  return (int) (wallX + 50*wall.size());
  }
   /**	Draws a new instance of a Wall object with the position starting at Wallx and running till WallY
  *   	@param drawer the PApplet used to draw the Wall by running through al the Wallpieces and initializing them in a line
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(Graphics2D g, ImageObserver io){
    for(int i = 0; i < wall.size(); i++){
    	if(wall.get(i)	!= null)
    		wall.get(i).draw(g, io);
    }
  }

  
}