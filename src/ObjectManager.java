import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship ship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	
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
		for(Alien a : aliens) {
			a.update();
			if(a.y<0) {
				a.isActive = false;
			}else if(a.y>800) {
				a.isActive = false;
			}
		for(Projectile pro : projectiles) {
			if(pro.y<0) {
				pro.isActive = false;
				}
			}
		}
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
}
