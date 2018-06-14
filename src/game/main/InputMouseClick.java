package game.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InputMouseClick implements EventHandler<MouseEvent> {

	private Controller controller;
	private double clickX;
	private double clickY;
	
	private  double coorX; 
	private  double coorY;
	
	private static double coorXmap;
	private static double coorYmap;
	
	private Carre carre;
	private RectSelect rect ;

	public InputMouseClick( Controller controller) {
		this.controller = controller; 
		this.rect =  controller.getRect();
		
	}

	public void handle(MouseEvent e) {
		
		System.out.println(e.getX()+", "+e.getY());
		
		for(int i =0;i<controller.getListCarre().size();i++) {
			
			clickX = e.getX();
			clickY = e.getY();
			rect.setClickX(clickX);
			rect.setClickY(clickY); // on recupere les clicks de la souris
			
			carre = controller.getListCarre().get(i);
			coorX = e.getX() - (carre.getView().getBoundsInLocal().getWidth() /2);
			coorY = e.getY() - (carre.getView().getBoundsInLocal().getHeight()/2);// on donne la destination du centre du carre
			
			if(e.isSecondaryButtonDown()) {
				
				rect.setWidth(0);
				rect.setHeight(0);
				rect.setX(-10);
				rect.setY(-10);
				
				if (carre.isSelected()) {
									
					carre.setMove(true);
					carre.setDestinationX(coorX);
					carre.setDestinationY(coorY);
		
					Physics.calculCoeff(carre, carre.getDestinationX(), carre.getDestinationY());
					
				}
			}
			
			else if(e.isPrimaryButtonDown()){
				
				rect.setWidth(1);
				rect.setHeight(1);
				rect.setX(e.getX());
				rect.setY(e.getY());
			
				if(!(e.getX() < carre.getX() + carre.getView().getBoundsInLocal().getWidth()
					&& e.getX() > carre.getX()
					&& e.getY() < carre.getY() + carre.getView().getBoundsInLocal().getHeight()
					&& e.getY() > carre.getY())) {
				
					carre.setSelected(false);
					//System.out.println("Selected false");
				}
				else if (e.getX() < carre.getX() + carre.getView().getBoundsInLocal().getWidth()
						&& e.getX() > carre.getX()
						&& e.getY() < carre.getY() + carre.getView().getBoundsInLocal().getHeight()
						&& e.getY() > carre.getY()) {
	
					carre.setSelected(true);
				//	System.out.println("Selected true");
				}
			}
			
			else if (e.isMiddleButtonDown()) {
				
				setCoorXmap(e.getX()-Game.getRectBis().getX());
				setCoorYmap(e.getY()-Game.getRectBis().getY());
			}
			
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

	public  double getCoorX() {
		return coorX;
	}

	public  double getCoorY() {
		return coorY;
	}

	public  void setCoorX(double coorX) {
		this.coorX = coorX;
	}

	public  void setCoorY(double coorY) {
		this.coorY = coorY;
	}

	public static double getCoorXmap() {
		return coorXmap;
	}

	public static void setCoorXmap(double coorXmap) {
		InputMouseClick.coorXmap = coorXmap;
	}

	public static double getCoorYmap() {
		return coorYmap;
	}

	public static void setCoorYmap(double coorYmap) {
		InputMouseClick.coorYmap = coorYmap;
	}
	
	
	
}