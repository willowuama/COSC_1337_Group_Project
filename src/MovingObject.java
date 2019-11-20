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

/* This is the target class from which the game objects extend.
 *
 */

import javafx.scene.layout.Pane;

public abstract class MovingObject extends Pane {

	private int x1, x2, y1, y2; // Variables for points to create a line for path transition
	private int speed; // Speed of the object in milliseconds

	// Constructor
	protected MovingObject() {
	}

	// Getters for the (x, y) coordinates of the 2 points of the path transition line
	public int getX1(){
		return x1;
	}

	public int getX2(){
		return x2;
	}

	public int getY1(){
		return y1;
	}

	public int getY2(){
		return y2;
	}

	public int getSpeed(){
		return speed;
	}

	// Setters for the (x, y) coordinates of the 2 points of the path transition line
	public void setX1(int x1){
		this.x1 = x1;
	}

	public void setX2(int x2){
		this.x2 = x2;
	}

	public void setY1(int y1){
		this.y1 = y1;
	}

	public void setY2(int y2){
		this.y2 = y2;
	}

	public void setSpeed(int speed){
		this.speed = speed;
	}

	/***Abstract Methods to animate movingObjects from each edge of the screen*/
	public abstract void playMovingObject_Top_Bottom(MovingObject movingObject, int paneWidth, int paneHeight);
	public abstract void playMovingObject_Bottom_Top(MovingObject movingObject, int paneWidth, int paneHeight);
	public abstract void playMovingObject_Right_Left(MovingObject movingObject, int paneWidth, int paneHeight);
	public abstract void playMovingObject_Left_Right(MovingObject movingObject, int paneWidth, int paneHeight);

	/** Abstract method to randomly pick an edge of the screen */
	public abstract void randomlyPickMovingObjectPath(MovingObject movingObject, int paneWidth, int paneHeight);

}  // End MovingObject class
