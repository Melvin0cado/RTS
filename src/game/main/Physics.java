package game.main;

import java.util.LinkedList;


public class Physics {

	public static boolean CollisionCarreVSRect(Controller controller) {
		boolean res = false ;
		
		for(int i=0;i<controller.getListCarre().size();i++) {
			
			if(controller.getRect().intersects(controller.getListCarre().get(i).getX()+controller.getMap().getTranslateX(),
					controller.getListCarre().get(i).getY()+controller.getMap().getTranslateY(),
					controller.getListCarre().get(i).getBoundsInLocal().getWidth(),
					controller.getListCarre().get(i).getBoundsInLocal().getHeight())) {
				
				controller.getListCarre().get(i).setSelected(true);
				controller.getListCarreSelected().add(controller.getListCarre().get(i));
				res = true;
			}
			
		}
		return res;
	}
	
	public static boolean CollisionCarreVSCarre(Carre carre, LinkedList<Carre> carres) {
		boolean res =false;
		
		Carre carre2;
		
		for(int i=0;i<carres.size();i++) {
			
			carre2= carres.get(i);
			
			if(carre != carre2 && carre.isDestFini()) {
				if(carre.getBoundsInParent().intersects(carre2.getBoundsInParent())){
					carre.setMove(false);
					carre2.setMove(false);
					
					if( carre.getX() < carre2.getX() ) {
						
						
						carre.setDestinationX(carre.getX()-carre.getLongueur()/1.5);
						carre.setDestinationY(carre.getY());
						
							
					}if(carre.getY() < carre2.getY() ) {
						
					
						carre.setDestinationX(carre.getX());
						carre.setDestinationY(carre.getY()-carre.getLongueur()/1.5);
						
					}
					if(carre.getX() > carre2.getX() ) {
					
						
						carre.setDestinationX(carre.getX()+carre.getLongueur()/1.5);
						carre.setDestinationY(carre.getY());
						
					}
					
					if(carre.getY() > carre2.getY() ) {
						
					
						carre.setDestinationX(carre.getX());
						carre.setDestinationY(carre.getY()+carre.getLongueur()/1.5);
						
					}
					Physics.calculCoeff(carre, carre.getDestinationX(), carre.getDestinationY());
					Physics.calculCoeff(carre2, carre2.getDestinationX(), carre2.getDestinationY());
					Physics.calculVitesse(carre);
					Physics.calculVitesse(carre2);
					
					carre.setMove(true);
					carre2.setMove(true);
					
					res = true;
				
				}
			}
		}
		return res;
	}
	
	public static void calculVitesse(Carre carre) {
		if(carre.isMove()) {
			carre.setSpeed(carre.getTRUESPEED()/(carre.getCoeffX()+carre.getCoeffY()));
		}
		
	}

	public static void calculCoeff(Carre carre, double x , double y) {
		
		if ((x > carre.getX() && y > carre.getY())) { 
			if (x - carre.getX() < y - carre.getY()) {
				carre.setCoeffX(
						(x - carre.getX()) / (y - carre.getY()));
				carre.setCoeffY(1);
			} else {
				carre.setCoeffY(
						(y - carre.getY()) / (x - carre.getX()));
				carre.setCoeffX(1);
			}
		}
		if (x < carre.getX() && y < carre.getY()) {
			if (x - carre.getX() < y - carre.getY()) {
				carre.setCoeffY(
						(y - carre.getY()) / (x - carre.getX()));
				carre.setCoeffX(1);
			} else {
				carre.setCoeffX(
						(x - carre.getX()) / (y - carre.getY()));
				carre.setCoeffY(1);
			}
		}
		if (x > carre.getX() && y < carre.getY()) {
			if (x - carre.getX() < carre.getY() - y) {
				carre.setCoeffX(
						(carre.getX() - x) / (y - carre.getY()));
				carre.setCoeffY(1);
			} else {
				carre.setCoeffY(
						(y - carre.getY()) / (carre.getX() - x));
				carre.setCoeffX(1);
			}

		}
		if (x < carre.getX() && y > carre.getTranslateY()) {
			if (carre.getX() - x < y - carre.getTranslateY()) {
				carre.setCoeffX(
						(x - carre.getX()) / (carre.getTranslateY() - y));
				carre.setCoeffY(1);
			} else {
				carre.setCoeffY(
						(carre.getTranslateY() - y) / (x - carre.getX()));
				carre.setCoeffX(1);
			}

		}
		
		Physics.calculVitesse(carre);
		
	}
	
}

