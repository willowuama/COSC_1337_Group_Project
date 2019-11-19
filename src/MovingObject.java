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

	// Setters

}