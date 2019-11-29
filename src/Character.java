public class Character {
    protected boolean exists;
    protected float health;
    protected final int lane;
    protected int[] position;

    public Character(float health,int lane, int[] position) {
        this.exists = true;
        this.health = health;
        this.lane = lane;
        this.position = position;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getLane() {
        return lane;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}
