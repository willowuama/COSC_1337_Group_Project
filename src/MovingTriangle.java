/* Ninja Clicker Game - Group Project
 *
 * Authors:  Teresa Iles, William Owuama, Albert Rosas, Mark Wilson
 * Due Date:  11/21/19
 * Course:  COSC 1137 Fundamentals of Programming II
 * Instructor:  Greg Yera
 *
 * This program is a game that allows the player to click on moving objects that pass across the screen.  The player earns points each time
 * they successfully click on an object.  The game lasts 20 seconds.  The score is displayed and updated while the game is played.  A countdown
 * timer is displayed in the upper right corner.
 *
 */

/* This class extends from the MovingObject class and creates an instance of the MovingObject which is a MovingTriangle.  The class contains
 * methods for randomizing where it comes in on the screen.  It can come in from the top, bottom, left side, or right side.  The class creates
 * a path transition for the triangle using the randomly generated entry and exit points.
 */

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class MovingTriangle extends MovingObject {

	// Constructor
	public MovingTriangle(){
		Polygon triangle = new Polygon(100, 50, 150, 0, 200, 50);
		triangle.setStroke(Color.BLACK);
		triangle.setFill(Color.RED);
		getChildren().add(triangle);
	}

	/** Randomizer-line path:  Creates a random line path from the top to the bottom of the screen for animation of the MovingTriangle object */
	@Override
	public void playMovingObject_Top_Bottom(MovingObject movingObject, int paneWidth, int paneHeight){
		// Create points to use for line that will be transition path for triangle
		// Triangle will come in from the top of the window, random location.
		setX1((int)(Math.random()*(paneWidth+1)));
		setY1(0);
		setX2((int)(Math.random()*(paneWidth+1)));
		setY2(paneHeight+50);

		// Create a path transition for the triangle to move across the screen
		PathTransition topBottomObject_pt = new PathTransition();
		topBottomObject_pt.setDuration(Duration.seconds(5));   // It takes a triangle 5 seconds to pass along the full length of the screen
		topBottomObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  //  Path is the line through these two sets of points
		topBottomObject_pt.setNode(movingObject);   // Node that follows path is the triangle
		topBottomObject_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds)
		topBottomObject_pt.play();  // Start animation
	}

	/** Randomizer-line path:  Creates a random line path from the bottom to the top of the screen for animation of the MovingTriangle object */
	@Override
	public void playMovingObject_Bottom_Top(MovingObject movingObject, int paneWidth, int paneHeight) {

		// Create points to use for line that will be transition path for triangle
		// Triangle will come in from the top of the window, random location.
		setX1((int)(Math.random()*(paneWidth+1)));
		setY1(paneHeight);
		setX2((int)(Math.random()*(paneWidth+1)));
		setY2(-50);

		// Create a path transition for the triangle to move across the screen
		PathTransition bottomTopObject_pt = new PathTransition();
		bottomTopObject_pt.setDuration(Duration.seconds(5));  // It takes a triangle 5 seconds to pass along the full length of the screen
		bottomTopObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  //  Path is the line through these two sets of points
		bottomTopObject_pt.setNode(movingObject);   // Node that follows path is the triangle
		bottomTopObject_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds)
		bottomTopObject_pt.play();  // Start animation
	}

	/** Randomizer-line path:  Creates a random line path from the right side to the left side of the screen for animation of the
	 * MovingTriangle object
	 */
	@Override
	public void playMovingObject_Right_Left(MovingObject movingObject, int paneWidth, int paneHeight) {

		// Create points to use for line that will be transition path for triangle
		// Triangle will come in from the top of the window, random location.
		setX1(paneWidth  +10);
		setY1((int)(Math.random()*(paneHeight+1)));
		setX2(-100);
		setY2((int)(Math.random()*(paneHeight+1)));

		// Create a path transition for the triangle to move across the screen
		PathTransition rightLeftObject_pt = new PathTransition();
		rightLeftObject_pt.setDuration(Duration.seconds(5)); // It takes a triangle 5 seconds to pass along the full length of the screen
		rightLeftObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  // Path is the line through these two sets of points
		rightLeftObject_pt.setNode(movingObject);   // Node that follows path is the triangle
		rightLeftObject_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds)
		rightLeftObject_pt.play();  // Start animation
	}

	/** Randomizer-line path:  Creates a random line path from the left side to the right side of the screen for animation of the
	 * MovingTriangle object
	 */
	@Override
	public void playMovingObject_Left_Right(MovingObject movingObject, int paneWidth, int paneHeight) {

		// Create points to use for line that will be transition path for triangle.
	    // Triangle will come in from the left side of the window, random location.
		setX1(0);
		setY1((int)(Math.random()*(paneHeight+1)));
		setX2(paneWidth + 100);
		setY2((int)(Math.random()*(paneHeight+1)));

		// Create a path transition for the triangle to move across the screen
		PathTransition leftRightObject_pt = new PathTransition();
		leftRightObject_pt.setDuration(Duration.seconds(5)); // It takes a triangle 5 seconds to pass along the full length of the screen
		leftRightObject_pt.setPath(new Line(getX1(), getY1(), getX2(), getY2()));  //  Path is the line through these two sets of points
		leftRightObject_pt.setNode(movingObject);   // Node that follows path is the triangle
		leftRightObject_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds)
		leftRightObject_pt.play();  // Start animation
	}

	/** Randomizer for choosing which window edge:
	 * This method creates a random int with the range of 1-4 inclusive. It then tests that value in a switch case and
	 * depending on the switch case it will call the appropriate method to execute. This allows a random
	 * general path like top, bottom, left, or right side of the screen location. The methods it executes
	 * will randomize where the movingObject will appear in these general locations and what path it will follow.
	 */
	@Override
	public void randomlyPickMovingObjectPath(MovingObject movingObject, int paneWidth, int paneHeight){

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
		}   // End switch statement
	}

}  // End MovingTriangle class
