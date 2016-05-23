import java.util.ArrayList;

public class Player
{
	  private ArrayList<Person> hired;
	  private ArrayList<Alien> enemy;
	  private Wall walls = new Wall();
	  private ArrayList<Entity> entities;
	  private ArrayList<Person> buyList;
	  private Spawner spawn;
	  private double funds;
	  private Base HQ;
	  /**
	   * Represents the player and the funds and People that he or she has
	   */
	  public Player(){
		  hired = new ArrayList<Person>();
		  enemy = new ArrayList<Alien>();
		  funds = 10000;
		  spawn = new Spawner(200,350);
		  entities = new ArrayList<Entity>();
		  buyList = new ArrayList<Person>();
	  }
	  /**
	   * Hires a person for their cost
	   * @param p Person to be hired
	   * @pre p is not null
	   * @post hired will contain p and funds will be lowered by p's cost
	   */
	  public void hire(Person p){
		  if(funds >= p.getPrice()){
			  buyList.add(p);
			  funds -= p.getPrice();
			  System.out.println(funds);
		  }
		  
	  }
	  
	  public double getFunds(){
		  return funds;
	  }
	  
	  public void place(int x, int y){
		  if(buyList.size() > 0){
			  Person p = buyList.get(0);
			  System.out.println(p);
			  p.moveToLocation(x, y);
			  System.out.println("NEW" + p.getX() + " " + p.getY());
			  
			  for(WallPiece a: walls.getWallParts()){
				  if(a != null)
				  if(p.intersects(a)){
					  p.moveToLocation(x,y-100);
				  }
			  }
			  
			  hired.add(buyList.get(0));
			  entities.add(buyList.get(0));
			  buyList.remove(0);
		  }
	  }
	  
	  public void addEnemy(Alien p){
		  enemy.add(p);
		  entities.add(p);
	  }
	  /**
	   * Fires a person and returns half of the cost back to your funds
	   * @param p Person to be fired
	   * @pre p is not null
	   * @post p will no longer be in hired and the funds will increase by half of p's cost
	   */
	  public void fire(Person p){
		  if(hired.contains(p)){
			  hired.remove(p);
			  funds += p.getPrice()/2;
		  }
	  }
	  
	  public void removeFriendly(Person a){
		  hired.remove(a);
		  entities.remove(a);
	  }
	  public void removeEnemy(Alien a){
		  funds += 100;
		  enemy.remove(a);
		  entities.remove(a);
	  }
	  public ArrayList<Person> getHired(){
		  return hired;
	  }
	  public ArrayList<Alien> getEnemy(){
		  return enemy;
	  }
	  public Wall getWall(){
		  return walls;
	  }
	  public Spawner getSpawner(){
		  return spawn;
	  }
	  public ArrayList<Entity> getEntities(){
		  return entities;
	  }
	  public Base getHQ(){
		  return HQ;
	  }

}
