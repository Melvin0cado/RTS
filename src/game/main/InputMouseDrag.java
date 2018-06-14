package game.main;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
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
			
			Game.getRectBis().setX(e.getX()-InputMouseClick.getCoorXmap());
			
			Game.getRectBis().setY(e.getY()-InputMouseClick.getCoorYmap());
			
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
