package game.main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map extends Pane{

	private Rectangle rect;
	
	public Map(Pane root) {
		super();
		super.setTranslateX(0);
		super.setTranslateY(0);
		
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
	
	
	
}
