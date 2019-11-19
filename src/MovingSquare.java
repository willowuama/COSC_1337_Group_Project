import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MovingSquare extends MovingObject {

	// Constructor 
	public MovingSquare(){
		Rectangle rectangle = new Rectangle(0, 0, 50, 50);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.ORANGE);
		getChildren().add(rectangle);
	}

	@Override
	public void playMovingObject(MovingObject movingObject, int paneWidth, int paneHeight){
		// Create points to use for line that will be transition path for rectangle.  
		// Rectangle will come in from the top of the window, random location. 
		setX1((int)(Math.random()*(paneWidth+1)));
		setY1(0);
		setX2((int)(Math.random()*(paneWidth+1)));
		setY2(paneHeight+50);
		
		// Create a path transition for the rectangle to move across the screen
		PathTransition rectangle_pt = new PathTransition();
		rectangle_pt.setDuration(Duration.seconds(5));   // It takes a rectangle 5 seconds to pass along the full length of the screen
		rectangle_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  //  Path is the line through these two sets of points
		rectangle_pt.setNode(movingObject);   // Node that follows path is the rectangle
		rectangle_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds, time parameter for assignment)
		rectangle_pt.play();  // Start animation
		

		//rectangle_count++;  // Increase rectangle_count for the loop control

	}
}