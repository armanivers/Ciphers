package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PopUpWindow {
	
	public static String warning="";
	
	public static void display(String title, String message) {
		
		Stage stage = new Stage();
		
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.setTitle(title);
		
		stage.setMinWidth(250);
		
		Label label = new Label(message);
		Button closeButton = new Button("Okay");
		closeButton.setOnAction(e -> stage.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		
		//Show window and wait for it to be closed before returning to previous stage
		stage.showAndWait();
	}

}
