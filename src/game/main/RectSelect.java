package game.main;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class RectSelect extends Rectangle{

	private double clickX;
	private double clickY;
	
	public RectSelect(double x, double y, double width, double height , Pane root , Controller controller) {
		super();
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setFill(Color.TRANSPARENT);
		this.setStroke(Color.rgb(0, 0, 0));
		
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
