package game.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
	// private ImageCursor cursor= new ImageCursor(new Image("./cursor.png"));
	
	private Pane root;
	private Controller controller ;
	private Dimension dimensionEcran = Toolkit.getDefaultToolkit().getScreenSize();
	private double widthEcran = dimensionEcran.getWidth();
	private double heightEcran = dimensionEcran.getHeight();
	
	private Parent createContent() {

		
		double fenetreWidth = widthEcran*0.51471;
		double fenetreHeight =  heightEcran*0.908;
				
		root = new Pane();
		root.setPrefSize(fenetreWidth, fenetreHeight);
		
		
		controller = new Controller(root);
		controller.addCarre(new Carre(200,200,Color.BLUE, controller));
		controller.addCarre(new Carre(400,200,Color.BLUE, controller));
		controller.addCarre(new Carre(200,300,Color.BLUE, controller));
		controller.addCarre(new Carre(230,230,Color.BLUE, controller));
		controller.addCarre(new Carre(430,230,Color.BLUE, controller));
		controller.addCarre(new Carre(270,370,Color.BLUE, controller));
		
	
		root.getChildren().add(controller.getMap());
		root.getChildren().add(controller.getBot());
		root.getChildren().add(controller.getRect());
		
		controller.render(controller.getMap());
		
		//root.setCursor(cursor);
		
		root.setOnMousePressed(new InputMouseClick(controller));
		root.setOnMouseDragged(new InputMouseDrag (controller));
		root.setOnMouseReleased(new InputMouseReleased(controller));
		
		AnimationTimer timer = new AnimationTimer() { // boucle de jeu.

			@Override
			public void handle(long now){
				onUpdate();
			}
		};
		timer.start();

		return root;
	}

	private void onUpdate() {

		controller.uptdate();
		
	}

	@Override
	public void start(Stage stage) throws Exception {

		Scene scene = new Scene(createContent());
		
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.setResizable(false);
		stage.show();

	}

	public static void main(String[] args) {

		Application.launch(args);
	}

}
