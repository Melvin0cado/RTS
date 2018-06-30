package game.main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map extends Pane{

	private Rectangle rect;
	
	private double clickX;
	private double clickY;
	
	public Map(Pane root) {
		super();
		super.setTranslateX(0);
		super.setTranslateY(0);
		super.setWidth(2000);
		super.setHeight(2000);
		super.setPrefWidth(2000);
		super.setPrefHeight(2000);
		rect =new Rectangle();
		rect.setX(0);
		rect.setY(0);
		rect.setWidth(super.getPrefWidth());
		rect.setHeight(super.getPrefHeight());
		rect.setFill(Color.grayRgb(26));
		rect.setStroke(Color.BLACK);
		
		super.getChildren().add(rect);
				
	}
	
	public double getClickX() {
		return clickX;
	}

	public void setClickX(double clickX) {
		this.clickX = clickX;
	}

	public double getClickY() {
		return clickY;
	}

	public void setClickY(double clickY) {
		this.clickY = clickY;
	}
	
	
	
}
