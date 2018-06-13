package game.main;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bottom extends Pane{

	private Rectangle rectangle;
	private HBox hb;
	private HBox hb2;
	
	private Button b1;

	public Bottom(Pane root) {
		super();
		rectangle = new Rectangle();
		rectangle.setFill(Color.gray(0.7));
		rectangle.setWidth(root.getPrefWidth());
		rectangle.setHeight(root.getPrefHeight()*0.2);
		
		b1 = new Button("Bouton 1");
		b1.getHeight();
		b1.setPrefSize(100, 30);
		b1.setMaxSize(100, 30);
		b1.setMinSize(100, 30);
		
		
		super.setTranslateX(0);
		super.setTranslateY(root.getPrefHeight()*0.8);
		super.setPrefWidth(root.getPrefHeight());
		super.setPrefHeight(root.getPrefHeight()*0.2);
		
		hb2 = new HBox();
		hb2.setTranslateX(0);
		hb2.setTranslateY(root.getPrefHeight()*0.8);
		hb2.setPrefWidth(root.getPrefHeight());
		hb2.setPrefHeight(root.getPrefHeight()*0.2);
		
		root.getChildren().add(this);
		root.getChildren().add(hb2);
		super.getChildren().add(rectangle);
		hb2.getChildren().add(b1);
		
	}
	
	
	
	
}
