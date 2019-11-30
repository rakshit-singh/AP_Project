import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ChooseLevel {
	protected static String curr_user;

	@FXML
	public void startGame1(ActionEvent e) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		Scene scene = new Scene(loader);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
	}

	@FXML
	public void startGame2(ActionEvent e) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("GameScreen2.fxml"));
		Scene scene = new Scene(loader);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
	}

	@FXML
	public void startGame3(ActionEvent e) throws IOException {

		Parent loader = FXMLLoader.load(getClass().getResource("GameScreen3.fxml"));
		Scene scene = new Scene(loader);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
	}

	@FXML
	public void startGame4(ActionEvent e) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("GameScreen4.fxml"));
		Scene scene = new Scene(loader);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
	}

	@FXML
	public void startGame5(ActionEvent e) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("GameScreen5.fxml"));
		Scene scene = new Scene(loader);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
	}

}
