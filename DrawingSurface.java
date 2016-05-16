import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	ArrayList<Person> residents;
	ArrayList<Alien> enemies;
	
	public DrawingSurface(){
		residents = new ArrayList<Person>();
		enemies = new ArrayList<Alien>();
	}
	public void addPerson(Person p){
	  	residents.add(p);
	}
	public void addEnemy(Alien a){
		enemies.add(a);
	}
	public void setup(){
		
	}
	public void draw(){
		background(255);
		float x = 50;
		float y = 50;
		for(Person p:residents){
			p.draw(this, x, y);
			x += 50;
			if(x > 500){
				x = 50;
				y+= 100;
			}
		}
		float xE = 50;
		float xY = y + 100;
		for(Alien p:residents){
			p.draw(this, x, y);
			x += 50;
			if(x > 500){
				x = 50;
				y+= 100;
			}
		}
	}
}
