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

/* This NinjaClickerGame class is the main class that runs the game.  It creates the stage and scene and launches the application.
 * This class sets up the timer, the score label, a Pane to hold the the moving objects, and a BorderPane to hold everything.
 * This class holds the event handlers for the mouse clicks.
 *
 * We added a multiplier effect, where we send out multiple instances of each object at once.
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**  Main class to handle GUI components and game logic */
public class NinjaClickerGame extends Application{

	private int paneWidth = 900;	// pane width for game
	private int paneHeight = 700;	// pane height for game

	private static int score = 0;    // global variable to keep track of game score

	private int squareCount = 0;	        // Counter to create multiple squares in a multiplier do-while loop
	private int triangleCount = 0;			// Counter to create multiple triangles in a multiplier do-while loop
	private int circleCount = 0;            // Counter to create multiple circles in a multiplier do-while loop

	// variables for the timer
	private static final Integer STARTTIME = 20;   // Constant holds the start time for the countdown
    private Timeline timeline;                     // Timeline object
    private Label timerLabel = new Label();        // A Label object to hold the timer
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);  // Variable that holds the value of the time as it counts down

    /** Main method to run the program, launch the JavaFX Application */
	public static void main(String[] args) {
		launch();
	}

	/** Start method for running the GUI */
    @Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

    	/** This section is the code for the game timer, which is located in the upper right corner of the Border Pane
    	 * Resource for timer code:  https://asgteach.com/2011/10/javafx-animation-and-binding-simple-countdown-timer-2/  */
    	// Create a VBox to hold the timer
		Group timer = new Group();
		VBox vb_timer = new VBox(20);
		vb_timer.setAlignment(Pos.BOTTOM_RIGHT);
		vb_timer.getChildren().add(timerLabel);
		vb_timer.setLayoutY(30);
		timer.getChildren().add(vb_timer);

		// Create a Timeline Animation to control the timer
		if (timeline != null) {
            timeline.stop();
        }
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME),
                new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();

		// Bind the timerLabel text property to the timeSeconds property and display it
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");


        /** Create a label to display the score */
        Label lblScore = new Label("Score: " + score);
		lblScore.setFont(Font.font("Times New Roman)", 40));

		/** reate a Pane object, used to store MovingObject objects */
		Pane pane = new Pane();

		/** BorderPane is used to set up the window for the game */
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(lblScore);    // Score will be shown at the bottom of the screen
		borderPane.setCenter(pane);        // Game set up in the middle of the screen
		borderPane.setRight(timer);		   // Time will be shown at the top right of the screen

		/** Control moving objects, handle mouse clicks events, and update score */
		/** Square object game control */
		// The do-while loop creates a multiplier effect, such that squareCount number of squares will move across the screen simultaneously
		do {

			// Creates an instance of the target - MovingObject class
			MovingObject square = new MovingSquare();  // Create a MovingObject of type MovingSquare

			// Adds the instance of movingObject to pane
			pane.getChildren().add(square);

			// Method from the MovingObject class that randomly chooses a method for an animation path across the screen
			square.randomlyPickMovingObjectPath(square, paneWidth, paneHeight);

			// Event Handling for square
			square.setOnMousePressed(e -> {

				// Remove the object from the pane
				pane.getChildren().remove(square);

				// Remove the score label so that we can replace it with new score
				borderPane.getChildren().remove(lblScore);

				// Increase the game score by 5 (fastest moving object)
				score += 5;

				// Update score label with the new score
				lblScore.setText("Score: " + score);
				borderPane.setBottom(lblScore);
			});

			// Increase counter by one for do-while loop
			squareCount++;

		}  while (squareCount < 6);

		/** Circle object game control */
		// The do-while loop creates a multiplier effect, such that circleCount number of circles will move across the screen simultaneously
		do {

			// Creates an instance of the target - MovingObject class
			MovingObject circle = new MovingCircle();   // Create a MovingObject of type MovingCircle

			// Adds the instance of movingObject to pane
			pane.getChildren().add(circle);

			// Method from the MovingObject class that randomly chooses a method for an animation path across the screen
			circle.randomlyPickMovingObjectPath(circle, paneWidth, paneHeight);

			// Event Handling for circle
			circle.setOnMousePressed(e -> {

				// Remove the object from the pane
				pane.getChildren().remove(circle);

				// Remove the score label so that we can replace it with new score
				borderPane.getChildren().remove(lblScore);

				// Increase the game score by one (slowest moving object)
				score++;

				// Update score label with the new score
				lblScore.setText("Score: " + score);
				borderPane.setBottom(lblScore);
			});

			// Increase counter by one for do-while loop
			circleCount++;

		}  while (circleCount < 8);

		/** Triangle object game control */
		// The do-while loop creates a multiplier effect, such that triangleCount number of triangles will move across the screen simultaneously
		do {

			// Creates an instance of the target - MovingObject class
			MovingObject triangle = new MovingTriangle();   // Create a MovingObject of type MovingTriangle

			// Adds the instance of MovingObject to pane
			pane.getChildren().add(triangle);

			// Method from the MovingObject class that randomly chooses a method for an animation path across the screen
			triangle.randomlyPickMovingObjectPath(triangle, paneWidth, paneHeight);

			// Event Handling for triangle
			triangle.setOnMousePressed(e -> {

				// Remove the object from the pane
				pane.getChildren().remove(triangle);

				// Remove the score label so that we can replace it with new score
				borderPane.getChildren().remove(lblScore);

				// Increase the game score by two (middle-speed moving object)
				score += 2;

				// Update score label with the new score
				lblScore.setText("Score: " + score);
				borderPane.setBottom(lblScore);
		});

			// Increase counter by one for do-while loop
			triangleCount++;

		}  while (triangleCount < 10);


		/** Create a scene and place it in the stage */
		Scene scene = new Scene(borderPane, paneWidth, paneHeight);
		primaryStage.setTitle("Ninja Clicker"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

    }   // End start block

}  // End NinjaClickerGame class
