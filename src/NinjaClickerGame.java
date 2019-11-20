/* Ninja Clicker Game - Group Project
 * 
 * Authors:  Teresa Iles, William Owuama, Albert Rosas, Mark Wilson
 * Due Date:  11/21/19
 * Course:  COSC 1137 Fundamentals of Programming II
 * Instructor:  Greg Yera
 * 
 * This program is a game that allows the player to click on moving objects that pass across the screen.  The player earns points each time
 * they successfully click on an object.  The game lasts 20 seconds.  The score is displayed and updated while the game is played.
 * 
 */

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
//import java.util.concurrent.TimeUnit;

/**  Main class to handle GUI components and game logic */
public class NinjaClickerGame extends Application{

	public static void main(String[] args) {
		launch();
	}
	
	/* .getChildren().remove(arg) will probably be need to set a new score, and to 
	 * remove a moving object once it has been clicked.
	 */
	// or maybe need to use .getChildren().clear(); // Clear the pane before redisplay
	
	/* Variable used to track the score by being incremented whenever a mouse click 
	 * event is fired.
	 */
	private int paneWidth = 900;	// pane width for game
	private int paneHeight = 700;	// pane height for game
	
	public static int score = 0;    // global variable to keep track of game score ***may need to make non static
	
	public Label lblScore = new Label("Score: " + score);
	
	int rectangle_count = 0;	         // Counter to create multiple rectangles in do-while loop
	int star_count = 0;					 // Counter to create multiple stars in do-while loop
	int iceCream_count = 0;              // Counter to create multiple ice creams in do-while loop
	
	// variables for the timer
	private static final Integer STARTTIME = 20;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		//for the timer
		Group root = new Group();
		VBox vb_timer = new VBox(20);
		vb_timer.setAlignment(Pos.BOTTOM_RIGHT);
		vb_timer.getChildren().add(timerLabel);
		vb_timer.setLayoutY(30);
		root.getChildren().add(vb_timer);
		
		
		if (timeline != null) //{
            timeline.stop();
        //}
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME+1),
                new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
		
		
		// Bind the timerLabel text property to the timeSeconds property
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");
		
		// Label will be used to display the score
		lblScore.setFont(Font.font("Times New Roman)", 40));	//  Make score font bigger

		// Creates an instance of the target - MovingObject class
		MovingObject triangle = new MovingTriangle();  // Create a MovingObject of type MovingTriangle
		MovingObject square = new MovingSquare();  // Create a MovingObject of type MovingSquare
		MovingObject circle = new MovingCircle(); // create a MovingObject of type MovingCircle
		
		// create a Pane object, used to store MovingObject objects
		Pane pane = new Pane();
		
		// adds the instances of MovingObject to pane
		pane.getChildren().add(triangle);
		pane.getChildren().add(square);
		pane.getChildren().add(circle);
		
		// BorderPane is used to set up the window for the game
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(lblScore);    // Score will be shown at the bottom of the screen
		borderPane.setCenter(pane);      // Game set up in the middle of the screen
		System.out.println(score);         // Another check for the game score  **Note: this prints zero, so it prints before game starts
		
		borderPane.setRight(root);
		// method from the MovingObject class that creates an animation path across from the left to the right
		//triangle.playMovingObject(triangle);
		//for(int count = 0; count < 4; count++) {
<<<<<<< HEAD
			square.playMovingObject_Bottom_Top(square, paneWidth, paneHeight);
=======
<<<<<<< HEAD
			square.playMovingObject_Top_Bottom(square, paneWidth, paneHeight);
=======
			square.playMovingObject(square, paneWidth, paneHeight);
