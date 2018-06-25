package game.main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map extends Pane{

	private Rectangle rect;
	private double coorXmap;
	private double coorYmap;
	
	private double clickX;
	private double clickY;
	
	
	public Map(Pane root) {
		super();
		super.setTranslateX(0);
		super.setTranslateY(0);
		super.setWidth(1000);
		super.setHeight(1000);
		
		rect =new Rectangle();
		rect.setX(0);
		rect.setY(0);
		rect.setWidth(1000);
		rect.setHeight(1000);
		rect.setFill(Color.grayRgb(26));
		rect.setStroke(Color.BLACK);
		
		super.getChildren().add(rect);
		
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public double getCoorXmap() {
		return coorXmap;
	}

	public void setCoorXmap(double coorXmap) {
		this.coorXmap = coorXmap;
	}

	public double getCoorYmap() {
		return coorYmap;
	}

	public void setCoorYmap(double coorYmap) {
		this.coorYmap = coorYmap;
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
