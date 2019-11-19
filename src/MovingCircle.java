
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class MovingCircle extends MovingObject {

	// Constructor
	public MovingCircle(){
		Circle circle  = new Circle(50,50,40);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.YELLOW);
		getChildren().add(circle);
	}

	@Override
	public void playMovingObject(MovingObject movingObject){
		// TODO Auto-generated method stub
	}
}