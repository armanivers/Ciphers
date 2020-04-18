package gui;

import ciphers.CipherCaeser;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EncryptionWindow {
	
	private static Stage stage;
	public static String encryptedText;
	
	public static String display(String title, String message,String rawText) {
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setMinWidth(250);
		
		Button encryptButton = new Button("Encrypt");
		
		stage.setOnCloseRequest(e -> {
			e.consume();
			exit();
		});
		encryptButton.setOnAction(e -> {
			CipherCaeser caeser = new CipherCaeser();
			encryptedText = caeser.encrypt(rawText, 5);
			exit();
		});
		
		Label displayText = new Label(message);
		displayText.setFont(new Font(40));
		
		//BorderPane layout
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(displayText);
		borderPane.setBottom(encryptButton);
		
		// Create the Scene
        // Optional arguments are Scene(Parent root, double width, double height)
        Scene scene = new Scene(borderPane);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle(title);
        // Display the Stage and wait until its closed to send the message
        stage.showAndWait();  
        
        
		return encryptedText;
	}
	
	private static void exit() {
		stage.close();
		//playsound??
	}

}
