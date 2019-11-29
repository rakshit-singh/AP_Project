import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
//<<<<<<< HEAD

public class GameScreen extends Application implements Initializable {
	@FXML
	private Button shooter_button;
	@FXML
	private AnchorPane Anchor;
	@FXML
	public ImageView lawnmower;
	@FXML
	private ImageView shooter_gif;
	@FXML
	public ImageView sidebar_shooter;
	@FXML
	private ImageView sunflower_gif;
	@FXML
	public ImageView sidebar_sunflower;
	@FXML
	private ImageView walnut_gif;
	@FXML
	public ImageView sidebar_walnut;
	@FXML
	public javafx.scene.control.Label sun;
	@FXML
	public ImageView zombie_gif;
	@FXML
	public ImageView cherry_img;
	@FXML
	public ImageView repeeater_img;
	@FXML
	public ImageView falling_sun;
	@FXML
	public ImageView CherryBomb_gif;

	public Lawn lawn = new Lawn();
	private int[] y_coord = { 50, 180, 310, 420, 540 };
	@FXML
	public ProgressBar slider;
	private boolean isPlaced = false;
	private int sunCount = 200;
	@FXML
	public Stage primaryStage;
	@FXML
	public Scene scene;
	private int curGif;
	public EventHandler<MouseEvent> e;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private boolean pea_spawnable;

	public GameScreen() {

	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// primaryStage.setScene(scene);
		// primaryStage.show();
	}

	@FXML
	public void move_shooter(MouseEvent e) {
		// shooter_gif.setVisible(true);
		if (isPlaced == false) {
			double x = e.getX() - 80;
			double y = e.getY() - 80;
			double[] curr = lawn.correct_layout(x, y);
			shooter_gif.setX(curr[0] - 70);
			shooter_gif.setY(curr[1] - 50);
			System.out.println(e.getSource());
		}
	}

	public void move(MouseEvent e) {
		if (curGif == 0) {
			move_shooter(e);
		} else if (curGif == 1) {
			move_sunflower(e);
		} else if (curGif == 2) {
			move_walnut(e);
		} else if (curGif == 3) {
			move_CherryBomb(e);
		}
	}

	@FXML
	public void move_sunflower(MouseEvent e) {
		// shooter_gif.setVisible(true);
		if (isPlaced == false) {
			double x = e.getX() - 80;
			double y = e.getY() - 80;
			double[] curr = lawn.correct_layout(x, y);
			sunflower_gif.setX(curr[0] - 70);
			sunflower_gif.setY(curr[1] - 50);
			System.out.println(e.getSource());
		}
	}

	@FXML
	public void move_CherryBomb(MouseEvent e) {
		// shooter_gif.setVisible(true);
		if (isPlaced == false) {
			double x = e.getX();
			double y = e.getY();
			double[] curr = lawn.correct_layout(x, y);
			CherryBomb_gif.setX(x - 70);
			CherryBomb_gif.setY(y - 50);
			System.out.println(e.getSource());
		}
	}

	@FXML
	public void move_walnut(MouseEvent e) {
		// shooter_gif.setVisible(true);

		if (isPlaced == false) {
			double x = e.getX() - 80;
			double y = e.getY() - 80;
			double[] curr = lawn.correct_layout(x, y);
			// if(x>)
			walnut_gif.setX(curr[0]);
			walnut_gif.setY(curr[1]);
			// walnut_gif.setX(x);
			// walnut_gif.setY(y);
			// System.out.println((e.getX()-80)+" "+(e.getY() - 80));
		}
		// if(isPlaced==true){
		// int lane=1;
		// Walnut w=new Walnut()
		// }
	}

	@FXML
	public void spawn_shooter(javafx.event.ActionEvent actionEvent) {
		if (sunCount >= 100) {
			pea_spawnable = true;
			Image i = new Image("shooter_gif.gif");
			shooter_gif = new ImageView(i);
			shooter_gif.setScaleX(0.5);
			shooter_gif.setScaleY(0.5);
			Anchor.getChildren().add(shooter_gif);
			sunCount = sunCount - 100;
			sun.setText("" + sunCount);
			curGif = 0;
			isPlaced = false;
			System.out.println(actionEvent.getSource());
		}
	}

	@FXML
	public void spawn_sunflower(javafx.event.ActionEvent actionEvent) {
		if (sunCount >= 50) {
			pea_spawnable = true;
			Image i = new Image("sunflower_gif.gif");
			sunflower_gif = new ImageView(i);
			sunflower_gif.setScaleX(0.5);
			sunflower_gif.setScaleY(0.5);
			Anchor.getChildren().add(sunflower_gif);
			sunCount = sunCount - 50;
			sun.setText("" + sunCount);
			checkOpacity();
			curGif = 1;
			isPlaced = false;
			System.out.println(actionEvent.getSource());
		}
	}

	@FXML
	public void spawn_CherryBomb(javafx.event.ActionEvent actionEvent) {
		if (sunCount >= 150) {
			pea_spawnable = true;
			Image i = new Image("CherryBomb_gif.gif");
			CherryBomb_gif = new ImageView(i);
			CherryBomb_gif.setScaleX(0.6);
			CherryBomb_gif.setScaleY(0.6);
			Anchor.getChildren().add(CherryBomb_gif);
			sunCount = sunCount - 150;
			sun.setText("" + sunCount);
			checkOpacity();
			curGif = 3;
			isPlaced = false;
			System.out.println(actionEvent.getSource());
		}
	}

