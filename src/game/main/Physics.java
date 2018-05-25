package game.main;

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
	
	
}
	

