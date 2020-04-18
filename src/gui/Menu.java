package gui;

import ciphers.CipherCaeser;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu extends Application{
	
	public static void main(String[] args) {
		String text = "If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.";
		
		CipherCaeser caeser = new CipherCaeser();
		int key = 9;
		String encryptedText = caeser.encrypt(text,key);
		System.out.println(encryptedText);
		System.out.println(caeser.decrypt(encryptedText, key));
		System.out.println("roqnqjmjwhcqrwplxwormnwcrjucxbjhqnfaxcnrcrwlryqnacqjcrbkhbxlqjwprwpcqnxamnaxocqnunccnabxocqnjuyqjknccqjcwxcjfxamlxdumknvjmnxdc");
		
//		// Generate random number between 5 to 30  
//        int a = ((int) Math.random() * 30);  
//        int b = 5 +  ((int) Math.random() * 30);  
//        // Output is different every time this code is executed    
//        System.out.println(a);  
//        System.out.println(b);
//		
		
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Button encryptButton = new Button("Encrypt Data");
		Button decryptButton = new Button("Decrypt Data");

        // Create the BorderPane (Outside Container)
		// Add the Labels, Textield and Buttons to the BorderPane
		BorderPane borderPane = new BorderPane();

		//Label at the top
		Label title = new Label("Input the text to encrypt/decrypt");
		title.setFont(new Font(20));
		borderPane.setTop(title);
		
		//Textarea in the center
		TextArea textArea = new TextArea();
		borderPane.setCenter(textArea);
		
        //Buttons at the bottom
		//Create HBox to hold all the buttons
		HBox hbox = new HBox(100,encryptButton,decryptButton);
		hbox.setAlignment(Pos.CENTER);
		//Set the HBox at the bottom of the borderpane
		borderPane.setBottom(hbox);
        
        // Create the Scene
        // Optional arguments are Scene(Parent root, double width, double height)
        Scene scene = new Scene(borderPane,400,500);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("Cyphers by Ari");
        // Display the Stage
        stage.show();       
	}
}
