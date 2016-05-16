import java.util.ArrayList;

public class Player
{
	  private ArrayList<Person> hired;
	  private double funds;
	  
	  public Player(){
		  hired = new ArrayList<Person>();
		  funds = 1000;
	  }
	  public void hire(Person p){
		  hired.add(p);
		  funds -= p.getPrice();
		  
	  }
	  public void fire(Person p){
		  if(hired.contains(p)){
			  hired.remove(p);
		  }
	  }
	  

}
