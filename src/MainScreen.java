import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.security.Timestamp;

public class MainScreen extends Application {
    @FXML
    private Button Play_Game,Resume_Game,Exit_Game;
    @FXML
    private Stage primaryStage;
    public MainScreen() {
        primaryStage=new Stage();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        this.primaryStage.setTitle("Main Screen");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
//        Platform.runLater(() -> primaryStage.close());

//        this.primaryStage.close();
    }
    @FXML
    public void PlayControl(ActionEvent event) throws Exception {

        Parent loader = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));//Creates a Parent called loader and assign it as ScReen2.FXML

        Scene scene = new Scene(loader); //This creates a new scene called scene and assigns it as the Sample.FXML document which was named "loader"
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);

        app_stage.show();
    }
    @FXML
    public void LeaderBoardControl(ActionEvent event) throws Exception {

        Parent loader = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));//Creates a Parent called loader and assign it as ScReen2.FXML

        Scene scene = new Scene(loader); //This creates a new scene called scene and assigns it as the Sample.FXML document which was named "loader"
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);

        app_stage.show();
    }

    @FXML
    public void ExitControl(){
        System.exit(1);
    }
    public static void main(String[] args) throws Exception {
        launch(args);
//        controlButton();

    }



}
