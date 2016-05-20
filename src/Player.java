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
		  funds = 1000;
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
	  
	  
	  
	  public void addToEnemies(Alien a){
		  if(!(a.getX() >= 0 && a.getX() < 500) && !(a.getY() >= 0 && a.getY() < 500)){
			  return;
		  }
		  if(enemies[(int) a.getX()][(int) a.getY()] == null){
			  enemies[(int) a.getX()][(int) a.getY()] = a;
			  return;
		  }
		  a.setX(a.getX()+1);
		  a.setY(a.getY()+1);
		  addToEnemies(a);
	  }
	  
	  public void addToFriendly(Person a){
		  if(!(a.getX() >= 0 && a.getX() < 500) && !(a.getY() >= 0 && a.getY() < 500)){
			  return;
		  }
		  if(friendly[(int) a.getX()][(int) a.getY()] == null){
			  friendly[(int) a.getX()][(int) a.getY()] = a;
			  return;
		  
		  }
		  a.setX(a.getX()+1);
		  a.setY(a.getY()+1);
		  addToFriendly(a);
	  }
	  
	  public void updatePosition(Person p){
		  if(p instanceof Alien){
			  if(enemies[(int) p.getX()][(int) p.getY()] == null){
				  enemies[(int) p.getX()][(int) p.getY()] = (Alien) p;
			  }
		  }else{
			  if(friendly[(int) p.getX()][(int) p.getY()] == null){
				  friendly[(int) p.getX()][(int) p.getY()] = (Alien) p;
			  }
		  }
	  }
	  
	  public Person[][] getPersonnel(){
		  return friendly;
	  }
	  public Alien[][] getEnemies(){
		  return enemies;
	  }
	  public Wall getWall(){
		  return walls;
	  }

}
