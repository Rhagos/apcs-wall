import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	ArrayList<Person> residents;
	
	public DrawingSurface(){
		residents = new ArrayList<Person>();
	}
	public void addPerson(Person p){
	  residents.add(p);
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
	}
}
