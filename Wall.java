import java.util.ArrayList;

public class Wall{
  private ArrayList<WallPiece> wall;
  public Wall()
  {
    wall = new ArrayList<WallPiece>();
  }
  
  public void addPiece(WallPiece wp)
  {
    wall.add(wp);
  }
  public WallPiece getDamaged()
  {
    double lowestHP = WallPiece.MAX_HP;
    WallPiece damaged = null;
    for(WallPiece w:wall)
    {
      if(w.getHP() < lowestHP){
        lowestHP = w.getHP();
        damaged = w;
      }
    }
    return damaged;
  }
  public void draw(PApplet drawer){
    for(int i = 0; i < wall.size(); i++){
      wall.get(i).draw(drawer)
    }
  }

  
}
