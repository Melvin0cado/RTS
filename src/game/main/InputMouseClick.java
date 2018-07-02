package game.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * cree l'interaction lors d'un click sur un elements du jeu.
 * 
 * @author Melvin
 *
 */
public class InputMouseClick implements EventHandler<MouseEvent> {

	private Controller controller;
	
	private double clickX;
	private double clickY;
	
	private  double coorX; 
	private  double coorY;
	
	private Carre carre;
	private RectSelect rect ;

	public InputMouseClick( Controller controller) {
		this.controller = controller; 
		this.rect =  controller.getRect();
		
	}

	/**
	 * Gere l'intercation lors du click.
	 */
	public void handle(MouseEvent e) {
		
		
		System.out.println(e.getX()+", "+e.getY());
			
			clickX = e.getX();
			clickY = e.getY();
			rect.setClickX(clickX); // on recupere les clicks de la souris
			rect.setClickY(clickY); 
		for(int i =0;i<controller.getListCarre().size();i++) {
			
			
			
			if(!Bottom.isClick(controller, e)) {
				carre = controller.getListCarre().get(i);
				coorX = e.getX() - (carre.getWidth() /2); // on donne la destination du centre du carre
				coorY = e.getY() - (carre.getHeight()/2); 
			}
			if(e.isSecondaryButtonDown()) {
				
				if (carre.isSelected()) {
									
					carre.setMove(true);
					carre.setDestinationX(coorX-controller.getMap().getTranslateX()); // on ajoute la coordonnées voulu moins les coordonnées de la map
					carre.setDestinationY(coorY-controller.getMap().getTranslateY());
					
					Physics.calculCoeff(carre, carre.getDestinationX(), carre.getDestinationY());
					
				}
			}
			else if(e.isPrimaryButtonDown()){
				
				if(!Bottom.isClick(controller, e)) {
						rect.setWidth(1);
						rect.setHeight(1);
						rect.setX(e.getX());
						rect.setY(e.getY());
				}
				
				if(MiniMap.isClick(controller, e)) {
					
					System.out.println(e.getX()+ " ; "+(controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getRectVue().getWidth()/2));
				
					controller.getMap().setTranslateX((-e.getX()+controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getRectVue().getWidth()/2)/controller.getCoeffMiniMap()  );
					controller.getMap().setTranslateY((-e.getY()+controller.getBot().getTranslateY()+controller.getBot().getMiniMap().getRectVue().getHeight()/2)/controller.getCoeffMiniMap());
					
					if((e.getX() < (controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getRectVue().getWidth()/2)-5) ) {
						
						controller.getBot().getMiniMap().getRectVue().setX(0);
						controller.getMap().setTranslateX(50);
					}
					if(e.getX() > (controller.getBot().getMiniMap().getTranslateX()+controller.getBot().getMiniMap().getWidth()-controller.getBot().getMiniMap().getRectVue().getWidth()/2)+5) {
						
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
				if(!(e.getX() < carre.getX() + carre.getWidth()
					&& e.getX() > carre.getX()
					&& e.getY() < carre.getY() + carre.getHeight()
					&& e.getY() > carre.getY()) ) {
				
					carre.setSelected(false);
				
				}
			}
			else if (e.isMiddleButtonDown()) {
				
				controller.getMap().setClickX(e.getX()-controller.getMap().getTranslateX());
				controller.getMap().setClickY(e.getY()-controller.getMap().getTranslateY());
				
			}
			
			
		}
	}

}