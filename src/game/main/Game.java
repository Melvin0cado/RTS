package game.main;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.Toolkit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Cette classe permet de creer la fenetre principale et de lancer le jeu.
 * 
 * @author Melvin
 *
 */
public class Game extends Application {
	// private ImageCursor cursor= new ImageCursor(new Image("./cursor.png"));
	
	private Pane root;
	private Controller controller ;
	private Dimension dimensionEcran = Toolkit.getDefaultToolkit().getScreenSize();
	private double widthEcran = dimensionEcran.getWidth();
	private double heightEcran = dimensionEcran.getHeight();
	
	/**
	 * Cette methode cree la fenetre  en fonction de l'ecran.</br>
	 * Elle contient la boucle de jeu.
	 * 
	 * @return un conteneur. (Parent)
	 */
	private Parent createContent() {

		double fenetreWidth = widthEcran*0.51471;
		double fenetreHeight =  heightEcran*0.908;
				
		root = new Pane();
		root.setPrefSize(fenetreWidth, fenetreHeight);
		
		controller = new Controller(root);
		controller.addCarre(new Carre(200,200,Color.BLUE, controller));
		controller.addCarre(new Carre(400,200,Color.RED, controller));
		
		
		System.out.println(controller.getMap().getChildren().toString());
		
		root.getChildren().add(controller.getMap());
		root.getChildren().add(controller.getBot());
		root.getChildren().add(controller.getRect());
		
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
	
	/**
	 * Cette methode contient l'update du controlleur pricipale.
	 * 
	 */
	private void onUpdate() {

		controller.uptdate();
		
	}

	/**
	 * Cette methode permet de creer la scene et de lui attribuer quelque caracteristique.
	 */
	@Override
	public void start(Stage stage) throws Exception {

		Scene scene = new Scene(createContent());
		
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.setResizable(false);
		stage.show();

	}

	/**
	 * La methode principale lance l'application. 
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		Application.launch(args);
	}
}
