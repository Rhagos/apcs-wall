import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class WallGameScreen extends JPanel implements Runnable
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 600;
  
  private Rectangle screenRect;
  private Player player;
  private ArrayList<Entity> entities;
  


  public WallGameScreen () {
	  super();
	  setBackground(Color.GRAY);
	  screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);

	  entities = new ArrayList<Entity>();
	  player = new Player();
	  for(int i = 0; i < 20; i++){
		  player.getWall().buildWall();
	  }
	  
	  
	  
	 addPerson(new Guard(100,100));
	 addPerson(new Guard(150,100));
	 addPerson(new Worker(125,100));
	 addEnemy(new Alien(100,300));
	 addEnemy(new Alien(125,300));
	 addEnemy(new Alien(150,300));
	 
	 new Thread(this).start();
  }
  
  public void addPerson(Person a){
	  player.hire(a);
	  entities.add(a);
  }
  public void addEnemy(Alien a){
	  player.addToEnemies(a);
	  entities.add(a);
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

	Graphics2D g2 = (Graphics2D)g;

    int width = getWidth();
    int height = getHeight(); 
    
    double ratioX = (double)width/DRAWING_WIDTH;
    double ratioY = (double)height/DRAWING_HEIGHT;
    
    AffineTransform at = g2.getTransform();
  //  g2.scale(ratioX, ratioY); 

    g.setColor(new Color(205,102,29));
    for (WallPiece w: player.getWall().getWallParts()) {
    	if(w != null)
    		w.draw(g2,this);
    }
    for(Person p:player.getHired()){
    	p.draw(g2, this);
    }
    for(Alien a:player.getEnemy()){
    	a.draw(g2, this);
    }
    g2.setTransform(at);

	// TODO Add any custom drawings here
  }


  public void run() {
	while (true) { // Modify this to allow quitting
		long startTime = System.currentTimeMillis();
		for(Entity e:entities){
			e.act(player);
		}
	  	repaint();
	  	
	  	long waitTime = 17 - (System.currentTimeMillis()-startTime);
	  	try {
	  		if (waitTime > 0)
	  			Thread.sleep(waitTime);
	  		else
	  			Thread.yield();
	  	} catch (InterruptedException e) {}
	}
  }
  
  

public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
	
	}
}


}
