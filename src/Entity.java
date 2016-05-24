import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
/**
 * This class represents a Entity of type MovingImage serves as the base for all buildings, person, and alien objects
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/
public abstract class Entity extends MovingImage{
	
	private double HP;
	private int level;
	private int xp;
	private int threshold;
	private boolean dead;
	private String imageLink;
	/**
	 *   Constructs a entity with a default image, xCoord, yCoord, width, and height 
	 *  @param image sets the image 
	 *  @param x sets the XCoord
	 *  @param y sets the YCoord
	 *  @param w sets the width
	 *  @param h sets the height
	 * */
	public Entity(String image, int x, int y, int w, int h) {
		super(image, x, y, w, h);
		imageLink = image;
		HP = 200;
		level = 1;
		xp = 0;
		threshold = 1000;
		dead = false;
	}

	/**
	 *  Returns the current life status of the entity
	 * */
	public boolean getLifeStatus(){
		return dead;
	}
 	/**
 	 *   Sets the entity to decrease house based on damage inputed
 	 *  @param damage sets the amount of damage taken 
 	 * */
	public void takeDamage(double damage){
		HP -= damage;
	}
  /**
   * Moves the entity to a new location by changing the x and y coordinate given an angle and distance 
   * Person needs to move
   * @param dir angle that the person changes in angle 
   * @param distance length that the person moves 
   * @return returns false if the unit is unable to move
   * */
	public boolean move(int dir, int dist, Player p) {
		boolean moveable = true;
		double yDist = Math.sin(Math.toRadians(dir)) * dist;
		double xDist = Math.cos(Math.toRadians(dir)) * dist;
		MovingImage test = new MovingImage("", (int)(x+xDist),(int)(y+yDist),(int)width,(int)height);
		for(WallPiece wp: p.getWall().getWallParts()){
			if(wp != null)
				if(test.intersects(wp)){
					moveable = false;
				}
		}
		if(moveable)
			moveByAmount(xDist,yDist);
		
		return moveable;
	}
	/**
	 *  Returns the current HP of the person
	 */
	public double getHP() {
		return HP;
	}
	/**
	 *  Sets the HP of the person
	 *  @param health specific double value Person is set to
	 */
	public void setHP(double newHp) {
		HP = newHp;
	}
	
	/**
	 * Returns the current level of the person
	 * @return 
	 * @return current level of the person
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * Performs the action that the person is designed to do
	 */
	public void act(Player p){
		if(HP <= 0){
			if(this instanceof Alien){
				p.removeEnemy((Alien)this);
				p.changeFunds(25);
			}
			if(this instanceof Person){
				p.removeFriendly((Person)this);
			}
			dead = true;
		}
	}
	/**
	 * Adds experience to the person
	 * @param xp Amount of experience added
	 * @pre xp is a nonnegative amount
	 */
	public void addXP(int amt){
		xp += amt;
	}
	
	/**
	 * Gets the distance to the target
	 * @param p target person
	 * @return distance between the two
	 */
	public double distanceTo(Entity e){
		return Math.sqrt(Math.pow(e.getCenterX() - getCenterX(), 2) + Math.pow(e.getCenterY() - getCenterY(), 2));
	}
	/**
	 * Gets the direction to the target
	 * @param p Person that is the target
	 * @return direction in degrees
	 */
	public double directionTo(Entity e) {
		double angle = Math.toDegrees(Math.atan2( e.getCenterY() - getCenterY(),e.getCenterX() - getCenterX()));
		return angle;
	}

	  
}
