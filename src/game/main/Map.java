package game.main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * La map jeu.
 * 
 * @author Melvin
 *
 */
public class Map extends Pane{

	private Rectangle rect;
	
	private double clickX;
	private double clickY;
	private final double tailleMap = 2000;
	/**
	 * cree la map et le place dans le conteneur parent.
	 * 
	 * @param root le conteneur parent.
	 * 
	 */
	public Map() {
		super();
		super.setTranslateX(0);
		super.setTranslateY(0);
		super.setWidth(tailleMap);
		super.setHeight(tailleMap);
		super.setPrefWidth(tailleMap);
		super.setPrefHeight(tailleMap);
		rect = new Rectangle();
		rect.setX(0);
		rect.setY(0);
		rect.setWidth(super.getPrefWidth());
		rect.setHeight(super.getPrefHeight());
		rect.setFill(Color.grayRgb(26));
		rect.setStroke(Color.BLACK);
		
		super.getChildren().add(rect);
				
	}
	
	// getters/setters
	
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
