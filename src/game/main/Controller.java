package game.main;


import java.util.LinkedList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Le controlleur du jeu.
 * 
 * Il permet de reunir tout les elements du jeu pour les faires interagir entre eux. 
 * 
 * @author Melvin
 *
 */
public class Controller {

	private LinkedList<Carre> ListCarre = new LinkedList<Carre>();
	private LinkedList<Carre> ListCarreMini = new LinkedList<Carre>();
	private LinkedList<Carre> ListCarreSelected = new LinkedList<Carre>();
	
	private Pane root;
	private RectSelect rect = new RectSelect(0, 0, 0, 0, root,this);
	private Map map;
	private Bottom bot;
	
	private double coeffMiniMap;
	
	/**
	 * cree un conteneur contenant tout les elements du jeu.
	 * 
	 * @param root
	 */
	public Controller(Pane root) {
		this.root = root;
		map = new Map();
		bot = new Bottom(root);
		coeffMiniMap = this.getBot().getMiniMap().getPrefWidth()/this.getMap().getPrefWidth();
		new Physics();
		
		this.getBot().getMiniMap().getRectVue().setWidth(this.getRoot().getPrefWidth()*coeffMiniMap);
		this.getBot().getMiniMap().getRectVue().setHeight((this.getRoot().getPrefHeight()-this.getBot().getPrefHeight())*coeffMiniMap);
		
	}
	
	/**
	 * cette methode ajoute le carre donnee dans la map et la minimap.
	 * 
	 * @param carre
	 */
	public void addCarre(Carre carre) {
		
		ListCarre.add(carre);
		ListCarreMini.add(carre);
	}
		
	/**
	 * Cette methode regroupe tout les methodes update de tout les elements du jeu ainsi que certains elements a mettre a jour.
	 * 
	 */
	public void uptdate() {
		
		Carre carre;
		
		for(int i = 0 ; i<this.getListCarre().size();i++) {
			
			carre = this.getListCarre().get(i);
			carre.uptdate();
			
		}
		if(this.getMap().getTranslateX() < this.getRoot().getTranslateX()-10 &&
				this.getMap().getTranslateX()+this.getMap().getPrefWidth() > this.getRoot().getPrefWidth()+10 ) {
			this.getBot().getMiniMap().getRectVue().setX(-this.getMap().getTranslateX()*coeffMiniMap);
		}
		if(this.getMap().getTranslateY() < this.getRoot().getTranslateY()-10 &&
				this.getMap().getTranslateY()+this.getMap().getPrefHeight()+this.getBot().getPrefHeight() > this.getRoot().getPrefHeight()+10 ) {
			this.getBot().getMiniMap().getRectVue().setY(-this.getMap().getTranslateY()*coeffMiniMap);
		}
	}
	
	/**
	 * Cette methode cree le rendu visuel du carre dans la map et dans la minimap.
	 * 
	 * @param root la map.
	 */
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
	
	// getters/setters
	
	public Pane getRoot() {
		return root;
	}
	public RectSelect getRect() {
		return rect;
	}
	public LinkedList<Carre> getListCarre(){
		return this.ListCarre;
	}
	public LinkedList<Carre> getListCarreSelected() {
		return ListCarreSelected;
	}
	public Map getMap() {
		return map;
	}
	public Bottom getBot() {
		return bot;
	}
	public LinkedList<Carre> getListCarreMini() {
		return ListCarreMini;
	}
	public double getCoeffMiniMap() {
		return coeffMiniMap;
	}

}
