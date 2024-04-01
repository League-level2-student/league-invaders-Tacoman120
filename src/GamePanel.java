import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    Timer frameDraw;
    
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
}

   void updateMenuState() {   }
  
   void updateGameState() {  }
   
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
   
   void drawGameState(Graphics g) { g.setColor(Color.BLACK);
   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); }
   
   void drawEndState(Graphics g)  { g.setColor(Color.RED);
   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
   g.setFont(titleFont);
   g.setColor(Color.YELLOW);
   g.drawString("GAME OVER", 100, 100);
   g.setFont(startFont);
   g.drawString("You Killed "+" Enemies", 150, 450);
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
	        currentState = MENU;
	    } else {
	        currentState++;
	    }
	    
	   
	}   
	if (e.getKeyCode()==KeyEvent.VK_UP) {
        System.out.println("UP");
    }else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
        System.out.println("DOWN");
    }else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
        System.out.println("LEFT");
    }else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
        System.out.println("RIGHT");
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
