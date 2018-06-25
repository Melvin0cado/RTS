package game.main;


import java.util.LinkedList;

import javafx.scene.layout.Pane;

public class Controller {

	private LinkedList<Carre> ListCarre = new LinkedList<Carre>();
	private LinkedList<Carre> ListCarreSelected = new LinkedList<Carre>();
	private LinkedList<Carre> ListObserver = new LinkedList<Carre>();
	private Pane root;
	private RectSelect rect = new RectSelect(0, 0, 0, 0, root,this);
	private Map map;
	
	public Controller(Pane root) {
		this.root = root;
		 map = new Map(this.root);
	}
	
	public LinkedList<Carre> getListCarre(){
		return this.ListCarre;
	}
	
	public void addCarre(Carre carre) {
		
		ListCarre.add(carre);
	}
		
	public void uptdate() {
		
		for(Carre carre : ListCarre) {
			carre.uptdate();
		}
		
	}
	
	public void render(Pane map) {
				
		for(int i =0;i<this.getListCarre().size();i++) {
			map.getChildren().add(this.getListCarre().get(i).getView());
		}
		map.getChildren().add(rect);
		
	}
	
	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}

	public RectSelect getRect() {
		return rect;
	}

	public void setRect(RectSelect rect) {
		this.rect = rect;
	}

	public LinkedList<Carre> getListCarreSelected() {
		return ListCarreSelected;
	}

	public void setListCarreSelected(LinkedList<Carre> listCarreSelected) {
		ListCarreSelected = listCarreSelected;
	}

	public LinkedList<Carre> getListObserver() {
		return ListObserver;
	}

	public void setListObserver(LinkedList<Carre> listObserver) {
		ListObserver = listObserver;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}



}
