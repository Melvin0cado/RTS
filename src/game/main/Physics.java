package game.main;

import java.util.LinkedList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Physics {

	

	public static boolean CollisionCarreVSRect(Controller controller) {
		boolean res = false ;
		
		for(int i=0;i<controller.getListCarre().size();i++) {
			
			if(controller.getRect().intersects(controller.getListCarre().get(i).getX(), controller.getListCarre().get(i).getY(),
					controller.getListCarre().get(i).getView().getBoundsInLocal().getWidth(),
					controller.getListCarre().get(i).getView().getBoundsInLocal().getHeight())) {
				
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
				if(carre.getView().getBoundsInParent().intersects(carre2.getView().getBoundsInParent())){
					carre.setMove(false);
					carre2.setMove(false);
					
					if( carre.getX() < carre2.getX() ) {
						
					System.out.println("par la gauche");
					
					
						carre.setDestinationX(carre.getX()-10);
						carre.setDestinationY(carre.getY());
							
					}if(carre.getY() < carre2.getY() ) {
						
						System.out.println("par le haut");
						
						carre.setDestinationX(carre.getX());
						carre.setDestinationY(carre.getY()-10);
						
					}
					if(carre.getX() > carre2.getX() ) {
					
						System.out.println("par le droite");
						
						carre.setDestinationX(carre.getX()+10);
						carre.setDestinationY(carre.getY());
						
					}
					
					if(carre.getY() > carre2.getY() ) {
						
						System.out.println("par le bas");
						
						carre.setDestinationX(carre.getX());
						carre.setDestinationY(carre.getY()+10);
						
					}
					
					carre.setMove(true);
					carre2.setMove(true);
					res = true;
				
					
				}
			}
		}
		return res;
	}
}

