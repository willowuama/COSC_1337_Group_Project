import javafx.scene.layout.Pane;

public abstract class MovingObject extends Pane {

	private int x1, x2, y1, y2; // Variables for points to create a line for path transition
	private int speed; // Speed of the object in miliseconds

	// Constructor
	protected MovingObject(){ // May change access to public. Ask Mark about this.

	}

	// Getters
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

	// Setters
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

	// Abstract Methods
<<<<<<< HEAD
	public abstract void playMovingObject_Top_Bottom(MovingObject movingObject, int paneWidth, int paneHeight);
	public abstract void playMovingObject_Bottom_Top(MovingObject movingObject, int paneWidth, int paneHeight);
	public abstract void playMovingObject_Right_Left(MovingObject movingObject, int paneWidth, int paneHeight);
	public abstract void playMovingObject_Left_Right(MovingObject movingObject, int paneWidth, int paneHeight);
=======
	public abstract void playMovingObject(MovingObject movingObject, int paneWidth, int paneHeight);
>>>>>>> 4c51ab1beb0d6d128844057ea6af4f47ae1495b3

}











