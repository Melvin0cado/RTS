package game.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class InputMouseDrag implements EventHandler<MouseEvent>{

	private Controller controller;
	
	public InputMouseDrag(Controller controller) {
		
		this.controller = controller;
		
	}
	
	@Override
	public void handle(MouseEvent e) {
		
		if(e.isPrimaryButtonDown()) {
			if(!Bottom.isClick(controller, e)) {
				
				controlRectSelect(controller , e);
			}
			
			
			if(MiniMap.isClick(controller, e)) {
				
				controller.getMap().setTranslateX((-e.getX()+controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getRectVue().getWidth()/2)/controller.getCoeffMiniMap() );
				controller.getMap().setTranslateY((-e.getY()+controller.getBot().getTranslateY()+controller.getBot().getMiniMap().getRectVue().getHeight()/2)/controller.getCoeffMiniMap());
			}
		}
		
		else if (e.isMiddleButtonDown()) {
		
			mapDeplacement(controller, e);
		}
			
		
			
	}
	
	public static void mapDeplacement(Controller controller, MouseEvent e) {
		
		if(e.getX()-controller.getMap().getClickX() < 50 &&
				e.getX()-controller.getMap().getClickX() > -controller.getMap().getPrefWidth()+controller.getRoot().getPrefWidth() -50) {
			
			controller.getMap().setTranslateX(e.getX()-controller.getMap().getClickX());
		}
		if(e.getY()-controller.getMap().getClickY() < 50 &&
				e.getY()-controller.getMap().getClickY() > -controller.getMap().getPrefHeight()+controller.getRoot().getPrefHeight()-controller.getBot().getPrefHeight() -50 ) {
			
			controller.getMap().setTranslateY(e.getY()-controller.getMap().getClickY());
		}
				
	}
	
	public static void controlRectSelect(Controller controller , MouseEvent e) {
		
		RectSelect rect = controller.getRect();
		
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
