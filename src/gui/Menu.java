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
		String text = "Hallo das ist ein Geheimnis";
		
		CipherCaeser caeser = new CipherCaeser();
		
		
		System.out.println(caeser.encrypt(text,1));
		System.out.println(caeser.generateKey());
		
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Button encryptButton = new Button("Encrypt Data");
		Button decryptButton = new Button("Decrypt Data");
		
	
		
		// Create the Text Fields
        //TextField firstNameFld = new TextField();
 
        // Create the Labels
        //Label firstNameLbl = new Label("_First Name:");
         
        // Bind the Label to the according Field
        //firstNameLbl.setLabelFor(firstNameFld);
        // Set mnemonic parsing to the Label
        //firstNameLbl.setMnemonicParsing(true);
         

         
        // Create the BorderPane (Outside Container)
		// Add the Labels, Textield and Buttons to the BorderPane
		BorderPane borderPane = new BorderPane();
		
		
		//Label at the top
		Label title = new Label("Input the text to encrypt/decrypt");
		title.setFont(new Font(20));
		borderPane.setTop(title);
		//
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
