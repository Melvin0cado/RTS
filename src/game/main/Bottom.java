package game.main;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * L'IHM contenant la minimap et des boutons d'interaction changeant en fonction de l'objet selectionnee.
 * 
 * @author Melvin
 *
 */
public class Bottom extends Pane{

	private Rectangle rectangle;
	private MiniMap miniMap;

	/**
	 * Ce construteur cree les elements necessaire en fonction de son element parent.
	 * 
	 * @param root -> l'element parent.
	 */
	public Bottom(Pane root) {
		super();
		super.setTranslateX(0);
		System.out.println(root.getPrefHeight()*0.2);
		super.setTranslateY(root.getPrefHeight()*0.8);
		super.setPrefWidth(root.getPrefHeight());
		super.setPrefHeight(root.getPrefHeight()*0.2);
		
		rectangle = new Rectangle();
		rectangle.setFill(Color.gray(0.7, 0.95));
		rectangle.setWidth(root.getPrefWidth());
		rectangle.setHeight(root.getPrefHeight()*0.2);
		
		miniMap = new MiniMap(this);
		
		super.getChildren().add(rectangle);
		super.getChildren().add(miniMap);
		
	}

	/**
	 * Cette methode static permet de definir les bordure de cette objet et de voir si le click et dans cette zone.
	 * 
	 * @param controller le controlleur.
	 * @param e un MouseEvent.
	 * @return une Zone sous forme boolean
	 */
	public static boolean isClick(Controller controller, MouseEvent e) {
		
		return e.getX() > controller.getBot().getTranslateX() && //cote gauche 
				e.getX() < controller.getBot().getTranslateX()+controller.getBot().getPrefWidth() && //cote droit 
				e.getY() > controller.getBot().getTranslateY() && //en haut
				e.getY() < controller.getBot().getTranslateY()+controller.getBot().getPrefHeight() ; //en bas
	}
	
	public MiniMap getMiniMap() {
		return miniMap;
	}
}
