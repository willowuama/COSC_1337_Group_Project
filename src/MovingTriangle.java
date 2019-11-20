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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 34db8653ef72b43a7b32e357d00b8f50e46a6a2e
	public void playMovingObject_Top_Bottom(MovingObject movingObject, int paneWidth, int paneHeight){
		// TODO Auto-generated method stub
	}

	@Override
	public void playMovingObject_Bottom_Top(MovingObject movingObject, int paneWidth, int paneHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMovingObject_Right_Left(MovingObject movingObject, int paneWidth, int paneHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMovingObject_Left_Right(MovingObject movingObject, int paneWidth, int paneHeight) {
<<<<<<< HEAD
=======
=======
	public void playMovingObject(MovingObject movingObject, int paneWidth, int paneHeight){
>>>>>>> 4c51ab1beb0d6d128844057ea6af4f47ae1495b3
>>>>>>> 34db8653ef72b43a7b32e357d00b8f50e46a6a2e
		// TODO Auto-generated method stub
		
	}
}