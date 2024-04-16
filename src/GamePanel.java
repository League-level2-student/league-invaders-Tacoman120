import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font startFont = new Font("Arial", Font.PLAIN, 20);
    Font instructionFont = new Font("Arial", Font.PLAIN, 20);
    Font scoreFont = new Font("Arial", Font.PLAIN, 15);
    Timer frameDraw;
    Rocketship rocket = new Rocketship(250, 700, 50 ,50);
    ObjectManager manager = new ObjectManager(rocket);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    Timer alienSpawn;
@Override
public void paintComponent(Graphics g){
		
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	GamePanel(){
	   frameDraw = new Timer(1000/60, this);
	   frameDraw.start();
	   if (needImage) {
		    loadImage ("space.png");
		}
}
	void startGame(){
		 alienSpawn = new Timer(1000 , manager);
		    alienSpawn.start();
	}

   void updateMenuState() {   }
  
   void updateGameState() { 
	   manager.update();
	   if(rocket.isActive == false) {
		   currentState = END;
	   }
   }
   
   void updateEndState()  {  }
   
   void drawMenuState(Graphics g) { g.setColor(Color.BLUE);
   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
   g.setFont(titleFont);
   g.setColor(Color.YELLOW);
   g.drawString("LEAGUE INVADERS", 20, 100);
   g.setFont(startFont);
   g.drawString("press ENTER to start", 150, 450);
   g.setFont(instructionFont);
   g.drawString("press SPACE for instructions", 125, 600);}
   
   void drawGameState(Graphics g) {
   
	   if (gotImage) {
			g.drawImage(image, 0, 0, 500, 800, null);
		} else {
			g.setColor(Color.BLACK);
			   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
		}
	   
   g.setColor(Color.WHITE);
   g.setFont(scoreFont);
   g.drawString("Score: "+manager.getScore(), 50, 650);
   manager.draw(g);
   }
   
   void drawEndState(Graphics g)  { g.setColor(Color.RED);
   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
   g.setFont(titleFont);
   g.setColor(Color.YELLOW);
   g.drawString("GAME OVER", 100, 100);
   g.setFont(startFont);
   g.drawString("You Killed "+manager.getScore()+" Enemies", 150, 450);
   g.setFont(instructionFont);
   g.drawString("press ENTER To Restart", 125, 600);}
   
   
  

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(currentState == MENU){
	    updateMenuState();
	}else if(currentState == GAME){
	    updateGameState();
	}else if(currentState == END){
	    updateEndState();
	}
	
	//System.out.println("action");
	repaint();
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	    	rocket = new Rocketship(250, 700, 50 ,50);
	    	manager = new ObjectManager(rocket);
	        currentState = MENU;
	    } else if(currentState == MENU) {
	    	currentState++;
	    	startGame();
	    } else {
	        currentState++;
	    
	    }
	    
	   
	}
	if(e.getKeyCode() == KeyEvent.VK_SPACE) {
		if(currentState == GAME) {
			manager.addProjectile(rocket.getProjectile());
		} else if(currentState == MENU) {
			JOptionPane.showMessageDialog(null, "Use Arrow Keys for movement and SPACE to shoot the enemies\nTry not to get hit by aliens");
		}
	}
	if (e.getKeyCode()==KeyEvent.VK_UP) {
        //System.out.println("UP");
        if(rocket.y >= 0) {
        rocket.up();
        }
    }else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
        //System.out.println("DOWN");
        if(rocket.y <= 710) {
            rocket.down();
            }
    }else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
        //System.out.println("LEFT");
        if(rocket.x >= 0) {
            rocket.left();
            }
    }else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
        //System.out.println("RIGHT");
        if(rocket.x <= 450) {
            rocket.right();
            }
    }
}
void loadImage(String imageFile) {
    if (needImage) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    gotImage = true;
        } catch (Exception e) {
            
        }
        needImage = false;
    }
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
    
	
		
}
