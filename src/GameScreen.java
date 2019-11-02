import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GameScreen extends Application {
    @FXML
    private Button shooter_button;
    @FXML
    private AnchorPane Anchor;
    @FXML
    private ImageView shooter_gif;
    @FXML
    public  ImageView sidebar_shooter;
    @FXML
    private ImageView sunflower_gif;
    @FXML
    public  ImageView sidebar_sunflower;
    @FXML
    private ImageView walnut_gif;
    @FXML
    public  ImageView sidebar_walnut;
    @FXML
    public javafx.scene.control.Label sun;
    private boolean isPlaced=false;
    private int sunCount=200;
    @FXML
    public Stage primaryStage;
    @FXML
    public Scene scene;
    private int curGif;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public GameScreen(){

    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{


//        primaryStage.setScene(scene);
//        primaryStage.show();
    }


         @FXML
         public void move_shooter(MouseEvent e){
    //         shooter_gif.setVisible(true);
             if(isPlaced==false) {
                 shooter_gif.setX(e.getX() - 10);
                 shooter_gif.setY(e.getY());
                 System.out.println(e.getSource());
             }
     }
    public  void move(MouseEvent e){
        if(curGif==0){
            move_shooter(e);
        }
        else if(curGif==1){
            move_sunflower(e);
        }
        else if(curGif==2){
            move_walnut(e);
        }
    }
    @FXML
    public void move_sunflower(MouseEvent e){
        //         shooter_gif.setVisible(true);
        if(isPlaced==false) {
            sunflower_gif.setX(e.getX() - 10);
            sunflower_gif.setY(e.getY());
            System.out.println(e.getSource());
        }
    }
    @FXML
    public void move_walnut(MouseEvent e){
        //         shooter_gif.setVisible(true);
        if(isPlaced==false) {
            walnut_gif.setX(e.getX() - 10);
            walnut_gif.setY(e.getY());
            System.out.println(e.getSource());
        }
    }


    @FXML
    public void spawn_shooter(javafx.event.ActionEvent actionEvent) {
        if(sunCount>=100){

            Image i = new Image("shooter_gif.gif");
            shooter_gif = new ImageView(i);
            shooter_gif.setScaleX(0.5);
            shooter_gif.setScaleY(0.5);
            Anchor.getChildren().add(shooter_gif);
            sunCount = sunCount - 100;
            sun.setText("" + sunCount);
            checkOpacity();
            curGif=0;
            isPlaced=false;
            System.out.println(actionEvent.getSource());
        }
    }
    @FXML
    public void spawn_sunflower(javafx.event.ActionEvent actionEvent) {
        if(sunCount>=50){

            Image i = new Image("sunflower_gif.gif");
            sunflower_gif = new ImageView(i);
            sunflower_gif.setScaleX(0.5);
            sunflower_gif.setScaleY(0.5);
            Anchor.getChildren().add(sunflower_gif);
            sunCount = sunCount - 50;
            sun.setText("" + sunCount);
            checkOpacity();
            curGif=1;
            isPlaced=false;
            System.out.println(actionEvent.getSource());
        }
    }
    @FXML
    public void spawn_walnut(javafx.event.ActionEvent actionEvent) {
        if(sunCount>=50){

            Image i = new Image("walnut_gif.gif");
            walnut_gif = new ImageView(i);
            walnut_gif.setScaleX(0.7);
            walnut_gif.setScaleY(0.7);
            Anchor.getChildren().add(walnut_gif);
            sunCount = sunCount - 50;
            sun.setText("" + sunCount);
            checkOpacity();
            curGif=2;
            isPlaced=false;
            System.out.println(actionEvent.getSource());
        }
    }
    public void checkOpacity(){
        if(sunCount<50){
            sidebar_sunflower.setOpacity(0.5);
            sidebar_walnut.setOpacity(0.5);
        }
        else{
            sidebar_sunflower.setOpacity(1);
            sidebar_walnut.setOpacity(1);
        }
        if(sunCount<100){
            sidebar_shooter.setOpacity(0.5);
        }
        else{
            sidebar_shooter.setOpacity(1);
        }
    }

    public void put(MouseEvent e){
        isPlaced=true;
    }
}