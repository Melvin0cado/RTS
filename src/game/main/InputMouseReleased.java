package game.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * Cette classe permet d'interagir en relachant un click de la souris.
 * 
 * @author Melvin
 *
 */
public class InputMouseReleased implements EventHandler<MouseEvent> {

	private Controller controller;
	private RectSelect rect ;
	
	public InputMouseReleased( Controller controller){
		this.controller = controller; 
		this.rect =  controller.getRect();
		
	}
	
	@Override
	public void handle(MouseEvent e) {
		
		
		if(e.getButton() == MouseButton.PRIMARY) {
			Physics.CollisionCarreVSRect(controller);
			
		}
		rect.setX(0);
		rect.setY(0);
		rect.setWidth(0);
		rect.setHeight(0);
		
	}

}
