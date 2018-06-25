package game.main;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;


public class InputMouseDrag implements EventHandler<MouseEvent>{

	private double clickX;
	private double clickY;
	
	private RectSelect rect;
	private Controller controller;
	
	public InputMouseDrag(Controller controller) {
		
		this.controller = controller;
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
		
		else if (e.isMiddleButtonDown()) {
			
			controller.getMap().getRect().setX(e.getX()-(controller.getMap().getClickX()-controller.getMap().getCoorXmap()));
			controller.getMap().getRect().setY(e.getY()-(controller.getMap().getClickY()-controller.getMap().getCoorYmap()));
			
			mapDeplacement(controller, e);
			
		}
	}
	
	// faire bouger la map et en faisant bouger les carrés.
	
	
	public static void mapDeplacement(Controller controller, MouseEvent e) {
		
		Carre carre;
		
		for(int i = 0 ; i<controller.getListCarre().size();i++) {
			carre = controller.getListCarre().get(i);
			
			carre.getView().setTranslateX(e.getX()-(controller.getMap().getClickX()-carre.getxCarre()));
			carre.getView().setTranslateY(e.getY()-(controller.getMap().getClickY()-carre.getyCarre()));
		
			carre.setDestinationX(e.getX()-(controller.getMap().getClickX()-carre.getDestinationXBis()));
			carre.setDestinationY(e.getY()-(controller.getMap().getClickY()-carre.getDestinationYBis()));
		}
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
