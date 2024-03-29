import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font startFont = new Font("Arial", Font.PLAIN, 20);
    Font instructionFont = new Font("Arial", Font.PLAIN, 20);
    
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
   
   void drawEndState(Graphics g)  { g.setColor(Color.BLACK);
   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); }
    
	
		
}
