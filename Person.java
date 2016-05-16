import java.util.ArrayList;

import processing.core.PApplet;
public class Person
{
  
  private ArrayList<String> taskQueue;
  private double HP;
  private double hiringPrice;
  private double locX;
  private double locY;
  private int defaultX;
  private int defaultY;
  private int defaultW;
  private int defaultH;
  
  public Person(double x, double y)
  {
    locX = x;
    locY = y;
    taskQueue = new ArrayList<String>();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    hiringPrice = 200;
  }
  public void move(double dir, double distance)
  {
    //Timer in main thread
    locX = Math.cos(dir) * distance;
    locY = Math.sin(dir) * distance;
  }
  public void addQueue(String task)
  {
    taskQueue.add(task);
  }
  public void processQueue()
  {
    for(String s:taskQueue)
    {
    	if(s.equals("")){
    		addQueue(s);
    	}
    }
  }
  public double getHP(){
    return HP;
  }
  public void setHP(double health){
    HP = health;
  }
  public double getPrice(){
	  return hiringPrice;
  }
   public void draw(PApplet drawer, float x, float y)
   {
	 drawer.stroke(0);
	 locX = x; 
	 locY = y; 
		// float yRatio = drawer.height/500f; // float can be either cast via (float) or f behind the integer
		// float xRatio = drawer.width/500f; // java sees 500 as an automatic int type
		// drawer.scale(xRatio,yRatio)
		
		
	 drawer.ellipse(locX,locY,30,30); 
	     //drawer.popMatrix();
	}
  
}
