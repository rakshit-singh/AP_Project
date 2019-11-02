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
    public Stage primaryStage;
    @FXML
    public Scene scene;

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

        Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
    @FXML
    private Button shooter_button;
         @FXML
         private AnchorPane Anchor;
         @FXML
         private ImageView shooter_gif;

         @FXML
         public void move(MouseEvent e){
    //         shooter_gif.setVisible(true);
             shooter_gif.setX(e.getX()-10);
             shooter_gif.setY(e.getY());
             System.out.println(e.getSource());
     }


    @FXML
    public void spawn(javafx.event.ActionEvent actionEvent) {
        Image i=new Image("shooter_gif.gif");
        shooter_gif=new ImageView(i);
        Anchor.getChildren().add(shooter_gif);
        System.out.println(actionEvent.getSource());
    }

    public void put(MouseEvent e){
            
    }
}