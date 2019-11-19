import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class MovingTriangle extends MovingObject {

	// Constructor
	public MovingTriangle(){
		Polygon triangle = new Polygon(100, 50, 150, 0, 200, 50); // May need to change
		triangle.setStroke(Color.BLACK);
		triangle.setFill(Color.RED);
		getChildren().add(triangle);
	}

	@Override
	public void playMovingObject(MovingObject movingObject){
		// TODO Auto-generated method stub
	}
}