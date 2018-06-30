package game.main;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bottom extends Pane{

	private Rectangle rectangle;
	private MiniMap miniMap;

	public Bottom(Pane root) {
		super();
		super.setTranslateX(0);
		System.out.println(root.getPrefHeight()*0.2);
		super.setTranslateY(root.getPrefHeight()*0.8);
		super.setPrefWidth(root.getPrefHeight());
		super.setPrefHeight(root.getPrefHeight()*0.2);
		
		
		rectangle = new Rectangle();
		rectangle.setFill(Color.gray(0.7));
		rectangle.setWidth(root.getPrefWidth());
		rectangle.setHeight(root.getPrefHeight()*0.2);
		
		miniMap = new MiniMap(this);
		
		super.getChildren().add(rectangle);
		super.getChildren().add(miniMap);
		
		
	}

	public static boolean isClick(Controller controller, MouseEvent e) {
		
		return e.getX() > controller.getBot().getTranslateX() &&
				e.getX() < controller.getBot().getTranslateX()+controller.getBot().getPrefWidth() &&
				e.getY() > controller.getBot().getTranslateY() && 
				e.getY() < controller.getBot().getTranslateY()+controller.getBot().getPrefHeight() ;
	}
	
	public MiniMap getMiniMap() {
		return miniMap;
	}
	
}
