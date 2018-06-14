package game.main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Carre extends GameObject {

	private Controller controller;
	private final static double longueur = 10.0;
	private boolean move = false;
	private boolean selected = false;
	private final double TRUESPEED = 1;
	private double speed =1;
	private double coeffX;
	private double coeffY;
	private double destinationX;
	private double destinationY;
	private boolean destFini ;
	
	public Carre(double x, double y, Controller controller) {
		super(new Rectangle(longueur, longueur, Color.BLUE));
		this.getView().setTranslateX(x);
		this.getView().setTranslateY(y);
		this.controller = controller;
		this.destFini = true;
		
	}

	public void uptdate() {
		
		Physics.CollisionCarreVSCarre(this, controller.getListCarre());
		
		//System.out.println(this.isMove()+","+this.isSelected());
		//System.out.println(this.getView().getTranslateY()+", "+(destinationY+1));
		if ( (int)this.getX() >=  (int)destinationX-1 && (int)this.getX() <= (int)destinationX+1
				&&  (int)this.getY() >=  (int)destinationY-1 && (int)this.getY()<= (int)destinationY+1) {
			this.setMove(false);
			setDestFini(true);
		} else {
				
				
				if (this.isMove()) {

					setDestFini(false);
//					System.out.println(coeffX+" , "+coeffY);
//					System.out.print((int) (destinationX - this.getView().getTranslateX()) + " | ");
//					System.out.println((int) (destinationY - this.getView().getTranslateY()));

					if (this.getView().getTranslateX() < destinationX) {
						this.getView().setTranslateX(this.getView().getTranslateX() + speed * coeffX);
					} else if (this.getView().getTranslateX() > destinationX) {
						this.getView().setTranslateX(this.getView().getTranslateX() - speed * coeffX);
					}

					if (this.getView().getTranslateY() < destinationY) {
						this.getView().setTranslateY(this.getView().getTranslateY() + speed * coeffY);
					} else if (this.getView().getTranslateY() > destinationY) {
						this.getView().setTranslateY(this.getView().getTranslateY() - speed * coeffY);
					}
				
			}
		}
	}
	
	
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public double getSpeed() {
		return speed;
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

	public double getWidth() {
		
		return this.getView().getBoundsInParent().getWidth();
	}
	
	public double getHeight() {
		
		return this.getView().getBoundsInParent().getHeight();
	}

	public double getTRUESPEED() {
		return TRUESPEED;
	}

}
