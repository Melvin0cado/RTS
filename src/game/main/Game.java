package game.main;

import javax.sound.sampled.SourceDataLine;
import javax.sql.rowset.serial.SerialDatalink;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.skin.VirtualFlow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
	private ImageCursor cursor= new ImageCursor(new Image("./cursor.png"));
	
	private Pane root;
	private Controller controller = new Controller(root);
	
	private Parent createContent() {

		
		root = new BorderPane();
		root.setPrefSize(600, 600);
		
		controller.addCarre(new Carre(200,200));
		controller.addCarre(new Carre(400,200));
		controller.addCarre(new Carre(200,300));
		
		controller.render(root);
		
		
		
		root.setCursor(cursor);
		
		root.setOnMousePressed(new InputMouseClick(controller));
		root.setOnMouseDragged(new InputMouseDrag (controller));
		root.setOnMouseReleased(new InputMouseReleased(controller));
		
		Bottom bot = new Bottom(root);
		
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
		
		stage.show();

	}
	
	public void handle(MouseEvent event) {
		
		
	}

	public static void main(String[] args) {

		Application.launch(args);
	}

}
