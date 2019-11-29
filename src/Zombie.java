public class Zombie extends Character {
    float movementSpeed;
    float damage;

    public Zombie(float health, int lane, int[] position,float movementSpeed,float damage) {
        super(health, lane, position);
        this.movementSpeed=movementSpeed;
        this.damage=damage;
    }
}

class BucketZombie extends  Zombie{
    public BucketZombie(int lane, int[] position) {
        super(300, lane, position, (float) 1.5,10);
    }
}
class ConeZombie extends Zombie{
    public ConeZombie(float health, int lane, int[] position) {
        super(250, lane, position,1,15);
    }
}
class BasicZombie extends  Zombie{
    public BasicZombie(float health, int lane, int[] position) {
        super(100, lane, position,1,20);
    }
}
class JavelinZombie extends Zombie{
    public JavelinZombie(float health, int lane, int[] position) {
        super(150, lane, position,1,10);
    }
}