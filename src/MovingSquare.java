public class MovingSquare extends MovingObject {

	// Constructor 
	public MovingSquare(){
		Rectangle rectangle = new Rectangle(0, 0, 50, 50);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.ORANGE);
		getChildren().add(rectangle);
	}

	@Override
	public void playMovingObject(MovingObject movingObject){
		// TODO Auto-generated method stub
	}
}