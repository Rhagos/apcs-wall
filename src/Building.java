
/**
 * This class represents an building of type entity and serves as a platform to construct person specific or alien specific buildings
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/
public class Building extends Entity{

	/**
	 * 	Constructs a building with a default image, XCoord, YCoord, width, and height
	 * */
	public Building(String image, int x, int y, int w, int h) {
		super(image, x, y, w, h);
	}
	/**
	 * 	Allows a structure to take damage 
	 * 	@param dmg amount of damage building has taken
	 * */
	public void damage(double dmg){
		setHP(getHP() - dmg);
	}
}
