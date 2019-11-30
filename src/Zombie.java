import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

interface saveposition {

}

public class Zombie extends Character implements saveposition {
	private float movementSpeed;
	private float damage;
	private boolean stop;
	private Plant enemy;
	private final int capacity;
	private int taken;
	public Plant getEnemy() {
		return enemy;
	}

	public void setEnemy(Plant enemy) {
		this.enemy = enemy;
	}

	public Zombie(float health, int lane, double[] position, float movementSpeed, float damage, ImageView image,int capacity) {
		super(health, lane, position, image);
		this.movementSpeed = movementSpeed;
		this.damage = damage;
		stop=false;
		enemy=null;
		this.capacity=capacity;
		taken=0;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void takeDamage(int val){
		taken+=1;
		if(taken>capacity){
			health=0;
			exists=false;
		}

	}
}

class BucketZombie extends Zombie {
	public BucketZombie(int lane, double[] position, ImageView image) {
		super(300, lane, position, (float) 1.5, 10, image,10);
	}
}

class ConeZombie extends Zombie {
	public ConeZombie(int lane, double[] position, ImageView image) {
		super(250, lane, position, 1, 15, image,15);
	}
}

class BasicZombie extends Zombie {
	public BasicZombie(int lane, double[] position, ImageView image) {
		super(100, lane, position, 1, 20, image,5);
	}
}

class JavelinZombie extends Zombie {
	public JavelinZombie(int lane, double[] position, ImageView image) {
		super(150, lane, position, 1, 10, image,10);
	}
}