
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 34db8653ef72b43a7b32e357d00b8f50e46a6a2e
>>>>>>> 090abb9bc8c00f82ca89d42caf503d7cb7b69ec6
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void randomlyPickMovingObjectPath(MovingObject movingObject, int paneWidth, int paneHeight){
=======
<<<<<<< HEAD
=======
=======
	public void playMovingObject(MovingObject movingObject, int paneWidth, int paneHeight){
>>>>>>> 4c51ab1beb0d6d128844057ea6af4f47ae1495b3
>>>>>>> 34db8653ef72b43a7b32e357d00b8f50e46a6a2e
>>>>>>> 090abb9bc8c00f82ca89d42caf503d7cb7b69ec6
		// TODO Auto-generated method stub
		
	}
}