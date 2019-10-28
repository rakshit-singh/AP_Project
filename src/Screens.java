import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//import javafx.scene.*;

public class Screens extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    //Override the start method in the Application class
    @Override
    public void start(Stage primaryStage) {

        Image image =new Image("wallpaper.jpg");
        ImageView mv=new ImageView(image);
        Group root=new Group();
        root.getChildren().addAll(mv);
        primaryStage.setTitle("Main Screen");
        Button Play_btn = new Button("Play Game");
        Button Resume_btn = new Button("Resume");
        Button Exit_button=new Button("Exit");


        root.getChildren().addAll(Play_btn,Resume_btn,Exit_button);
        Scene scene = new Scene(root, 200, 250);
        primaryStage.setScene(scene);
// Display the stage
        primaryStage.show();
    }

}
