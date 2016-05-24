
public class Medic extends Worker{
	private int patrolDir;
	private int patrolTimer;
	/**
	 * Represents a medic class that heals allied Persons
	 * @param x x-position of the medic
	 * @param y y-position of the medic
	 */
	public Medic(double x, double y) {
		super(x, y);
		patrolDir = 0;
		patrolTimer = 0;
	}
	/**
	 * Gets the type of Person this is
	 * @return Returns a string representing the type of person
	 */
	public String getType(){
		  return "Medic";
		  
	  }
	  
	  /**
	   * Repairs the target wall piece
	   * @param w person that is to be repaired
	   * @pre w is damaged and not null
	   */
	  public void heal(Person w){
		  w.setHP(w.getHP() + getLevel() * 10);
		  addXP(50);
	  }
	  /**
	   * Moves the medic towards a person and patrols if the wall is currently unreachable. If there is no
	   * @param p Player object containing the other objects
	   */
	  public void act(Player p){
		  super.act(p);
		  Person target = null;
		  for(Person a:p.getHired()){
			  if(a.getHP() < Person.MAX_HP)
				  target = a;
		  }
		  if(target != null){
			  if(distanceTo(target) <= 60){
				  heal(target);
			  }else{
				  if(!move((int)directionTo(target), 5,p)){
					  move(patrolDir,5,p);
					  patrolTimer++;
					  if(patrolTimer >= 25){
						  patrolDir += 90;
						  patrolTimer = 0;
					  }
				  }
			  }
		  }
		 
	  }

}
