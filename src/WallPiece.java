
import java.awt.Color;

import processing.core.PApplet;
/** 
 *  This class represents a piece of the wall which forms an arraylist for the Wall class
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class WallPiece{
  public static final double MAX_HP = 10000;
  private double hp;
  private double x,y;
  private int num;
  /** 
   *  Wallpiece constructor sets up the default HP value for each part of wall
   * */
  public WallPiece(double x, double y, int pieceNum)
  {
    hp = MAX_HP;
    this.x = x;
    this.y = y;
    num = pieceNum;
  }
  /**
   *  GetHp returns the curret HP of the Wallpiece
   *  @return returns the current health of the wall piece
   * */
  public double getHP(){
    return hp;
  }
  
  /**
   * Adds health to the wall piece
   * @param h hp that is added to the wall piece's current health
   * @pre h is a non-negative number
   * @post the hp of the wall will be higher than before but not higher than the MAX_HP
   */
  public void healWall(double h){
	  hp += h;
	  if(hp > MAX_HP)
		  hp = MAX_HP;
  }
  
  public void damageWall(double d){
	  hp -= d;
	  if(hp <= -30){
		  destroyWall(DrawingSurface.pl);
	  }
  }
  
  public void destroyWall(Player p){
	  if(p.getWall().getWallParts().contains(this)){
		  p.getWall().getWallParts().add(num, null);
		  p.getWall().getWallParts().remove(num+1);
	  }
  }

  public double getX(){
	  return x;
  }
  public double getY(){
	  return y;
  }
   /**	Draws a new instance of a Wallpiece object with the origin set at x,y 
  * 	 @param drawer the PApplet used to draw the Wallpiece
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(PApplet drawer, float x, float y){
    drawer.stroke(Color.RED.getRGB());
    drawer.fill(Color.LIGHT_GRAY.getRGB());
    drawer.rect(x,y,50,50);
  }
}
