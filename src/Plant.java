import javafx.scene.image.ImageView;

interface Attacker{
    public void attack();
}
interface Defend{
    public void takeDamage(Zombie z);
}

public class Plant extends Character {
    final protected int sunsReq;
    final protected int waitingTime;
    public Plant(float health, int lane, double[] position,int sunsReq,int waitingTime,ImageView image) {
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

class Shooter extends Plant implements Attacker,Defend{
    private Zombie current;
    private Pea mypea;
    public Shooter(int lane, double[] position,ImageView image) {
        super(100, lane, position, 100, 5,image);
        mypea=new Pea();
        current=null;
    }


    public Pea getMypea() {
        return mypea;
    }

    public void setMypea(Pea mypea) {
        this.mypea = mypea;
    }

    public void shoot(Shooter s){
        Pea p=new Pea();
    }

    public Zombie getCurrent() {
        return current;
    }

    public void setCurrent(Zombie current) {
        this.current = current;
    }

    @Override
    public void takeDamage(Zombie z) {
        if(this.health-z.getDamage()>0) {
            this.health -= z.getDamage();
        }
        else{
            z.setStop(false);
            this.mypea.getPea().setVisible(false);
            this.setExists(false);
        }
    }

    @Override
    public void attack() {

    }
}
class Repeater extends Plant implements  Attacker {
    private boolean canAttack;
    public Repeater(int lane, double[] position,ImageView image) {
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
class Walnut extends Plant implements  Defend{
//    final float defenseVal;
    public Walnut(int lane, double[] position,ImageView image) {
        super(400, lane, position, 50, 5,image);
//        defenseVal=;
    }

    @Override
    public void takeDamage(Zombie z) {
        if(this.health-z.getDamage()>0) {
            this.health -= z.getDamage();
        }
        else{
            z.setStop(false);
            this.setExists(false);
        }
    }
}
class Sunflower extends  Plant implements Defend{
    final float sunRate;
    public Sunflower(int lane, double[] position,ImageView image) {
        super(100, lane, position, 50, 5,image);
        sunRate=1;
    }
    @Override
    public void takeDamage(Zombie z) {
        if(this.health-z.getDamage()>0) {
            this.health -= z.getDamage();
        }
        else{
            z.setStop(false);
            this.setExists(false);
        }
    }

}
class Cherrybomb extends Plant implements Attacker{
    public Cherrybomb(int lane, double[] position,ImageView image) {
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

