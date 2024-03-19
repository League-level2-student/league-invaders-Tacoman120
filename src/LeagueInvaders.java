import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	
	public static void main(String[] args) {
		LeagueInvaders back = new LeagueInvaders();
		back.setup();
	}
	
	
	LeagueInvaders(){
		frame = new JFrame();
		
	
		
	}
	
	void setup() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
