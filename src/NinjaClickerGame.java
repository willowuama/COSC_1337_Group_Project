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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**  Main class to handle GUI components and game logic */
public class NinjaClickerGame extends Application{

	public static void main(String[] args) {
		launch();
	}
	
	// Label will be used to display the score
	private Label lblScore = new Label("Score: ");
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(lblScore);
		
		// create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 900, 700);
		primaryStage.setTitle("Ninja Clicker"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

}
