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
import java.util.*;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class GameScreen4 extends Application {
	private ArrayList<TranslateTransition> translators = new ArrayList<>();
	public Button menu;
	private boolean isPaused = false;
	private boolean blank_click = true;
	private Stage primaryStage2;
	private ImageView sunflower_sun;

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
	// @FXML
	// public ImageView zombie_gif;
	@FXML
	public ImageView cherry_img;
	@FXML
	public ImageView repeeater_img;
	@FXML
	public ImageView falling_sun;
	@FXML
	public ImageView CherryBomb_gif;

	public ImageView lawnmower_0;

	public ImageView lawnmower_1;
	public ImageView lawnmower_2;
	public ImageView lawnmower_3;
	public ImageView lawnmower_4;

	public Lawn lawn = new Lawn(0, 3);
	private int zombie_count = Lawn.LevelZombieCount.get(lawn.level);
	private int zombie_killed = zombie_count;// No. of Zombies to be killed to
												// complete level

	private int[] y_coord = { 50, 180, 310, 420, 540 };

	private double lastrun = 0.0;

	@FXML
	public ProgressBar slider;
	private boolean isPlaced = false;

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
	private ArrayList<Shooter> pea_imageView = new ArrayList<>();
	private ArrayList<TranslateTransition> pea_translate = new ArrayList<>();

	public GameScreen4() throws CloneNotSupportedException {

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
			// System.out.println(e.getSource());
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
			// System.out.println(e.getSource());
		}
	}

	@FXML
	public void move_CherryBomb(MouseEvent e) {
		// shooter_gif.setVisible(true);
		if (isPlaced == false) {
			double x = e.getX();
			double y = e.getY();
			double[] curr = lawn.correct_layout(x, y);
			CherryBomb_gif.setX(curr[0] - 70);
			CherryBomb_gif.setY(curr[1] - 50);
			// System.out.println(e.getSource());
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
	}

	@FXML
	public void spawn_shooter(javafx.event.ActionEvent actionEvent) {
		if (lawn.SunCount >= 100) {
			pea_spawnable = true;
			Image i = new Image("shooter_gif.gif");

			shooter_gif = new ImageView(i);
			shooter_gif.setScaleX(0.5);
			shooter_gif.setScaleY(0.5);
			Anchor.getChildren().add(shooter_gif);

			lawn.SunCount = lawn.SunCount - 100;
			sun.setText("" + lawn.SunCount);
			checkOpacity();
			curGif = 0;
			isPlaced = false;
			blank_click = false;
			// System.out.println(actionEvent.getSource());
		}
	}

	@FXML
	public void spawn_sunflower(javafx.event.ActionEvent actionEvent) {
		if (lawn.SunCount >= 50) {
			pea_spawnable = true;
			Image i = new Image("sunflower_gif.gif");
			sunflower_gif = new ImageView(i);
			sunflower_gif.setScaleX(0.5);
			sunflower_gif.setScaleY(0.5);
			Anchor.getChildren().add(sunflower_gif);
			lawn.SunCount = lawn.SunCount - 50;
			sun.setText("" + lawn.SunCount);
			checkOpacity();
			curGif = 1;
			isPlaced = false;
			blank_click = false;

			// System.out.println(actionEvent.getSource());
		}
	}

	@FXML
	public void spawn_CherryBomb(javafx.event.ActionEvent actionEvent) {
		if (lawn.SunCount >= 150) {
			pea_spawnable = true;
			Image i = new Image("CherryBomb_gif.gif");
			CherryBomb_gif = new ImageView(i);
			CherryBomb_gif.setScaleX(0.4);
			CherryBomb_gif.setScaleY(0.4);
			Anchor.getChildren().add(CherryBomb_gif);
			lawn.SunCount = lawn.SunCount - 150;
			sun.setText("" + lawn.SunCount);
			checkOpacity();
			curGif = 3;
			isPlaced = false;
			blank_click = false;
			// System.out.println(actionEvent.getSource());
		}
	}

	@FXML
	public void spawn_walnut(javafx.event.ActionEvent actionEvent) {
		if (lawn.SunCount >= 50) {
			pea_spawnable = true;
			Image i = new Image("walnut_gif.gif");
			walnut_gif = new ImageView(i);
			walnut_gif.setScaleX(0.7);
			walnut_gif.setScaleY(0.7);
			Anchor.getChildren().add(walnut_gif);
			lawn.SunCount = lawn.SunCount - 50;
			sun.setText("" + lawn.SunCount);
			checkOpacity();
			curGif = 2;
			isPlaced = false;
			blank_click = false;
			// System.out.println(actionEvent.getSource());
		}
	}

	public void checkOpacity() {
		// if (lawn.SunCount < 50) {
		// sidebar_sunflower.setOpacity(0.5);
		// sidebar_walnut.setOpacity(0.5);
		// sidebar_shooter.setOpacity(0.5);
		// cherry_img.setOpacity(0.5);
		// }

		if (lawn.SunCount < 100) {
			sidebar_shooter.setOpacity(0.5);
			cherry_img.setOpacity(0.5);
			sidebar_sunflower.setOpacity(1);
			sidebar_walnut.setOpacity(1);
		}

		else if (lawn.SunCount < 150) {
			// cherry_img.setOpacity(0.5);
			sidebar_shooter.setOpacity(1);
			cherry_img.setOpacity(0.5);
			sidebar_sunflower.setOpacity(1);
			sidebar_walnut.setOpacity(1);

		} else {
			cherry_img.setOpacity(1);
			sidebar_shooter.setOpacity(1);
			// cherry_img.setOpacity(0.5);
			sidebar_sunflower.setOpacity(1);
			sidebar_walnut.setOpacity(1);
		}
		// repeeater_img.setOpacity(0.5);
		// cherry_img.setOpacity(0.5);

	}

	// public void put(MouseEvent e) {
	// isPlaced = true;
	// }

	public void FallingSun() {
		checkOpacity();
		slider.setTranslateX(0);
		moveSlider();
		this.setupTimeline();
		setupSunflowerSunTimeline();
		setupLawnmowers();
	}

	// 50,180,310,440,570
	@FXML
	public void inGameMenu(ActionEvent e) throws IOException, InterruptedException {
		if (!isPaused) {
			for (TranslateTransition i : translators) {
				i.pause();
			}
			isPaused = true;
			primaryStage2 = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("P1.fxml"));
			Scene scene = new Scene(root);
			this.primaryStage2.setTitle("Pause Screen");
			this.primaryStage2.setScene(scene);
			this.primaryStage2.showAndWait();
			for (TranslateTransition i : translators) {
				i.play();
			}
			isPaused = false;
		}
	}

	public void setupTimeline() {
		KeyFrame kf = new KeyFrame(Duration.seconds(20), new TimeHandler());
		Timeline timeline = new Timeline(kf);

		KeyFrame kfz = new KeyFrame(Duration.seconds(2), new ZombieTimeHandler());
		Timeline timelinezombies = new Timeline(kfz);

		KeyFrame kfp = new KeyFrame(Duration.millis(100), new PeaHandler());
		Timeline timelinepea = new Timeline(kfp);

		timelinezombies.setCycleCount(Animation.INDEFINITE);
		timeline.setCycleCount(Animation.INDEFINITE);
		timelinepea.setCycleCount(Animation.INDEFINITE);

		timelinezombies.play();
		timeline.play();
		timelinepea.play();

		// System.out.println(1);
	}

	private class PeaHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			for (Character c : lawn.getActiveChars()) {
				if (c instanceof Shooter) {

					for (Zombie r : lawn.getZombie_arr()) {

						if (r.getLane() == c.getLane()) {
							// ((Shooter)
							// c).getMypea().getPea().setX(c.getImage().getX()+100);
							// ((Shooter)
							// c).getMypea().getPea().setY(c.getImage().getY()+80);
							// ((Shooter)
							// c).getMypea().getPea().setVisible(true);

							int n = pea_imageView.indexOf(c);
							((Shooter) c).getMypea().getPea().setX((((Shooter) c).getMypea().getPea()).getX() + 5);
							if (((Shooter) c).getMypea().getPea().getX() > r.getImage().getX()) {
								r.takeDamage(1);
								if (!r.isExists()) {
									r.getImage().setVisible(false);
								}
								((Shooter) c).getMypea().getPea().setVisible(false);
								((Shooter) c).getMypea().getPea().setX(c.getImage().getX() + 100);
								((Shooter) c).getMypea().getPea().setY(c.getImage().getY() + 80);
								((Shooter) c).getMypea().getPea().setVisible(true);
							}
						}
					}
				}
				ArrayList<Zombie> removal = new ArrayList<>();
				for (Zombie z : lawn.getZombie_arr()) {
					if (!z.isExists()) {
						removal.add(z);
					}
				}
				for (Zombie i : removal) {
					lawn.getActiveChars().remove(i);
					lawn.getZombie_arr().remove(i);
				}

			}
		}
	}

	private class ZombieTimeHandler implements EventHandler<ActionEvent> {

		private ImageView getZombiegif(int type) {
			if (type == 0) {
				return new ImageView("zombie_normal.gif");
			} else {
				return new ImageView("Conehead_Zombie.gif");
			}
		}

		public void handle(ActionEvent event) {
			if (!isPaused) {
				if (System.currentTimeMillis() - lastrun > 30000 && zombie_count > 0) {
					System.out.println("spawning zombie");
					lastrun = System.currentTimeMillis();
					Random r = new Random();
					int lane = r.nextInt(5);
					int zombie_type = r.nextInt(2);// TODO -> change to 4

					ImageView im = getZombiegif(zombie_type);
					lawn.SpawnZombies(zombie_type, lane, im);
					im.setX(900);
					im.setY(lawn.getSpawn_points()[lane]);
					System.out.println("Adding Now");
					Anchor.getChildren().add(im);
					zombie_count--;

				}
				for (Zombie z : lawn.getZombie_arr()) {
					if (z.getImage().getX() < 50 && lawn.getLawnMowers().get(z.getLane()) == null) {
						System.out.println("Game Lost");
						restart_game();
						// break;
					}
					for (LawnMower l : lawn.getLawnMowers()) {
						if (l != null) {
							if (z.getImage().getX() < l.getImage().getX() + 200 && z.getLane() == l.getLane()) {
								System.out.println("Clear 1");
								setLawnMower(l.getLane());
								clearLane(l.getLane());

							}
						}
					}
				}
				// boolean stop = false;
				for (Zombie z : lawn.getZombie_arr()) {
					if (!isPaused) {
						ImageView im = z.getImage();
						double x = im.getX();
						if (x < 50 && lawn.getLawnMowers().get(z.getLane()) == null) {
							System.out.println("Game Lost");
							restart_game();
							// break;
						}
						// System.out.println(x);
						if (!z.isStop()) {
							// im.setTranslateX(x - 10);//Moving the zombie by 1
							im.setX(x - 15);
						}
						ArrayList<Integer> removal = new ArrayList<>();
						for (Character p : lawn.getActiveChars()) {
							if (p instanceof Plant) {
								if (im.getLayoutBounds().intersects(p.getImage().getLayoutBounds())
										&& p.getLane() == z.getLane()) {
									System.out.println("True");
									z.setStop(true);
									System.out.println("condition met");
									try {
										((Defend) p).takeDamage(z);
									} catch (Exception e) {
										System.out.println("Cherry bomb");
									}
								}
								// System.out.println("Plant health=
								// "+p.health);

							}
							removal = lawn.checkPlantStatus();
						}
						for (int i : removal) {
							lawn.getActiveChars().remove(i);
						}

					}
				}

				for (Character i : lawn.getActiveChars()) {
					if (i instanceof Cherrybomb) {
						double x = i.getImage().getX();
						double y = i.getImage().getY();
						for (Zombie z : lawn.getZombie_arr()) {
							if (z.getImage().getX() < x + 60 || z.getImage().getY() < y + 60) {
								z.setExists(false);
								z.getImage().setVisible(false);
							}
						}
						i.setExists(false);
						i.getImage().setVisible(false);
					}
				}
				lawn.removeDeadZombies();
				for (int i = 0; i < lawn.getActiveChars().size(); i++) {
					if (lawn.getActiveChars().get(i) instanceof Cherrybomb) {
						lawn.getActiveChars().remove(i);
					}
				}
			}

			if (lawn.getZombie_arr().size() == 0 && zombie_count <= 0) {
				lawn.setLevelChangeNeeded(true);
				System.out.println("In If Block");
				// change_level();
				try {
					throw new LevelWonException();
				} catch (Exception e) {
					// try {
					// if (lawn.isLevelChangeNeeded()) {
					// lawn.setLevelChangeNeeded(false);
					// if (lawn.level == 0) {
					// lawn.level = 1;
					// lawn.SunCount = 0;
					// lawn.zombietarget = 2;
					// lawn.ResetLawn();
					// zombie_count = 2;
					// zombie_killed = 2;
					// change_level();
					// } else if (lawn.level == 1) {
					// lawn.level = 2;
					// lawn.SunCount = 0;
					// lawn.zombietarget = 3;
					// lawn.ResetLawn();
					// zombie_count = 3;
					// zombie_killed = 3;
					// change_level();
					// } else if (lawn.level == 2) {
					// lawn.level = 3;
					// lawn.SunCount = 0;
					// lawn.zombietarget = 4;
					// lawn.ResetLawn();
					// zombie_count = 4;
					// zombie_killed = 4;
					// change_level();
					// } else if (lawn.level == 3) {
					// lawn.level = 4;
					// lawn.SunCount = 0;
					// lawn.zombietarget = Lawn.LevelZombieCount.get(4);
					// lawn.ResetLawn();
					// zombie_count = lawn.zombietarget;
					// zombie_killed = lawn.zombietarget;
					// change_level();
					// }
					//
					// }
					// } catch (IOException ex) {
					// ex.printStackTrace();
					// } catch (CloneNotSupportedException ex) {
					// ex.printStackTrace();
					// }
					System.out.println(e.getMessage());
					// LoadnextLevel
				}
			}

			int lane = -1;
			// for(Character c: lawn.getActiveChars()){
			// if(c instanceof Shooter){
			// for(Zombie r: lawn.getZombie_arr()){
			// if(r.getLane()==c.getLane()){
			// int n=pea_imageView.indexOf(c);
			// TranslateTransition translatorObj=pea_translate.get(n);
			// translatorObj.stop();
			// translatorObj.setFromX(c.getImage().getX()+100);
			// translatorObj.setToX(r.getImage().getX()-400);
			// translatorObj.setDuration(Duration.seconds(2));
			// translatorObj.setCycleCount(1);
			//// translatorObj.setCycleCount(Animation.INDEFINITE);
			// translatorObj.playFromStart();
			//
			//// tra/nslatorObj.play();
			// }
			// }
			// }
			// }
		}
	}

	public void setLawnMower(int lane) {
		if (lane == 0) {
			movelawnmover(lawnmower_0);
		} else if (lane == 1) {
			movelawnmover(lawnmower_1);
		} else if (lane == 2) {
			movelawnmover(lawnmower_2);
		} else if (lane == 3) {
			movelawnmover(lawnmower_3);
		} else if (lane == 4) {
			movelawnmover(lawnmower_4);
		}
		lawn.getLawnMowers().set(lane, null);

	}

	@FXML
	public void movelawnmover(ImageView lawnmower) {
		TranslateTransition translatorObj = new TranslateTransition(Duration.seconds(10), lawnmower);
		translators.add(translatorObj);
		// translatorObj.setDuration(Duration.seconds(10));
		translatorObj.setToX(1200);
		translatorObj.play();
	}

	public void clearLane(int l) {
		for (Zombie z : lawn.getZombie_arr()) {
			if (z.getLane() == l) {
				System.out.println("Clear 2");
				z.setExists(false);
				z.getImage().setVisible(false);
			}
		}
		lawn.removeDeadZombies();
	}

	private class TimeHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			Random r = new Random();

			if (!isPaused) {
				Image i = new Image("falling_sun.jpg");
				falling_sun = new ImageView(i);
				falling_sun.setLayoutX(Math.abs(r.nextInt()) % 900);
				falling_sun.setScaleY(0.5);
				falling_sun.setScaleX(0.5);
				falling_sun.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
				Anchor.getChildren().add(falling_sun);

				int c = Math.abs(r.nextInt());
				c = c % 5;
				TranslateTransition translatorObj = new TranslateTransition(Duration.seconds(5), falling_sun);
				translators.add(translatorObj);
				translatorObj.setToY(+(lawn.getY_coord())[c]);
				translatorObj.play();
			}

		}

	}

	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			if (!isPaused) {
				lawn.SunCount += 25;
				sun.setText("" + lawn.SunCount);
				Object i = e.getSource();

				// ImageView i=e.getSource();
				((ImageView) i).setVisible(false);
				checkOpacity();
			}
		}
	};

	public void put(MouseEvent e) {
		isPlaced = true;
		if (!blank_click) {
			if (curGif == 0) {
				System.out.println(shooter_gif.getY());
				Shooter p = (Shooter) (lawn.createObject(lawn.calcLane(shooter_gif.getY() + 50), curGif, shooter_gif));
				spawn_pea(p);
			} else if (curGif == 1) {

				// System.out.println("Hey");
				lawn.createObject(lawn.calcLane(sunflower_gif.getY() + 50), curGif, sunflower_gif);
			} else if (curGif == 2) {
				lawn.createObject(lawn.calcLane(walnut_gif.getY()), curGif, walnut_gif);
			} else if (curGif == 3) {
				lawn.createObject(lawn.calcLane(CherryBomb_gif.getY() + 50), curGif, CherryBomb_gif);
			}
			blank_click = true;
		}
		lawn.displayChar();
		// System.out.println(lawn.getActiveChars().size());
		// if (pea_spawnable && curGif == 0) {
		// ImageView img = new Pea().getPea();
		//
		// Anchor.getChildren().add(img);
		// img.setX(shooter_gif.getX()+120);
		// img.setY(shooter_gif.getY()+80);
		// TranslateTransition translatorObj = new
		// TranslateTransition(Duration.seconds(5), img);
		// translators.add(translatorObj);
		// translatorObj.setToX(1200);
		// translatorObj.setCycleCount(Animation.INDEFINITE);
		// translatorObj.play();
		//
		// pea_spawnable = false;
		// }
		Timeline t = new Timeline();

	}

	@FXML
	public void moveSlider() {

		Timeline task = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(slider.progressProperty(), 0)),
				new KeyFrame(Duration.seconds(60), new KeyValue(slider.progressProperty(), 1)));
		task.playFromStart();
	}

	public void giveSun(ImageView image) {
		if (!isPaused) {
			Image i = new Image("falling_sun.jpg");
			falling_sun = new ImageView(i);
			// falling_sun.setLayoutX(Math.abs(r.nextInt()) % 900);

			falling_sun.setScaleY(0.5);
			falling_sun.setScaleX(0.5);

		}
	}

	private class SunflowerHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			// Random r = new Random();

			if (!isPaused) {
				// ArrayList<ImageView> a=new ArrayList<>();
				Image i = new Image("falling_sun.jpg");

				// sunflower_sun.setLayoutX(sunflower_gif.getX());
				// sunflower_sun.setLayoutY(sunflower_gif.getY());
				for (Character p : lawn.getActiveChars()) {
					if (p instanceof Sunflower) {
						sunflower_sun = new ImageView(i);
						sunflower_sun.setLayoutX((p.getPosition())[0]);
						sunflower_sun.setLayoutY((p.getPosition())[1]);
						sunflower_sun.setScaleY(0.5);
						sunflower_sun.setScaleX(0.5);
						sunflower_sun.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
						Anchor.getChildren().add(sunflower_sun);

						// int c = Math.abs(r.nextInt());
						// c = c % 5;
						TranslateTransition translatorObj = new TranslateTransition(Duration.seconds(1), sunflower_sun);
						translators.add(translatorObj);
						translatorObj.setToY(sunflower_sun.getY() + 45);
						translatorObj.play();
						// a.add(sunflower_sun);
					}
				}

			}

		}

	}

	public void setupSunflowerSunTimeline() {
		KeyFrame kf = new KeyFrame(Duration.seconds(5), new SunflowerHandler());
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	public void spawn_pea(Shooter s) {
		if (pea_spawnable && curGif == 0) {
			Pea p = new Pea();
			ImageView img = p.getPea();
			s.setMypea(p);
			Anchor.getChildren().add(img);
			img.setX(s.getImage().getX() + 100);
			img.setY(s.getImage().getY() + 80);
			// TranslateTransition translatorObj = new
			// TranslateTransition(Duration.seconds(5), img);
			// translators.add(translatorObj);;
			// translatorObj.setToX(1200);
			// translatorObj.setCycleCount(Animation.INDEFINITE);
			// translatorObj.play();
			pea_imageView.add(s);
			// pea_translate.add(translatorObj);
			pea_spawnable = false;
			Timeline t = new Timeline();

		}
	}

	public void restart_game() {
		primaryStage.close();
	}

	public void setupLawnmowers() {
		if (!lawn.isLawnmowerSetup())
			lawn.getLawnMowers().get(0).setImage(lawnmower_0);
		lawn.getLawnMowers().get(1).setImage(lawnmower_1);
		lawn.getLawnMowers().get(2).setImage(lawnmower_2);
		lawn.getLawnMowers().get(3).setImage(lawnmower_3);
		lawn.getLawnMowers().get(4).setImage(lawnmower_4);
		lawn.setLawnmowerSetup(true);

	}

	// public void change_level() throws IOException, CloneNotSupportedException
	// {
	// Stage stage = (Stage) menu.getScene().getWindow();
	// stage.close();
	// Stage ps2=new Stage();
	// this.lawn = new Lawn(this.lawn.level + 1, 0);
	// Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
	// Scene scene = new Scene(root);
	// ((Stage) Anchor.getScene().getWindow()).setTitle("Game Screen");
	// ((Stage) Anchor.getScene().getWindow()).setScene(scene);
	// primaryStage.show();
	// System.out.println("New lawn");
	//
	// }

}
