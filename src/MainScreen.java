import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import javafx.scene.*;

public class MainScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    //Override the start method in the Application class
    @Override
    public void start(Stage primaryStage) {

        Image image =new Image("wallpaper.jpg");
        ImageView mv=new ImageView(image);
        // Setting wallpaper according to screen size
        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        Group root=new Group();
        root.getChildren().addAll(mv);
        primaryStage.setTitle("Main Screen");
        Button Play_btn = new Button("Play Game");
        Play_btn.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/2);
        Play_btn.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()/2);
        Play_btn.setScaleX(4);
        Play_btn.setScaleY(4);

        Button Resume_btn = new Button("Resume   ");
        Resume_btn.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/2);
        Resume_btn.setLayoutY(Play_btn.getLayoutY()+150);
        Resume_btn.setScaleX(4);
        Resume_btn.setScaleY(4);
        Button Exit_button=new Button("Exit Game");
        Exit_button.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/2);
        Exit_button.setLayoutY(Resume_btn.getLayoutY()+150);
        Exit_button.setScaleX(4);
        Exit_button.setScaleY(4);
//        Group buttons=new Group();
//        System.out.println(Play_btn.getWidth());
//        Play_btn.setMinWidth(Play_btn.getWidth());
        Resume_btn.setMinWidth(Play_btn.getWidth());
        Exit_button.setMinWidth(Play_btn.getWidth());


        root.getChildren().addAll(Play_btn,Resume_btn,Exit_button);
        Scene scene = new Scene(root, 200, 250);
        primaryStage.setScene(scene);
// Display the stage
        primaryStage.show();
    }

}
