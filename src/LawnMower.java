import javafx.scene.image.ImageView;

public class LawnMower extends Character{


    public LawnMower(float health, int lane, double[] position, ImageView image) {
        super(health, lane, position, image);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (LawnMower)super.clone();
    }

}
