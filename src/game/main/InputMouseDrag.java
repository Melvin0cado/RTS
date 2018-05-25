package game.main;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class InputMouseDrag implements EventHandler<MouseEvent>{

	private RectSelect rect;
	
	
	public InputMouseDrag(Controller controller) {

		this.rect = controller.getRect();
		
	}
	
	@Override
	public void handle(MouseEvent e) {

		if(e.isPrimaryButtonDown()) {
			
			if(e.getX() > rect.getClickX() && e.getY() > rect.getClickY()) {
				rect.setWidth(e.getX()-rect.getClickX());
				rect.setHeight(e.getY()-rect.getClickY());
			}else if(e.getX() < rect.getClickX() && e.getY() < rect.getClickY()) {
				rect.setX(e.getX());
				rect.setY(e.getY());
				rect.setWidth(rect.getClickX()-e.getX());
				rect.setHeight(rect.getClickY()-e.getY());
				
			}else if(e.getX() > rect.getClickX() && e.getY() < rect.getClickY()) {
				rect.setWidth(e.getX()-rect.getClickX());
				rect.setY(e.getY());
				rect.setHeight(rect.getClickY()-e.getY());
			}else if(e.getX() < rect.getClickX() && e.getY() > rect.getClickY()) {
				rect.setHeight(e.getY()-rect.getClickY());
				rect.setX(e.getX());
				rect.setWidth(rect.getClickX()-e.getX());
			}
		}
	}

}
