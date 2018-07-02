package game.main;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Cette classe permet d'ajouter un rectangle de sellection.
 * 
 * @author Melvin
 *
 */
public class RectSelect extends Rectangle{

	private double clickX;
	private double clickY;
	
	/**
	 * cree le rectangle de selection et le pose dans en dehors de la map pour l'utiliser plus tard. 
	 * 
	 * @param x la position en X.
	 * @param y la position en Y.
	 * @param width sa longueur selon X.
	 * @param height sa longueur selon Y.
	 * @param root son conteneur parent.
	 * @param controller le controlleur.
	 */
	public RectSelect(double x, double y, double width, double height , Pane root , Controller controller) {
		super();
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setFill(Color.TRANSPARENT);
		this.setStroke(Color.rgb(0, 0, 0));
		
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
