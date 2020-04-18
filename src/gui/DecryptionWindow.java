package gui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class DecryptionWindow {
	
	public static String encryptedText="";
	
	public static String display(String title, String message,String decryptedText) {
		
		Stage stage = new Stage();
		
		Label displayText = new Label(message);
		displayText.setFont(new Font(10));
		
		//BorderPane layout
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(displayText);
		
		// Create the Scene
        // Optional arguments are Scene(Parent root, double width, double height)
        Scene scene = new Scene(borderPane);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle(title);
        // Display the Stage
        stage.show();  
        
        
		return encryptedText;
	}

}
