package game.main;

import javax.swing.border.Border;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {

	private Pane root;
	Controller controller = new Controller(root);
	
	private Parent createContent() {

		root = new Pane();
		root.setPrefSize(600, 600);
		
		controller.addCarre(new Carre(200,200));
		controller.addCarre(new Carre(400,200));
		controller.addCarre(new Carre(200,300));
		
		controller.render(root);
		
		root.setOnMousePressed(new InputMouseClick(controller));
		root.setOnMouseDragged(new InputMouseDrag (controller));
		root.setOnMouseReleased(new InputMouseReleased(controller));
		
		HBox hb = new HBox();
	
		BorderPane bp = new BorderPane();
		bp.setBottom(hb);
		bp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE*0.2);
		Button b1 = new Button("Test");
		
		bp.getChildren().add(b1);
		
		root.getChildren().add(hb);
		
		
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
