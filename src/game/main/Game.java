package game.main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {
	private ImageCursor cursor= new ImageCursor(new Image("./cursor.png"));
	
	private Pane root;
	private Controller controller = new Controller(root);
	Rectangle rectBis;
	private Parent createContent() {

		
		root = new BorderPane();
		root.setPrefSize(600, 600);
		
		rectBis = new Rectangle();
		rectBis.setX(0);
		rectBis.setY(0);
		rectBis.setWidth(1000);
		rectBis.setHeight(1000);
		rectBis.setFill(Color.grayRgb(26));
		root.getChildren().add(rectBis);
				
		controller.addCarre(new Carre(200,200, controller));
		controller.addCarre(new Carre(400,200, controller));
		controller.addCarre(new Carre(200,300, controller));
		controller.addCarre(new Carre(230,230, controller));
		controller.addCarre(new Carre(430,230, controller));
		controller.addCarre(new Carre(270,370, controller));
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

	public static void main(String[] args) {

		Application.launch(args);
	}

}
