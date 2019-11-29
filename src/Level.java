//import javax.swing.text.html.ImageView;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
public class Level {
}

class Lawn{
    private ArrayList<Character> activeChars;
    private double[] y_coord={100,200,330,440,550};
    private double[] x_coord={232,306,382,462,539,615,685,756,835};
    public Lawn(){
        activeChars=new ArrayList<>();
    }
    public void addCharacter(Character c){
        activeChars.add(c);
    }

    public double[] getY_coord() {
        return y_coord;
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
    public void createObject(int lane,int num, ImageView image){
        double[] pos={image.getX(),image.getY()};
        if(num==0){
            Plant s=new Shooter(lane,pos,image);
            activeChars.add(s);
        }
        else if(num==1){
            Plant s=new Sunflower(lane,pos,image);
            activeChars.add(s);
        }
        else if(num==2){
            Plant s=new Walnut(lane,pos,image);
            activeChars.add(s);
        }
        else if(num==3){

            Plant s=new Cherrybomb(lane,pos,image);
            activeChars.add(s);
        }
        else if(num==4){
            Plant s=new Repeater(lane,pos,image);
            activeChars.add(s);
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

//    public
}