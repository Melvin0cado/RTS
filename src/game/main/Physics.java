package game.main;

import java.util.LinkedList;

/**
 * Cette classe contient toute la physics des elements du jeu.</br>
 * ex : les carres avec le rectangle de selection.
 * 
 * @author Melvin
 *
 */
public class Physics {

	/**
	 * Gere l'interaction lorsqu'un carre est touche par le rectangle de selection.
	 * 
	 * @param controller le controlleur.
	 * @return true si le carre est touche, false sinon.
	 */
	public static boolean CollisionCarreVSRect(Controller controller) {
		boolean res = false ;
		
		Carre carre;
		for(int i=0;i<controller.getListCarre().size();i++) {
			
			carre = controller.getListCarre().get(i);
			
			if(controller.getRect().intersects(carre.getX(),
					carre.getY(),
					carre.getLongueur(),
					carre.getLongueur() ) ) {
				
				controller.getListCarre().get(i).setSelected(true);
				controller.getListCarreSelected().add(controller.getListCarre().get(i));
				res = true;
			}
			
		}
		return res;
	}
	
	/**
	 * 
	 * @param carre
	 * @param carres
	 * @return
	 */
	public static boolean ZoneAttackCarre(Carre carre, LinkedList<Carre> carres) {
		boolean res = false;
		
		Carre carre2;
		
		for(int i=0;i<carres.size();i++) {
			
			carre2= carres.get(i);
			if(carre != carre2) {
				
				if(carre.getBoundsInParent().intersects(carre2.getBoundsInParent())){
				
					if(carre.getTimepast() == -1 ){
						
						carre.setTimepast(carre.getTimeNow());
					}
					carre.setTimeReel(carre.getTimeNow()-carre.getTimepast());
					System.out.println(carre.getTimeReel());
					
					if(carre.getTimeReel() >= 3){
						
						carre.Attack(carre);
						carre.setTimepast(carre.getTimeNow());
					}
					res = true;
					
				}else {
					
					carre.setTimepast(carre.getTimeNow());
				}
			}
		}
		return res;
	}
	
	/**
	 * Gere l'interaction lorsque les carres se touche entre eux.
	 * 
	 * @param carre un premeir carre.
	 * @param carres un deuxieme carre.
	 * @return true si deux carre se touche, false sinon.
	 */
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
					Physics.calculVitesse(carre);
					
					carre.setMove(true);
					carre2.setMove(true);
					
					res = true;
				
				}
			}
		}
		return res;
	}
	
	/**
	 * Recalcule la vitesse d'un carre.
	 * 
	 * @param carre un carre.
	 */
	public static void calculVitesse(Carre carre) {
		if(carre.isMove()) {
			carre.setSpeed(carre.getTRUESPEED()/(carre.getCoeffX()+carre.getCoeffY()));
		}
		
	}

	/**
	 * Change le coefficient du carre permettant de reguler la vitesse selon l'axe des X et celle des Y.
	 * 
	 * @param carre un carre.
	 * @param destinationX la nouvelle destination en X.
	 * @param destinationY la nouvelle destination en Y.
	 */
	public static void calculCoeff(Carre carre, double destinationX , double destinationY) {
		
		if ((destinationX > carre.getX() && destinationY > carre.getY())) { 
			if (destinationX - carre.getX() < destinationY - carre.getY()) {
				carre.setCoeffX(
						(destinationX - carre.getX()) / (destinationY - carre.getY()));
				carre.setCoeffY(1);
			} else {
				carre.setCoeffY(
						(destinationY - carre.getY()) / (destinationX - carre.getX()));
				carre.setCoeffX(1);
			}
		}
		if (destinationX < carre.getX() && destinationY < carre.getY()) {
			if (destinationX - carre.getX() < destinationY - carre.getY()) {
				carre.setCoeffY(
						(destinationY - carre.getY()) / (destinationX - carre.getX()));
				carre.setCoeffX(1);
			} else {
				carre.setCoeffX(
						(destinationX - carre.getX()) / (destinationY - carre.getY()));
				carre.setCoeffY(1);
			}
		}
		if (destinationX > carre.getX() && destinationY < carre.getY()) {
			if (destinationX - carre.getX() < carre.getY() - destinationY) {
				carre.setCoeffX(
						(carre.getX() - destinationX) / (destinationY - carre.getY()));
				carre.setCoeffY(1);
			} else {
				carre.setCoeffY(
						(destinationY - carre.getY()) / (carre.getX() - destinationX));
				carre.setCoeffX(1);
			}

		}
		if (destinationX < carre.getX() && destinationY > carre.getTranslateY()) {
			if (carre.getX() - destinationX < destinationY - carre.getTranslateY()) {
				carre.setCoeffX(
						(destinationX - carre.getX()) / (carre.getTranslateY() - destinationY));
				carre.setCoeffY(1);
			} else {
				carre.setCoeffY(
						(carre.getTranslateY() - destinationY) / (destinationX - carre.getX()));
				carre.setCoeffX(1);
			}

		}
		
		Physics.calculVitesse(carre);
		
	}
	
}

