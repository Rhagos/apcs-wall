import processing.core.PApplet;
public class Guard extends Person{

  public Guard(double x, double y){
    super(x,y);
  }
  
  public boolean inRange()
  {
    
  }
  public void draw(PApplet drawer, float x, float y){
    super.draw(drawer,x,y);
    drawer.fill(0);
    drawer.rect(x-10,y-10,20,20);
  }
}
