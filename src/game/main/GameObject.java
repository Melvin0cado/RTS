package game.main;

import javafx.scene.Node;

public class GameObject {

	private Node view;
	
	public GameObject(Node view) {

		this.view = view;
		
	}
	
	public Node getView() {
		return view;
	}

	public void setView(Node view) {
		this.view = view;
	}


	public double getX() {
		return this.getView().getTranslateX();
	}
	
	public double getY() {
		return this.getView().getTranslateY();
	}

}