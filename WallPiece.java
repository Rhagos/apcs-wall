
import java.awt.Color;

public class WallPiece{
  public static final double MAX_HP = 10000;
  private double hp;
  public WallPiece()
  {
    hp = MAX_HP;
  }
  public double getHP(){
    return hp;
  }
  public void draw(PApplet drawer, float x, float y){
    drawer.line(Color.RED.getRGB());
    drawer.fill(Color.LIGHT_GRAY.getRGB());
    drawer.rect(x,y,50,50);
  }
}
