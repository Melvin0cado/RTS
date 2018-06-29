package game.main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MiniMap extends Pane{

	private Rectangle rect;
	
	public MiniMap(Pane root) {
		super();
		super.setTranslateX(root.getPrefWidth()-root.getPrefHeight()+2);
		super.setTranslateY(0);
		super.setPrefWidth(root.getPrefHeight());
		super.setPrefHeight(root.getPrefHeight());
		
		rect = new Rectangle();
		rect.setX(0);
		rect.setY(0);
		rect.setWidth(super.getPrefWidth());
		rect.setHeight(super.getPrefHeight());
		rect.setFill(Color.grayRgb(26));
		rect.setStroke(Color.BLACK);
		
		super.getChildren().add(rect);
		
	}
	
	
}
