package game.main;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * La minimap du jeu.
 *  
 * @author Melvin
 *
 */
public class MiniMap extends Pane{

	private Rectangle rect;
	private Rectangle rectVue;
	/**
	 * cree une minimap en fontion du conteneur parent.
	 * 
	 * @param root
	 */
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

	/**
	 * Cette methode permet de definir les bordures de l'objet et de voir si le click et dans cette zone.
	 * 
	 * @param controller le controlleur.
	 * @param e un MouseEvent.
	 * @return une Zone sous forme boolean.
	 */
	public static boolean isClick(Controller controller, MouseEvent e) {
		return e.getX() > controller.getBot().getMiniMap().getTranslateX() &&
		e.getX() < controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getPrefWidth() &&
		e.getY() > controller.getBot().getTranslateY() && 
		e.getY() < controller.getBot().getTranslateY()+controller.getBot().getPrefHeight();
	}
	
	// getters/setters
	
	public Rectangle getRectVue() {
		return rectVue;
	}

}
