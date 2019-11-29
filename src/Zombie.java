import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Zombie extends Character {
    float movementSpeed;
    float damage;

    public Zombie(float health, int lane, double[] position, float movementSpeed, float damage, ImageView image) {
        super(health, lane, position,image);
        this.movementSpeed=movementSpeed;
        this.damage=damage;
    }
}

class BucketZombie extends  Zombie{
    public BucketZombie(int lane, double[] position,ImageView image) {
        super(300, lane, position,(float) 1.5,10,image);
    }
}
class ConeZombie extends Zombie{
    public ConeZombie(float health, int lane, double[] position,ImageView image) {
        super(250, lane, position,1,15,image);
    }
}
class BasicZombie extends  Zombie{
    public BasicZombie(float health, int lane, double[] position,ImageView image) {
        super(100, lane, position,1,20,image);
    }
}
class JavelinZombie extends Zombie{
    public JavelinZombie(float health, int lane, double[] position,ImageView image) {
        super(150, lane, position,1,10,image);
    }
}