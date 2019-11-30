
//import javax.swing.text.html.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.runtime.output.ForkXmlOutput;

public class Level {
}


class Lawn{
    
	private ArrayList<Character> activeChars;
    private static double zombie_start_point = 887;// X Coordinate for spawning the zombies
    private double[] y_coord={100,200,330,440,550};
    private double[] x_coord={232,306,382,462,539,615,685,756,835};
    private double[] spawn_points = { 44, 163, 290, 401, 526 };// Y Coordinates for spawning the zombies
    private  ArrayList<Zombie>zombie_arr=new ArrayList<>();
    private ArrayList<LawnMower> lawnMowers=new ArrayList<>();

    public ArrayList<LawnMower> getLawnMowers() {
        return lawnMowers;
    }

    public void setLawnMowers(ArrayList<LawnMower> lawnMowers) {
        this.lawnMowers = lawnMowers;
    }

    public Lawn() throws CloneNotSupportedException {

        activeChars=new ArrayList<>();
        lawnMowers=new ArrayList<>();
        double[] arr={0,0};
        LawnMower l1=new LawnMower(1000,0,arr,new ImageView());
        LawnMower l2=(LawnMower) l1.clone();
        LawnMower l3=(LawnMower) l1.clone();
        LawnMower l4=(LawnMower) l1.clone();
        LawnMower l5=(LawnMower) l1.clone();

        lawnMowers.add(l1);
        lawnMowers.add(l2);
        lawnMowers.add(l3);
        lawnMowers.add(l4);
        lawnMowers.add(l5);

    }
    public void addCharacter(Character c){
        activeChars.add(c);
    }

    public double[] getY_coord() {
        return y_coord;
    }
    
    public double[] getSpawn_points() {
		return spawn_points;
	}
    
    public void setY_coord(double[] y_coord) {
        this.y_coord = y_coord;
    }

    public void deleteCharacter(Character c){
        activeChars.remove(c);
    }

    public ArrayList<Character> getActiveChars() {
        return activeChars;
    }

    public void setActiveChars(ArrayList<Character> activeChars) {
        this.activeChars = activeChars;
    }

    public double[] getX_coord() {
        return x_coord;
    }

    public void setX_coord(double[] x_coord) {
        this.x_coord = x_coord;
    }

    public double[] correct_layout(double x, double y){
        for(int i=0;i<4;i++){
            if(y>=y_coord[4]){
                y=y_coord[4];
                break;
            }
            else if(y<=y_coord[0]){
                y=y_coord[0];
                break;
            }
            else if(y_coord[i]<=y && y_coord[i+1]>=y){
                if(Math.abs(y-y_coord[i])>Math.abs(y=y_coord[i+1])){
                    y=y_coord[i+1];
                }
                else{
                    y=y_coord[i];
                }
            }
        }
        for(int i=0;i<x_coord.length-1;i++){
            if(x>=x_coord[8]){
                x=x_coord[8];
                break;
            }
            else if(x<=x_coord[0]){
                x=x_coord[0];
                break;
            }
            else if(x_coord[i]<=x && x_coord[i+1]>=x){
                if(Math.abs(x-x_coord[i])>Math.abs(x=x_coord[i+1])){
                    x=x_coord[i+1];
                }
                else{
                    x=x_coord[i];
                }
            }

        }
        double[] arr={x,y};
        return arr;
    }

    public static double getZombie_start_point() {
        return zombie_start_point;
    }

    public static void setZombie_start_point(double zombie_start_point) {
        Lawn.zombie_start_point = zombie_start_point;
    }

    public void setSpawn_points(double[] spawn_points) {
        this.spawn_points = spawn_points;
    }

    public ArrayList<Zombie> getZombie_arr() {
        return zombie_arr;
    }

    public void setZombie_arr(ArrayList<Zombie> zombie_arr) {
        this.zombie_arr = zombie_arr;
    }

    public Plant createObject(int lane, int num, ImageView image){
        double[] pos={image.getX(),image.getY()};
        if(num==0){
            Plant s=new Shooter(lane,pos,image);
            activeChars.add(s);
            return s;
        }
        else if(num==1){
            Plant s=new Sunflower(lane,pos,image);
            activeChars.add(s);
            return s;

        }
        else if(num==2){
            Plant s=new Walnut(lane,pos,image);
            activeChars.add(s);
            return s;

        }
        else if(num==3){

            Plant s=new Cherrybomb(lane,pos,image);
            activeChars.add(s);
            return s;

        }
        else if(num==4){
            Plant s=new Repeater(lane,pos,image);
            activeChars.add(s);
            return s;

        }
        return null;
    }
    public void removeDeadZombies(){
        for(int i=0;i<activeChars.size();i++){
            if(!activeChars.get(i).isExists()){
                activeChars.remove(i);
                zombie_arr.remove(i);
            }
        }
    }
    
 // Adds the zombies to active characters
 	public void SpawnZombies(int type, int lane, ImageView image) {
 		if (type == 0) {
 			double y = spawn_points[lane];
 			double[] arr = { 0.0, y };
 			Zombie z = new BasicZombie(lane, arr, image);
 			activeChars.add(z);
 			zombie_arr.add(z);
 		} else if (type == 1) {
 			double y = spawn_points[lane];
 			double[] arr = { 0.0, y };
 			Zombie z = new ConeZombie(lane, arr, image);
 			activeChars.add(z);
            zombie_arr.add(z);

        } else if (type == 2) {
 			double y = spawn_points[lane];
 			double[] arr = { 0.0, y};
 			Zombie z = new BucketZombie(lane, arr, image);
 			activeChars.add(z);
            zombie_arr.add(z);

        } else if (type == 3) {
 			double y = spawn_points[lane];
 			double[] arr = { 0.0, y };
 			Zombie z = new JavelinZombie(lane, arr, image);
 			activeChars.add(z);
            zombie_arr.add(z);

        }
 	}
 	
    public int calcLane(double y){
        int c=0;
        for(int i=0;i<y_coord.length;i++){
            if(y==y_coord[i]){
                c=i;
            }
        }
        return c;
    }
    public void displayChar(){
        for(Character s: activeChars){
            System.out.println(s+"  lane= "+s.getLane());
        }
    }
    public ArrayList<Integer> checkPlantStatus(){
        ArrayList<Integer>a=new ArrayList<>();
        for(int i=0;i<activeChars.size();i++){
            if(!activeChars.get(i).isExists()){
                activeChars.get(i).image.setVisible(false);
                a.add(i);

            }
        }
        return a;

    }


//    public
}