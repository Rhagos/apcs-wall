import java.util.ArrayList;

import processing.core.PApplet;

public class Alien extends Person{
	 
	  private double locX;
	  private double locY;
	  private int defaultX;
	  private int defaultY;
	  private int defaultW;
	  private int defaultH;
	  
	  public Alien(double x, double y)
	  {
		super(x,y);
	    locX = x;
	    locY= y;
	  }
	   public void draw(PApplet drawer, float x, float y)
	   {
		 drawer.stroke(0);
		 locX = x; 
		 locY = y; 
			// float yRatio = drawer.height/500f; // float can be either cast via (float) or f behind the integer
			// float xRatio = drawer.width/500f; // java sees 500 as an automatic int type
			// drawer.scale(xRatio,yRatio)
			
			
		 drawer.ellipse(defaultX,defaultY,defaultW,defaultH); 
		     //drawer.popMatrix();
		}
}

