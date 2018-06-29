package game.main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MiniMap extends Pane{

	private Rectangle rect;
	private Rectangle rectVue;
	
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
		
		rectVue = new Rectangle();
		rectVue.setX(0);
		rectVue.setY(0);
		rectVue.setFill(Color.TRANSPARENT);
		rectVue.setStroke(Color.BLACK);
		
		super.getChildren().add(rect);
		super.getChildren().add(rectVue);
		
	}

	public Rectangle getRectVue() {
		return rectVue;
	}

	public void setRectVue(Rectangle rectVue) {
		this.rectVue = rectVue;
	}
	
		
	
}
