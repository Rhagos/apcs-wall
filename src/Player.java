import java.util.ArrayList;

public class Player
{
	  private ArrayList<Person> hired;
	  private ArrayList<Alien> enemy;
	  private Person[][] friendly = new Person[500][500];
	  private Alien[][] enemies = new Alien[500][500];
	  private Wall walls = new Wall();
	  private double funds;
	  /**
	   * Represents the player and the funds and People that he or she has
	   */
	  public Player(){
		  hired = new ArrayList<Person>();
		  enemy = new ArrayList<Alien>();
		  funds = 1000000;
	  }
	  /**
	   * Hires a person for their cost
	   * @param p Person to be hired
	   * @pre p is not null
	   * @post hired will contain p and funds will be lowered by p's cost
	   */
	  public void hire(Person p){
		  if(funds >= p.getPrice()){
			  hired.add(p);
			  funds -= p.getPrice();
		  }
		  
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
		  if(!(a.getX() >= 0 && a.getX() < 500) && !(a.getY() >= 0 && a.getY() < 500)){
			  return;
		  }
		  if(friendly[(int) a.getX()][(int) a.getY()].equals(a)){
			  hired.remove(a);
			  friendly[(int) a.getX()][(int) a.getY()] = null;
			  return;
		  
		  }
	  }
	  public void removeEnemy(Alien a){
		  enemy.remove(a);
	  }
	  
	  public void updatePosition(Entity e){
		  if(e instanceof Alien){
			  if(enemies[(int) e.getX()][(int) e.getY()] == null){
				  enemies[(int) e.getX()][(int) e.getY()] = (Alien) e;
			  }
		  }else{
			  if(friendly[(int) e.getX()][(int) e.getY()] == null){
				  friendly[(int) e.getX()][(int) e.getY()] = (Person) e;
			  }
		  }
	  }
	  
	  public Person[][] getPersonnel(){
		  return friendly;
	  }
	  public Alien[][] getEnemies(){
		  return enemies;
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

}
