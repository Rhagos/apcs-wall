import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

public abstract class Entity extends MovingImage{
	
	private double HP;
	private int level;
	private int xp;
	private int threshold;
	public Entity(String img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		level = 0;
		xp = 0;
		threshold = 1000;
	}

 
  /**
   * Moves the entity to a new location by changing the x and y coordinate given an angle and distance 
   * Person needs to move
   * @param dir angle that the person changes in angle 
   * @param distance length that the person moves 
   * */
	public void move(int dir, int dist) {
		moveByAmount(Math.cos(Math.toRadians(dir)) * dist ,Math.sin(Math.toRadians(dir)) * dist);
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
	public abstract void act(Player p);
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
		return Math.sqrt(Math.pow(e.getX() - getX(), 2) + Math.pow(e.getY() - getY(), 2));
	}
	/**
	 * Gets the direction to the target
	 * @param p Person that is the target
	 * @return direction in degrees
	 */
	public double directionTo(Entity e) {
		double angle = Math.toDegrees(Math.atan2(e.getX() - getX(), e.getY() - getY()));
		  if(e.getX() > getX()){
			  if(e.getY() > getY()){
				  angle += 180;
			  }
			  angle *= -1;
			  angle += 180;
		  }
		  if(e.getY() == getY()){
			  if(getX() < e.getX()){
				  angle = 0;
			  }
			  else{
				  angle = 180;
			  }
		  }
		  return angle;
	}
	  
}
