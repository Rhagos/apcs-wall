import java.util.ArrayList;

import processing.core.PApplet;
/**
 *  This class represents the game enviroment where all the different objects in the game are initialized so that it can later be 
 *  called in WallGame 
 *	
 * */
public class DrawingSurface extends PApplet{
	ArrayList<Person> residents;
	ArrayList<Alien> enemies;
	/** 
	 *  No Args constructor for Drawing Surface initializes the two types of different objects used in the game,
	 *  people as denoted by residents and aliens as denoted byt enemies
	 * */
	public DrawingSurface(){
		residents = new ArrayList<Person>();
		enemies = new ArrayList<Alien>();
	}
	/**
	 * 	Adds people objects onto the drawing surface by adding them onto the resident arrraylist
	 * */
	public void addPerson(Person p){
	  	residents.add(p);
	}
	/**
	 * 	Adds alien objects onto the drawing surface by adding them onto the enemy arrraylist
	 * */
	public void addEnemy(Alien a){
		enemies.add(a);
	}
	public void setup(){
		
	}
	/**
	 *	Sets the enviroment that the alien and people objects will be initialized in as well as setting their default pos.
	 * */
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
