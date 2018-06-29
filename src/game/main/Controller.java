package game.main;


import java.util.LinkedList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {

	private LinkedList<Carre> ListCarre = new LinkedList<Carre>();
	private LinkedList<Carre> ListCarreMini = new LinkedList<Carre>();
	
	private LinkedList<Carre> ListCarreSelected = new LinkedList<Carre>();
	
	
	
	private Pane root;
	private RectSelect rect = new RectSelect(0, 0, 0, 0, root,this);
	private Map map;
	private Bottom bot;
	
	private double coeffMiniMap;
	
	public Controller(Pane root) {
		this.root = root;
		map = new Map(root);
		bot = new Bottom(root);
		 coeffMiniMap = this.getBot().getMiniMap().getPrefWidth()/this.getMap().getPrefWidth();
	}
	
	public LinkedList<Carre> getListCarre(){
		return this.ListCarre;
	}
	
	public void addCarre(Carre carre) {
		
		ListCarre.add(carre);
		ListCarreMini.add(carre);
	}
		
	public void uptdate() {
		
		Carre carre;
		
		for(int i = 0 ; i<this.getListCarre().size();i++) {
			
			carre = this.getListCarre().get(i);
			carre.uptdate();
			
		}
		
		
		
	}
	
	
	
	public void render(Pane root) {
				
		Carre carre;
		Carre carre2;
		for(int i =0;i<this.getListCarre().size();i++) {
			
			carre = this.getListCarre().get(i);
		
			carre = this.getListCarre().get(i);
			carre2 = new Carre(carre.getTranslateX()*coeffMiniMap, carre.getTranslateY()*coeffMiniMap,Color.WHITE, this);
			carre2.setLongueur(carre.getLongueur()*coeffMiniMap);
			this.getListCarreMini().add(i, carre2);
			
			carre.setCarreMiniMap(carre2);
			
			root.getChildren().add(carre);
			 
			this.getBot().getMiniMap().getChildren().add(carre2);
		}
		
		
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

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Bottom getBot() {
		return bot;
	}

	public void setBot(Bottom bot) {
		this.bot = bot;
	}

	public LinkedList<Carre> getListCarreMini() {
		return ListCarreMini;
	}

	public void setListCarreMini(LinkedList<Carre> listCarreMini) {
		ListCarreMini = listCarreMini;
	}

	public double getCoeffMiniMap() {
		return coeffMiniMap;
	}

	public void setCoeffMiniMap(double coeffMiniMap) {
		this.coeffMiniMap = coeffMiniMap;
	}



}
