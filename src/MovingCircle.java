public class MovingCirle extends MovingObject {

	// Constructor
	public MovingCirle(){
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