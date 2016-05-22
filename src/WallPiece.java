
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

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
  private boolean destroyed;
  private Wall wall;
  /** 
   *  WallPiece constructor sets up the default HP value for each part of wall
   * */
  public WallPiece(double x, double y, int pieceNum, Wall w)
  {
    hp = MAX_HP;
    this.x = x;
    this.y = y;
    destroyed = false;
    num = pieceNum;
    wall = w;
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
	  if(hp <= -30 && !destroyed){
		  destroyWall();
	  }
  }
  
  public void destroyWall(){
	  if(wall.getWallParts().contains(this)){
		  wall.getWallParts().add(num, null);
   		  wall.getWallParts().remove(num+1);
	  }
  }

  public double getX(){
	  return x;
  }
  public double getY(){
	  return y;
  }
  
  public Image getImage(){
	  if(hp > 7500){
		  return new ImageIcon("Dungeon Floor Updated/Wall_1.png").getImage();
	  }
	  if(hp > 5000){
		  return new ImageIcon("Dungeon Floor Updated/Wall_2.png").getImage();
	  }
	  if(hp > 2500){
		  return new ImageIcon("Dungeon Floor Updated/Wall_3.png").getImage();
	  }
	  else{
		  return null;
	  }
  }
   /**	Draws a new instance of a Wallpiece object with the origin set at x,y 
  * 	 @param drawer the PApplet used to draw the Wallpiece
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(Graphics2D drawer, ImageObserver io){
	  drawer.drawImage(getImage(), (int)getX(), (int)getY(), 50, 50, io);
    
  }
}