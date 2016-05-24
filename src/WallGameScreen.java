import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class WallGameScreen extends JPanel implements Runnable, ActionListener
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 600;
  
  private Rectangle screenRect;
  private Player player;
  private boolean running;
  private WallMain w;
  


  public WallGameScreen (WallMain w) {
	  super();
	  setBackground(Color.GRAY);
	  screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
	  this.w = w;
	  JButton button = new JButton("BUY AN ORPHAN");
	  button.addActionListener(this);
	  add(button);
	  player = new Player();
	  for(int i = 0; i < 20; i++){
		  player.getWall().buildWall();
		  player.getEntities().add(player.getWall().getWallParts().get(i));
	  }
	  running = true;
	  
	 Spawner spawn = new Spawner(500,800);
	 Base base = new Base();
	 player.setBase(base);
	 player.setSpawner(spawn);
	 player.getEntities().add(base);
	 player.getEntities().add(spawn);
	 spawn.moveToLocation(500, 800);
	 new Thread(this).start();
  }
  
  public void addPerson(Person a){
	  player.hire(a);
  }
  public void addEnemy(Alien a){
	  player.addEnemy(a);
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background
   

	Graphics2D g2 = (Graphics2D)g;
	player.setGfx(g2);
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
    	if(p instanceof Guard){
    		if(((Guard) p).getClosest(player) != null)
    			g2.drawLine((int)p.getCenterX(), (int)p.getCenterY(), (int)((Guard) p).getClosest(player).getCenterX(), (int)((Guard) p).getClosest(player).getCenterY());
    	}
    	p.draw(g2, this);
    }
    for(Alien a:player.getEnemy()){
    	a.draw(g2, this);
    }
    player.getSpawner().draw(g2, this);
    player.getHQ().draw(g2, this);
    
    g2.setTransform(at);
  }
  
  public Player getPlayer(){
	  return player;
  }


  public void run() {
	while (running) { // Modify this to allow quitting
		long startTime = System.currentTimeMillis();
		if(player.getHQ().getLifeStatus()){
			w.changeToDead();
		}
		for(int i = 0; i < player.getEntities().size(); i++){
			Entity a = player.getEntities().get(i);
			a.act(player);
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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
	
	}
}

@Override
public void actionPerformed(ActionEvent arg0) {
	w.changeToBuy();
	
}
public class MouseHandler implements MouseListener{
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

}