	@FXML
	public void spawn_walnut(javafx.event.ActionEvent actionEvent) {
		if (sunCount >= 50) {
			pea_spawnable = true;
			Image i = new Image("walnut_gif.gif");
			walnut_gif = new ImageView(i);
			walnut_gif.setScaleX(0.7);
			walnut_gif.setScaleY(0.7);
			Anchor.getChildren().add(walnut_gif);
			sunCount = sunCount - 50;
			sun.setText("" + sunCount);
			checkOpacity();
			curGif = 2;
			isPlaced = false;
			System.out.println(actionEvent.getSource());
		}
	}

	public void checkOpacity() {
		if (sunCount < 50) {
			sidebar_sunflower.setOpacity(0.5);
			sidebar_walnut.setOpacity(0.5);
		} else {
			sidebar_sunflower.setOpacity(1);
			sidebar_walnut.setOpacity(1);
		}
		if (sunCount < 100) {
			sidebar_shooter.setOpacity(0.5);
		} else {
			sidebar_shooter.setOpacity(1);
		}

		if (sunCount < 150) {
			cherry_img.setOpacity(0.5);
		} else {
			cherry_img.setOpacity(1);
		}
		// repeeater_img.setOpacity(0.5);
		// cherry_img.setOpacity(0.5);

	}

	// public void put(MouseEvent e) {
	// isPlaced = true;
	// }

	public void FallingSun() {
		// slider.setTranslateX(0);
		moveSlider();
		// this.setupTimeline();
	}

	// 50,180,310,440,570
	@FXML
	public void inGameMenu(ActionEvent e) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("P1.fxml"));// Creates
																			// a
																			// Parent
																			// called
																			// loader
																			// and
																			// assign
																			// it
																			// as
																			// ScReen2.FXML

		Scene scene = new Scene(loader); // This creates a new scene called
											// scene and assigns it as the
											// Sample.FXML document which was
											// named "loader"
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TranslateTransition translatorObj = new TranslateTransition(Duration.seconds(38), zombie_gif);
		// translatorObj.setDuration(Duration.seconds(10));
		translatorObj.setToX(-880);
		translatorObj.setAutoReverse(true);
		// translatorObj.setCycleCount(Animation.INDEFINITE);

		translatorObj.play();
	}

	@FXML
	public void movelawnmover() {
		TranslateTransition translatorObj = new TranslateTransition(Duration.seconds(10), lawnmower);
		// translatorObj.setDuration(Duration.seconds(10));
		translatorObj.setToX(1200);
		// translatorObj.setAutoReverse(true);
		// translatorObj.setCycleCount(Animation.INDEFINITE);
		System.out.println("Click detected");
		// translatorObj.setCycleCount(Animation.INDEFINITE);

		translatorObj.play();
	}

	public void setupTimeline() {
		KeyFrame kf = new KeyFrame(Duration.seconds(10), new TimeHandler());
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	private class TimeHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			Random r = new Random();
			Image i = new Image("falling_sun.jpg");
			falling_sun = new ImageView(i);
			falling_sun.setLayoutX(Math.abs(r.nextInt()) % 900);
			falling_sun.setScaleY(0.5);
			falling_sun.setScaleX(0.5);
			falling_sun.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

			Anchor.getChildren().add(falling_sun);

			int c = Math.abs(r.nextInt());
			c = c % 5;
			TranslateTransition translatorObj = new TranslateTransition(Duration.seconds(3), falling_sun);
			translatorObj.setToY(+y_coord[c]);
			translatorObj.play();
		}

	}

	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			sunCount += 25;
			sun.setText("" + sunCount);
			Object i = e.getSource();

			// ImageView i=e.getSource();
			((ImageView) i).setVisible(false);
		}
	};

	public void put(MouseEvent e) {
		isPlaced = true;
		if (curGif == 0) {
			lawn.createObject(lawn.calcLane(shooter_gif.getY()), curGif, shooter_gif);
		} else if (curGif == 1) {
			lawn.createObject(lawn.calcLane(sunflower_gif.getY()), curGif, sunflower_gif);
		} else if (curGif == 2) {
			lawn.createObject(lawn.calcLane(walnut_gif.getY()), curGif, walnut_gif);
		}
		lawn.displayChar();
		if (pea_spawnable && curGif == 0) {
			ImageView img = new Pea().getPea();
			Anchor.getChildren().add(img);
			img.setX(e.getX() + 70);
			img.setY(e.getY() + 60);

			img.setX(e.getX() + 20.5);
			img.setY(e.getY() - 3);

			TranslateTransition translatorObj = new TranslateTransition(Duration.seconds(5), img);
			translatorObj.setToX(1200);
			translatorObj.setCycleCount(Animation.INDEFINITE);
			translatorObj.play();
			pea_spawnable = false;
		}
		Timeline t = new Timeline();

	}

	@FXML
	public void moveSlider() {

		Timeline task = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(slider.progressProperty(), 0)),
				new KeyFrame(Duration.seconds(60), new KeyValue(slider.progressProperty(), 1)));
		task.playFromStart();
	}

}
