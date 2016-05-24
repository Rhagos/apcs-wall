import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
/**
 * This class represents a Plater which encompasses all objects on the WallGamePanel 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/
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
	  private Graphics2D draw;
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
	  
	  public void setGfx(Graphics2D g){
		  draw = g;
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
	  /**
	   *  Returns the funds currently usable 
	   * */
	  public double getFunds(){
		  return funds;
	  }
	  /**
	   *  Adds onto the current fund by a amount
	   *  @param a set amount added on 
	   * */
	  public void changeFunds(double a){
		  funds += a;
	  }
	  /**  Puts new person objects purchased onto the map onto the Game Panel 
	   * 	@param x xCoord placed 
	   *    @param y yCoord placed 
	   * */
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
	  /**
	   * 	Upgrades wall by placing a turret or if there is already a turret then add on additional health 
	   * */
	  public void upgradeWall(){
		  for(int i = 0; i < walls.getWallParts().size(); i++){
			  WallPiece p = walls.getWallParts().get(i);
			  try{
			  if(!(p instanceof Turret)){
				  entities.add(entities.indexOf(p), new Turret(p.getX(),p.getY(),p.getIndex(),walls));
				  entities.remove(entities.indexOf(p)+1);
				  walls.getWallParts().add(p.getIndex(),new Turret(p.getX(),p.getY(),p.getIndex(),walls));
				  if(p.getIndex()+1 <= walls.getWallParts().size())
					  walls.getWallParts().remove(p.getIndex()+1);
				  
			  }else{
				  p.setHP(WallPiece.MAX_HP + 5000);
			  }
			  }catch(NullPointerException e){
				  
			  }
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
	  /**
	   *  Removes either already spawned or bought person objects off the game board    
	   * 
	   * */
	  public void removeFriendly(Person a){
		  hired.remove(a);
		  entities.remove(a);
	  }
	  /**
	   *  Removes either already spawned or bought alien objects off the game board 
	   * */
	  public void removeEnemy(Alien a){
		  funds += 100;
		  enemy.remove(a);
		  entities.remove(a);
	  }
	  /**
	   *  Returns all hired person within the array 
	   * */
	  public ArrayList<Person> getHired(){
		  return hired;
	  }
	  /**
	   *  Returns all enemy within the array 
	   * */ 
	  public ArrayList<Alien> getEnemy(){
		  return enemy;
	  }
	  /**
	   * 	Returns the whole array of walls 
	   * */
	  public Wall getWall(){
		  return walls;
	  }
	  /**
	   *  Returns the spawner 
	   * */
	  public Spawner getSpawner(){
		  return spawn;
	  }
	  /**
	   * 	Returns the whole array of entities 
	   * */
	  public ArrayList<Entity> getEntities(){
		  return entities;
	  }
	  /**
	   *  Returns the base HQ
	   * */
	  public Base getHQ(){
		  return HQ;
	  }

}