>>>>>>> 4c51ab1beb0d6d128844057ea6af4f47ae1495b3
>>>>>>> 34db8653ef72b43a7b32e357d00b8f50e46a6a2e
		//}
		
		//circle.playMovingObject(circle);
		
		
		// Event Handling for triangle
		triangle.setOnMousePressed(e -> {
			pane.getChildren().remove(triangle);
			
			/* might not even need because setText is either covering the
			 * values with the updated values or is actually removing and 
			 * updating the lblScore string on its own.
			 */
			borderPane.getChildren().remove(lblScore);
			score += 2;
			// String to replace/update the previous string in lblScore
			String stringScore = "Score: " + score;
			// updates the text with stringScore
			lblScore.setText(stringScore);
			borderPane.setBottom(lblScore);
		});
		
		// Event Handling for square
		square.setOnMousePressed(e -> {
			pane.getChildren().remove(square);
			
			/* might not even need because setText is either covering the
			 * values with the updated values or is actually removing and 
			 * updating the lblScore string on its own.
			 */
			borderPane.getChildren().remove(lblScore);
			score += 5;
			// String to replace/update the previous string in lblScore
			String stringScore = "Score: " + score;
			// updates the text with stringScore
			lblScore.setText(stringScore);
			borderPane.setBottom(lblScore);
		});
		
		// Event Handling for circle
		circle.setOnMousePressed(e -> {
			pane.getChildren().remove(circle);
			
			/* might not even need because setText is either covering the
			 * values with the updated values or is actually removing and 
			 * updating the lblScore string on its own.
			 */
			borderPane.getChildren().remove(lblScore);
			score++;
			// String to replace/update the previous string in lblScore
			String stringScore = "Score: " + score;
			// updates the text with stringScore
			lblScore.setText(stringScore);
			borderPane.setBottom(lblScore);
		});
		
		// target.mousePressHandling(target, pane, borderPane); Alternative to implementing event handling in the GUI class
		
		// create a scene and place it in the stage
		Scene scene = new Scene(borderPane, paneWidth, paneHeight);
		primaryStage.setTitle("Ninja Clicker"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}


	//public abstract class MovingObject extends Pane {

		//private int x1, y1, x2, y2;  // Variables for points to create a line for rectangle's path transition
		//private int s_x1, s_y1, s_x2, s_y2;  // Variables for points to create a line for star's path transition
		//private int i_x1, i_y1, i_x2, i_y2;  // Variables for points to create a line for ice cream's path transition
		
		
		// used to determine the speed of the MovingObject object in milliseconds
		//private int speed;
		

		//protected MovingObject() { // may need to change visibility to public
			
			
		//}
		
		// getter methods for x1, y1, x2, y2, and speed
		/*public int getX1() {
			return x1;
		}
		
		public int getY1() {
			return y1;
		}
		
		public int getX2() {
			return x2;
		}
		
		public int getY2() {
			return y2;
		}
		
		public int getSpeed() {
			return speed;
		}
		
		// Setter methods for x1, y1, x2, y2, and speed
		public void setX1(int x1) {
			this.x1 = x1;
		}
		
		public void setY1(int y1) {
			this.y1 = y1;
		}
		
		public void setX2(int x2) {
			this.x2 = x2;
		}
		
		public void setY2(int y2) {
			this.y2 = y2;
		}
		
		public void setSpeed(int speed) {
			this.speed = speed;
		}*/
		// end of getter/setter methods
		
		// The do-while loop code is better suited in the main GUI class, or make a method for the do-while loop and run that method in the GUI class
			/*
			// Code for rectangle
			// Enter a do-while loop for creating a rectangle_count number of rectangles
			do {	
			// Create a rectangle
			Rectangle rectangle = new Rectangle(0, 0, 25, 50);
			rectangle.setStroke(Color.BLACK);
			rectangle.setFill(Color.ORANGE);
			getChildren().add(rectangle);

			// Create points to use for line that will be transition path for rectangle.  
			// Rectangle will come in from the top of the window, random location. 
			r_x1 = (int)(Math.random()*(paneWidth+1));
			r_y1 = 0;
			r_x2 = (int)(Math.random()*(paneWidth+1));
			r_y2 = paneHeight+50;

			// Create a path transition for the rectangle to move across the screen
			PathTransition rectangle_pt = new PathTransition();
			rectangle_pt.setDuration(Duration.seconds(5));   // It takes a rectangle 5 seconds to pass along the full length of the screen
			rectangle_pt.setPath(new Line(r_x1, r_y1, r_x2, r_y2));  //  Path is the line through these two sets of points
			rectangle_pt.setNode(rectangle);   // Node that follows path is the rectangle
			rectangle_pt.setCycleCount(4);   // cycle 4 times  (4  x 5 seconds = 20 seconds, time parameter for assignment)
			rectangle_pt.play();  // Start animation

			// Mouse Pressed event handler.  When the mouse is pressed while over a rectangle, this code will run.
			rectangle.setOnMousePressed(e -> {
				getChildren().remove(rectangle);   // Remove the rectangle from the screen
				NinjaClickerGame.score+=5;   // Increase the game score.  Rectangles worth 5 points.
				System.out.println(NinjaClickerGame.score);    // Check that score is updating (outputs score to console)
				NinjaClickerGame.setLabel(NinjaClickerGame.scoreString);  // update lblscore in main class
			});

			rectangle_count++;  // Increase rectangle_count for the loop control

			} while (rectangle_count < 10);  // end of do-while loop that creates ten rectangles for the game
			*/
			
			/*
			// Code for star
			// Enter a do-while loop for creating a star_count number of stars
			do {
			// Create a star and add it to the pane
			ImageView star = new ImageView("star.jpg");
			getChildren().add(star);

			// Create points to use for line that will be transition path for star. 
	        // Star will come in from the left side of the window, random location. 
			s_x1 = 10;
			s_y1 = (int)(Math.random()*(paneHeight+1));
			s_x2 = paneWidth + 50;
			s_y2 = (int)(Math.random()*(paneHeight+1));

			// Create a path transition for the star to move across the screen
			PathTransition pt_star = new PathTransition();
			pt_star.setDuration(Duration.millis(2857));   // The star will pass through the screen in 2.857 seconds.
			pt_star.setPath(new Line(s_x1, s_y1, s_x2, s_y2));  //  Path is the line through these two sets of points
			pt_star.setNode(star);   // Node that follows path is the star
			pt_star.setCycleCount(7);   // cycle 7 times to equal 20 seconds for the game
			pt_star.play();  // Start animation

			// Mouse Pressed event handler.  When the mouse is pressed while over a rectangle, this code will run.
			star.setOnMousePressed(e -> {
				getChildren().remove(star);
				NinjaClickerGame.score+=3;    // Increase the game score.  Stars are worth 3 points.
				System.out.println(NinjaClickerGame.score);  // Check that score is updating (outputs score to console)
				NinjaClickerGame.setLabel(NinjaClickerGame.scoreString);  // update lblscore in main class
			});

			star_count++;  // Increase rectangle_count for the loop control

			} while (star_count < 6);  // end of do-while loop that creates six stars for the game
			*/
			
			
		    // code for ice cream
			// Enter a do-while loop for creating a iceCream_count number of ice creams
			/*do {
			ImageView iceCream = new ImageView("ice-cream.jpg");
			getChildren().add(iceCream);

			// Create points to use for line that will be transition path for ice cream. 
			// Ice cream comes in from the right side edge, random line path to opposite side 
			i_x1 = paneWidth+10;
			i_y1 = (int)(Math.random()*(paneHeight+1));
			i_x2 = 0-50;
			i_y2 = (int)(Math.random()*(paneHeight+1));

			// Create a path transition for the ice cream to move across the screen
			PathTransition pt_iceCream = new PathTransition();
			pt_iceCream.setDuration(Duration.millis(6667));   // The star will pass through the screen in 6.667 seconds.
			pt_iceCream.setPath(new Line(i_x1, i_y1, i_x2, i_y2));  // Path is the line through these two sets of points
			pt_iceCream.setNode(iceCream);   // Node that follows path is the ice cream
			pt_iceCream.setCycleCount(3);   // cycle 3 times to equal 20 seconds for the game
			pt_iceCream.play();  // Start animation

			// Mouse Pressed event handler.  When the mouse is pressed while over an ice cream, this code will run.
			iceCream.setOnMousePressed(e -> {
				getChildren().remove(iceCream);   // Remove the ice cream from the window
				NinjaClickerGame.score+=2;   // Increase the game score by 2.  Ice creams are worth 2 points.
				System.out.println(NinjaClickerGame.score);    // Check that score is updating (outputs score to console)
				NinjaClickerGame.setLabel(NinjaClickerGame.scoreString);  // update lblscore in main class
			});

			iceCream_count++;    // Increase iceCream_count for the loop control

			}  while (iceCream_count < 8);   // end of do-while loop that creates eight ice creams for the game
			*/
		
		// Code for randomizing and creating a animation path for an instance of MovingObject
		//public abstract void playMovingObject(MovingObject movingObject);// {
			
			// MovingObject object comes in from the left side edge, random line path to opposite side ***PROPERTY BINDING NEED?***
					/*	x1 = 0;
						y1 = (int)(Math.random()*(paneHeight+1));
						x2 = paneWidth + 50;
						y2 = (int)(Math.random()*(paneHeight+1));
						
						// random speed
						int speed = (int)(Math.random()* 3000) + 500;
						
						
						// Ice cream comes in from the right side edge, random line path to opposite side 
						/*x1 = paneWidth+10;
						y1 = (int)(Math.random()*(paneHeight+1));
						x2 = 0-50;
						y2 = (int)(Math.random()*(paneHeight+1));
						*/
						
						// Create a path transition
						/*PathTransition ptObject = new PathTransition(Duration.millis(speed), new Line(x1, y1, x2, y2), movingObject);
						ptObject.play();
		}*/
		
		// A method to be a possible alternative to event handling methods
		/*public void mousePressHandling(MovingObject movingObject, Pane pane, BorderPane borderPane) {
			movingObject.setOnMousePressed(e -> {
				pane.getChildren().remove(movingObject);*/
				
				/* might not even need because setText is either covering the
				 * values with the updated values or is actually removing and 
				 * updating the lblScore string on its own.
				 */
				/*borderPane.getChildren().remove(lblScore);
				score += 2;
				// String to replace/update the previous string in lblScore
				String stringScore = "Score: " + score;
				// updates the text with stringScore
				lblScore.setText(stringScore);
				borderPane.setBottom(lblScore);
			});
		}*/
	//} // small possibility might need to make the concrete sub classes of MovingObject inner class of MovingObject **highly doubt will need to**
		
		 

}
