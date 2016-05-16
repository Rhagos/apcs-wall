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
  /** 
   *  Wall by default sets the start of the wall with WallX and end of the wall with WallY as well as set the wall as an array
   *  made of wallpieces
   * */
  public Wall()
  {
    wall = new ArrayList<WallPiece>();
    wallX = 0;
    wallY = 50;
  }
  /**
   *  Wall adds on more wallpieces 
   *  @param wp of type Wallpiece represents a non damaged wallpiece being added to the wall at the end of WallY
   * */
  public void addPiece(WallPiece wp)
  {
    wall.add(wp);
  }
  /** 
   *  Returns the most damaged wallpiece by comparing from the start of the Wallpiece Array the damaged parts of each individual 
   * wallpiece until the end of the program 
   * */
  public WallPiece getDamaged()
  {
    double lowestHP = WallPiece.MAX_HP;
    WallPiece damaged = null;
    for(WallPiece w:wall)
    {
      if(w.getHP() < lowestHP){
        lowestHP = w.getHP();
        damaged = w;
      }
    }
    return damaged;
  }
   /**	Draws a new instance of a Wall object with the position starting at Wallx and running till WallY
  *   	@param drawer the PApplet used to draw the Wall by running through al the Wallpieces and initializing them in a line
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(PApplet drawer){
    for(int i = 0; i < wall.size(); i++){
      wall.get(i).draw(drawer, wallX + 50*i, wallY);
    }
  }

  
}
