import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;;import java.io.IOException;

public class PauseScreen extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public Button resumeButton;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Pause Screen");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void startGame(ActionEvent e) throws IOException {
//		Parent loader = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
//		Scene scene = new Scene(loader);
//		Stage app_stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//		app_stage.setScene(scene);
//
//		app_stage.show();
		Stage stage = (Stage) resumeButton.getScene().getWindow();
		// do what you have to do
		stage.close();
	}


}
