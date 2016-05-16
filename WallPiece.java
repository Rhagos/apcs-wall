
import java.awt.Color;
/** 
 *  This class represents a piece of the wall which forms an arraylist for the Wall class
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class WallPiece{
  public static final double MAX_HP = 10000;
  private double hp;
  /** 
   *  Wallpiece constructor sets up the default HP value for each part of wall
   * */
  public WallPiece()
  {
    hp = MAX_HP;
  }
  /**
   *  GetHp returns the curret HP of the Wallpiece
   * */
  public double getHP(){
    return hp;
  }
   /**	Draws a new instance of a Wallpiece object with the origin set at x,y 
  * 	 @param drawer the PApplet used to draw the Wallpiece
  *    @pre drawer must not be null and appropiate settings should already be initialized (color, fill,etc)
  **/
  public void draw(PApplet drawer, float x, float y){
    drawer.line(Color.RED.getRGB());
    drawer.fill(Color.LIGHT_GRAY.getRGB());
    drawer.rect(x,y,50,50);
  }
}
