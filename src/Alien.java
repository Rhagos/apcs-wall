import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * This class represents an alien of type entity which is the base for all enemies in the game 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/

public class Alien extends Entity{
	/**
	 * 	Creates a default instance of Alien with a given position and set dimensions of 30x20
	 * 	@param string filename of the image
	 * 	@param x x-coordinate of the alien
	 * 	@param y y-coordinate of the alien
	 *      @param w sets the width
	 *      @param l sets the length 
	 * */
	  public Alien(String string, double x, double y, double w, double l) {
		  super(string,(int)x,(int)y,(int)w,(int)l);
	  }

	/**
	 *  Sets the default image for Alien type objects
	 * */
	  public Image getImage()
	  {
		  return new ImageIcon("AlienSprite/Alien_1.png").getImage();
		  
	  }
	
	  
}
