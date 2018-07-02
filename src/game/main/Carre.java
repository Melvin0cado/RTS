package game.main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * cree un objet carre.
 * 
 * @author Melvin
 *
 */
public class Carre extends Pane{

	private Controller controller;
	
	private double longueur = 10.0;
	private boolean move = false;
	private boolean selected = false;
	private Color couleurInit;
	private Color couleur;
	private final double TRUESPEED = 2;
	private double speed =2;
	private double coeffX;
	private double coeffY;
	private double destinationX;
	private double destinationY;
	private boolean destFini ;
	private Carre carreMiniMap;
	private Rectangle rect;
	
	/**
	 * Ce constructeur cree le carre dans la position donne.
	 * 
	 * @param x la position en x.
	 * @param y la position en y.
	 * @param couleur la couleur de l'objet voulu.
	 * @param controller le controlleur.
	 */
	public Carre(double x, double y,Color couleur, Controller controller) {
		super();
		super.setTranslateX(x);
		super.setTranslateY(y);
		super.setWidth(10);
		super.setHeight(10);
		this.controller = controller;
		this.couleur = couleur;
		this.couleurInit =couleur;
		rect = new Rectangle(longueur,longueur,couleur);
		this.destFini = true;
		
		this.getChildren().add(rect);
		
	}

	/**
	 * Cette methode contient les elements a mettre a jour a chaque tour de boucke de jeu.
	 */
	public void uptdate() {
		
		Physics.CollisionCarreVSCarre(this, controller.getListCarre());
			
			carreMiniMap.setTranslateX(this.getTranslateX()*controller.getCoeffMiniMap());
			carreMiniMap.setTranslateY(this.getTranslateY()*controller.getCoeffMiniMap());
		
		if ( (int)this.getX() >=  (int)destinationX-1 && (int)this.getX() <= (int)destinationX+1
				&&  (int)this.getY() >=  (int)destinationY-1 && (int)this.getY()<= (int)destinationY+1) {
			this.setMove(false);
			setDestFini(true);
		} else {
								
				if (this.isMove()) {

					setDestFini(false);

					if (super.getTranslateX() < destinationX) {
						super.setTranslateX(super.getTranslateX() + speed * coeffX);
					} else if (super.getTranslateX() > destinationX) {
						super.setTranslateX(super.getTranslateX() - speed * coeffX);
					}

					if (super.getTranslateY() < destinationY) {
						super.setTranslateY(super.getTranslateY() + speed * coeffY);
					} else if (super.getTranslateY() > destinationY) {
						super.setTranslateY(super.getTranslateY() - speed * coeffY);
					}
				
			}
		}
	}
	
	// getters/setters
	
	public double getX() {
		
		return super.getTranslateX();
	}
	
	public double getY() {
		
		return super.getTranslateY();
	}
	public boolean isMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDestinationX() {
		return destinationX;
	}
	public double getDestinationY() {
		return destinationY;
	}
	public void setDestinationX(double destinationX) {
		this.destinationX = destinationX;
	}
	public void setDestinationY(double destinationY) {
		this.destinationY = destinationY;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
		if(selected) {
			this.rect.setStroke(Color.YELLOW);
		}else {
			this.rect.setStroke(null);
		}
	}
	public double getCoeffX() {
		return coeffX;
	}
	public void setCoeffX(double coeffX) {
		this.coeffX = coeffX;
	}
	public double getCoeffY() {
		return coeffY;
	}
	public void setCoeffY(double coeffY) {
		this.coeffY = coeffY;
	}
	public double getLongueur() {
		return longueur;
	}
	public boolean isDestFini() {
		return destFini;
	}
	public void setDestFini(boolean destFini) {
		this.destFini = destFini;
	}
	public double getTRUESPEED() {
		return TRUESPEED;
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
		this.setPrefWidth(longueur);
		this.setPrefHeight(longueur);
		this.getRect().setWidth(longueur);
		this.getRect().setHeight(longueur);
		
	}
	public void setCarreMiniMap(Carre carreMiniMap) {
		this.carreMiniMap = carreMiniMap;
	}
}
