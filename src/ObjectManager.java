import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship ship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;
	
	ObjectManager(Rocketship ship){
		this.ship = ship;
	}
	void addProjectile(Projectile projectile) {
		projectiles.add(new Projectile(ship.x+25, ship.y, 10, 30));
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		checkCollisions();
		purgeObjects();
		if(ship.isActive == true) {
		for(Alien a : aliens) {
			a.update();
			if(a.y<0) {
				a.isActive = false;
			}else if(a.y>800) {
				a.isActive = false;
			}
		for(Projectile pro : projectiles) {
			pro.update();
			if(pro.y<0) {
				pro.isActive = false;
				}
			}
		}
		}
	}
	
	Integer getScore() {
		return score;
	}
	
	void draw(Graphics g) {
		ship.draw(g);
		for(Alien a: aliens) {
			a.draw(g);
		}
		for(Projectile p: projectiles) {
			p.draw(g);
		}
	}
	void purgeObjects() {
		for(int i = 0; i<aliens.size(); i++) {
			if(aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for(int i = 0; i<projectiles.size(); i++) {
			if(projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	void checkCollisions(){
		for(Alien a : aliens) {
			if(a.collisionBox.intersects(ship.collisionBox) == true) {
				ship.isActive = false;
				a.isActive = false;
			} 
			for(Projectile p : projectiles) {
				if(p.collisionBox.intersects(a.collisionBox)) {
					score++;
					p.isActive = false;
					a.isActive = false;
				}
			}
		}
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
