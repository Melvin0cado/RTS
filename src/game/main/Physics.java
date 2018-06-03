package game.main;

import java.util.LinkedList;

import javafx.scene.shape.Rectangle;

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
			
			if(carre != carre2) {
				if(carre.getView().getBoundsInParent().intersects(carre2.getView().getBoundsInParent())){
				res = true;
				
					if(carre.getDestinationX()-carre.getX() < carre2.getDestinationX()-carre.getX() &&
							carre.getDestinationY()-carre.getY()< carre2.getDestinationY()-carre.getY()) {
						
						carre2.setDestinationX(carre.getView().getTranslateX()+carre.getView().getBoundsInParent().getWidth()+1);
						carre2.setDestinationY(carre.getView().getTranslateY()+carre.getView().getBoundsInParent().getHeight()+1);
					}
				}
			}
			
		}
			
		return res;
	}
}

