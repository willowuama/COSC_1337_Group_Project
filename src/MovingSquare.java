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
	public void playMovingObject_Top_Bottom(MovingObject movingObject, int paneWidth, int paneHeight){
		// Create points to use for line that will be transition path for rectangle.  
		// Rectangle will come in from the top of the window, random location. 
		setX1((int)(Math.random()*(paneWidth+1)));
		setY1(0);
		setX2((int)(Math.random()*(paneWidth+1)));
		setY2(paneHeight+50);
		
		// Create a path transition for the rectangle to move across the screen
		PathTransition topBottomObject_pt = new PathTransition();
		topBottomObject_pt.setDuration(Duration.seconds(5));   // It takes a rectangle 5 seconds to pass along the full length of the screen
		topBottomObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  //  Path is the line through these two sets of points
		topBottomObject_pt.setNode(movingObject);   // Node that follows path is the rectangle
		topBottomObject_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds, time parameter for assignment)
		topBottomObject_pt.play();  // Start animation
		

	}

	@Override
	public void playMovingObject_Bottom_Top(MovingObject movingObject, int paneWidth, int paneHeight) {
		
		setX1((int)(Math.random()*(paneWidth+1)));
		setY1(paneHeight);
		setX2((int)(Math.random()*(paneWidth+1)));
		setY2(-50);
		
		// Create a path transition for the rectangle to move across the screen
		PathTransition bottomTopObject_pt = new PathTransition();
		bottomTopObject_pt.setDuration(Duration.seconds(5));   // It takes a rectangle 5 seconds to pass along the full length of the screen
		bottomTopObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  //  Path is the line through these two sets of points
		bottomTopObject_pt.setNode(movingObject);   // Node that follows path is the rectangle
		bottomTopObject_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds, time parameter for assignment)
		bottomTopObject_pt.play();  // Start animation
	}

	@Override
	public void playMovingObject_Right_Left(MovingObject movingObject, int paneWidth, int paneHeight) {
		
		// Create points to use for line that will be transition path for ice cream. 
		// Ice cream comes in from the right side edge, random line path to opposite side
		setX1(paneWidth  +10);
		setY1((int)(Math.random()*(paneHeight+1)));
		setX2(0 - 50);
		setY2((int)(Math.random()*(paneHeight+1)));
		
		// Create a path transition for the ice cream to move across the screen
					PathTransition rightLeftObject_pt = new PathTransition();
					rightLeftObject_pt.setDuration(Duration.millis(6667));   // The star will pass through the screen in 6.667 seconds.
					rightLeftObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  // Path is the line through these two sets of points
					rightLeftObject_pt.setNode(movingObject);   // Will need to modify abstract class to allow an image // Node that follows path is the ice cream
					rightLeftObject_pt.setCycleCount(3);   // cycle 3 times to equal 20 seconds for the game
					rightLeftObject_pt.play();  // Start animation
		
	}

	@Override
	public void playMovingObject_Left_Right(MovingObject movingObject, int paneWidth, int paneHeight) {
		
		// Create points to use for line that will be transition path for star. 
        // Star will come in from the left side of the window, random location. 
		setX1(0);
		setY1((int)(Math.random()*(paneHeight+1)));
		setX2(paneWidth + 50);
		setY2((int)(Math.random()*(paneHeight+1)));

		// Create a path transition for the star to move across the screen
		PathTransition leftRightObject_pt = new PathTransition();
		leftRightObject_pt.setDuration(Duration.millis(2857));   // The star will pass through the screen in 2.857 seconds.
		leftRightObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  //  Path is the line through these two sets of points
		leftRightObject_pt.setNode(movingObject);   // Will need to modify abstract class to allow an image // Node that follows path is the star
		leftRightObject_pt.setCycleCount(7);   // cycle 7 times to equal 20 seconds for the game
		leftRightObject_pt.play();  // Start animation
		
	}
	/* creates a random int with the rang of 1-4 inclusive. It then tests that value in a switch case and 
	 * depending on the switch case it will call the appropriate method to execute. This allows a random
	 * general path like top, bottom, left, or right side of the screen location. The methods it executes
	 * will randomize where the object will appear in these general locations and what path it will follow.
	 */
	@Override
	public void randomlyPickMovingObjectPath(MovingObject movingObject, int paneWidth, int paneHeight) {
		
		int path = (int) (Math.random()*4)+1;
		
		switch(path) {
		
		case 1:
			movingObject.playMovingObject_Top_Bottom(movingObject, paneWidth, paneHeight);
			break;
			
		case 2:
			movingObject.playMovingObject_Bottom_Top(movingObject, paneWidth, paneHeight);
			break;
			
		case 3:
			movingObject.playMovingObject_Right_Left(movingObject, paneWidth, paneHeight);
			break;
			
		case 4:
			movingObject.playMovingObject_Left_Right(movingObject, paneWidth, paneHeight);
			break;
		}
		
	}
}