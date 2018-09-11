package game.main;


import java.util.LinkedList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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
	private LinkedList<Rectangle> ListCarreMini = new LinkedList<Rectangle>();
	private LinkedList<Carre> ListCarreSelected = new LinkedList<Carre>();
	
	private Pane root;
	private RectSelect rect = new RectSelect(0, 0, 0, 0, root,this);
	private Map map;
	private Bottom bot;
	private Etat etat = null;
	
	private double coeffMiniMap;
	
	private long timepast = -1;
	private long timeNow;
	private long timeReel;
	
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
		this.getMap().getChildren().add(carre);
		
		Rectangle carre2;

		carre2 = new Rectangle(carre.getTranslateX()*coeffMiniMap, carre.getTranslateY()*coeffMiniMap,Color.WHITE);
		carre2.setWidth(carre.getLongueur()*coeffMiniMap);
		carre2.setHeight(carre.getLongueur()*coeffMiniMap);
		
		this.getListCarreMini().add(carre2);
		
		carre.setCarreMiniMap(carre2);
		
		this.getBot().getMiniMap().getChildren().add(carre2);
	}
	
	public void removeCarre(Carre carre) {
		
		
		carre.setSelected(false);
		carre.setMove(false);
		
		this.getListCarreMini().remove(carre.getCarreMiniMap());
		this.getListCarre().remove(carre);
		this.getMap().getChildren().remove(carre);
		this.getBot().getMiniMap().getChildren().remove(carre.getCarreMiniMap());
		
		this.etat = Etat.MINIMAP;
		this.etat = Etat.MAP;
		
	}
		
	/**
	 * Cette methode regroupe toutes les methodes update de chaque elements du jeu.
	 * 
	 */
	public void uptdate() {
		
		
		timeNow = System.currentTimeMillis()/1000; //convertion du temps en seconde.
		if(timepast == -1) {
			timepast = timeNow;
			
		}
		timeReel = timeNow-timepast ;
		//System.out.println(timeReel); // gestion du temps.
	
//		if(timeReel == 5) { // envoyer un message toute les 5 secondes.
//			System.out.println("CoucouTimer");
//			timepast = timeNow;
//			
//		}
		
		Carre carre;
		
		if(!this.getListCarre().isEmpty()) {
				
			for(int i = 0 ; i<this.getListCarre().size();i++) {
					
				carre = this.getListCarre().get(i);
				carre.uptdate();
				
				if(carre.getPv() <=0) {
					
					this.removeCarre(carre);
						
				}
			}
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
	public LinkedList<Rectangle> getListCarreMini() {
		return ListCarreMini;
	}
	public double getCoeffMiniMap() {
		return coeffMiniMap;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public long getTimepast() {
		return timepast;
	}

	public void setTimepast(long timepast) {
		this.timepast = timepast;
	}

	public long getTimeNow() {
		return timeNow;
	}

	public void setTimeNow(long timeNow) {
		this.timeNow = timeNow;
	}

}
