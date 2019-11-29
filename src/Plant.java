import javafx.scene.image.ImageView;

interface Attacker{
    public void attack();
}


public abstract class Plant extends Character {
    final protected int sunsReq;
    final protected int waitingTime;
    public Plant(float health, int lane, int[] position,int sunsReq,int waitingTime,ImageView image) {
        super(health, lane, position,image);
        this.waitingTime=waitingTime;
        this.sunsReq=sunsReq;

    }

    public int getSunsReq() {
        return sunsReq;
    }
    public int getWaitingTime() {
        return waitingTime;
    }

}

class Shooter extends Plant implements Attacker{
    private boolean canAttack;
    public Shooter(int lane, int[] position,ImageView image) {
        super(100, lane, position, 100, 5,image);
    }

    public boolean isCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    @Override
    public void attack() {
        if(canAttack){
            shoot(this);

        }
    }
    public void shoot(Shooter s){
        Pea p=new Pea();


    }
}
class Repeater extends Plant implements  Attacker{
    private boolean canAttack;
    public Repeater(int lane, int[] position,ImageView image) {
        super(100, lane, position, 200, 8,image);
    }

    public boolean isCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    @Override
    public void attack() {
        if(canAttack){
            shoot(this);

        }
    }
    public void shoot(Repeater s){
        Pea p1=new Pea();
        Pea p2=new Pea();
    }
}
class Walnut extends Plant{
    final float defenseVal;
    public Walnut(int lane, int[] position,ImageView image) {
        super(400, lane, position, 50, 5,image);
        defenseVal=50;
    }
}
class Sunflower extends  Plant{
    final float sunRate;
    public Sunflower(int lane, int[] position,ImageView image) {
        super(100, lane, position, 50, 5,image);
        sunRate=1;
    }

}
class Cherrybomb extends Plant implements Attacker{
    public Cherrybomb(int lane, int[] position,ImageView image) {
        super(100, lane, position, 150, 8,image);
    }

    @Override
    public void attack() {

    }
}
class Pea {

    private boolean isexisting;
    private ImageView Pea;

    public Pea() {

        this.Pea = new ImageView("Pea.png");
        this.setIsexisting(false);
    }

    public ImageView getPea() {
        return Pea;
    }

    public boolean isIsexisting() {
        return isexisting;
    }

    public void setIsexisting(boolean isexisting) {
        this.isexisting = isexisting;
    }

}
