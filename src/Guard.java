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
	Player pl;
	Wall wall;
	/** 
	 *  No Args constructor for Drawing Surface initializes the two types of different objects used in the game,
	 *  people as denoted by residents and aliens as denoted byt enemies
	 * */
	public DrawingSurface(){
		residents = new ArrayList<Person>();
		enemies = new ArrayList<Alien>();
		wall = new Wall();
		pl = new Player();
	}
	/**
	 * 	Adds people objects onto the drawing surface by adding them onto the resident arrraylist
	 * */
	public void addPerson(Person p){
		residents.add(p);
	  	pl.addToFriendly(p);
	}
	/**
	 * 	Adds alien objects onto the drawing surface by adding them onto the enemy arrraylist
	 * */
	public void addEnemy(Alien a){
		enemies.add(a);
		pl.addToEnemies(a);
	}
	public void addPiece(){
		wall.buildWall();
	}
	public void setup(){
		
		
	}
	/**
	 *	Sets the enviroment that the alien and people objects will be initialized in as well as setting their default pos.
	 * */
	public void draw(){
		background(255);
		ArrayList<Worker> workers = new ArrayList<Worker>();
		ArrayList<Guard> guards = new ArrayList<Guard>();
		for(Person p:residents){
			p.draw(this);
			
			p.act(pl);
			redraw();
		}
		for(Alien p:enemies){
			p.draw(this);
		}
		wall.draw(this);
		
		
		
		
	}
	public void mouseClicked(){
		addPiece();
		redraw();
	}
}
