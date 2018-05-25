package game.main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class InputMouseClick implements EventHandler<MouseEvent> {

	private Controller controller;
	private double clickX;
	private double clickY;
	
	private double coorX;
	private double coorY;
	private Carre carre;
	private RectSelect rect ;

	public InputMouseClick( Controller controller) {
		this.controller = controller; 
		this.rect =  controller.getRect();
		
	}

	public void handle(MouseEvent e) {
		
		
		
		for(int i =0;i<controller.getListCarre().size();i++) {
			
			clickX = e.getX();
			clickY = e.getY();
			rect.setClickX(clickX);
			rect.setClickY(clickY); // on recupere les clicks de la souris
			
			carre = controller.getListCarre().get(i);
			coorX = e.getX() - (carre.getView().getBoundsInLocal().getWidth() /2);
			coorY = e.getY() - (carre.getView().getBoundsInLocal().getHeight()/2);// on etabli la destination du centre du carre
			
			
			
			if(e.isSecondaryButtonDown()) {
				
				rect.setWidth(0);
				rect.setHeight(0);
				rect.setX(-10);
				rect.setY(-10);
				
				if (carre.isSelected()) {
					
					carre.setMove(true);
					carre.setDestinationX(coorX);
					carre.setDestinationY(coorY);
		
					if ((coorX > carre.getX() && coorY > carre.getY())) { //coin en bas a droite
						if (coorX - carre.getX() < coorY - carre.getY()) {
							carre.setCoeffX(
									(coorX - carre.getX()) / (coorY - carre.getY()));
							carre.setCoeffY(1);
						} else {
							carre.setCoeffY(
									(coorY - carre.getY()) / (coorX - carre.getX()));
							carre.setCoeffX(1);
						}
					}
					if (coorX < carre.getX() && coorY < carre.getY()) {
						if (coorX - carre.getX() < coorY - carre.getY()) {
							carre.setCoeffY(
									(coorY - carre.getY()) / (coorX - carre.getX()));
							carre.setCoeffX(1);
						} else {
							carre.setCoeffX(
									(coorX - carre.getX()) / (coorY - carre.getY()));
							carre.setCoeffY(1);
						}
					}
					if (coorX > carre.getX() && coorY < carre.getY()) {
						if (coorX - carre.getX() < carre.getY() - coorY) {
							carre.setCoeffX(
									(carre.getX() - coorX) / (coorY - carre.getY()));
							carre.setCoeffY(1);
						} else {
							carre.setCoeffY(
									(coorY - carre.getY()) / (carre.getX() - coorX));
							carre.setCoeffX(1);
						}
		
					}
					if (coorX < carre.getX() && coorY > carre.getView().getTranslateY()) {
						if (carre.getX() - coorX < coorY - carre.getView().getTranslateY()) {
							carre.setCoeffX(
									(coorX - carre.getX()) / (carre.getView().getTranslateY() - coorY));
							carre.setCoeffY(1);
						} else {
							carre.setCoeffY(
									(carre.getView().getTranslateY() - coorY) / (coorX - carre.getX()));
							carre.setCoeffX(1);
						}
		
					}
				
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