import processing.core.PApplet;
public class Worker extends Person{

  public Worker(double x, double y)
  {
    super(x,y);
  }
  public void draw(PApplet drawer, float x, float y)
  {
    super.draw(drawer,x,y);
    drawer.fill(0);
    drawer.ellipse(x-10,y-10,20,20);
  }
}
