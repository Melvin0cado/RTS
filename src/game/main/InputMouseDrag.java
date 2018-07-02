package game.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * cree l'interaction lors d'un glisser de la souris.
 * 
 * @author Melvin
 *
 */
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
				
				if((e.getX() < (controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getRectVue().getWidth()/2)) ) {
					
					controller.getBot().getMiniMap().getRectVue().setX(0);
					controller.getMap().setTranslateX(50);
				}
				if(e.getX() > (controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getWidth()-controller.getBot().getMiniMap().getRectVue().getWidth()/2)) {
					
					controller.getBot().getMiniMap().getRectVue().setX(controller.getBot().getMiniMap().getWidth()-controller.getBot().getMiniMap().getRectVue().getWidth());
					controller.getMap().setTranslateX(-controller.getMap().getWidth()+controller.getRoot().getWidth()-50);
				}
				if(e.getY() < (controller.getBot().getTranslateY()+controller.getBot().getMiniMap().getRectVue().getHeight()/2)) {
					
					controller.getBot().getMiniMap().getRectVue().setY(0);
					controller.getMap().setTranslateY(50);
				}
				if(e.getY() > (controller.getBot().getTranslateY()+controller.getBot().getMiniMap().getHeight()-controller.getBot().getMiniMap().getRectVue().getHeight()/2)){
					
					controller.getBot().getMiniMap().getRectVue().setY(controller.getBot().getMiniMap().getHeight()-controller.getBot().getMiniMap().getRectVue().getHeight());
					controller.getMap().setTranslateY(-controller.getMap().getHeight()+controller.getRoot().getHeight()-controller.getBot().getPrefHeight()-50);
				}
				
			}
		}
		
		else if (e.isMiddleButtonDown()) {
		
			
			mapDeplacement(controller, e);
		}
			
		
			
	}
	
	/**
	 * Controle le deplacement de la map en fonction du placement de la souris et du click de depart.
	 * 
	 * @param controller le controlleur.
	 * @param e un MouseEvent.
	 */
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
	
	/**
	 * gere le controle du rectangle de selection.
	 * 
	 * @param controller le controlleur.
	 * @param e un MouseEvent.
	 */
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
