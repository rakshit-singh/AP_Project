import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreen extends Application {
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

    public LoginScreen(){

    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();

    }
    @FXML
    public void startGame(ActionEvent e) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        Scene scene = new Scene(loader);
        Stage app_stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

}
