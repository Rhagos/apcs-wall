import java.util.ArrayList;
public class Person
{
  private double locX;
  private double locY;
  private ArrayList<String> taskQueue;
  private double HP;
  
  public Person(double x, double y)
  {
    locX = x;
    locY = y;
    taskQueue = new ArrayList<String>();
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
      
    }
  }
  public double getHP(){
    return HP;
  }
  public void setHP(double health){
    HP = health;
  }
  
}
