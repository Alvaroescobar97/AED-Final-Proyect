package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLMainController implements Initializable {

	@FXML
	private Button btnStartGame;

	@FXML
	private Button btnInstructions;

	@FXML
	private Button btnExit;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	@FXML
	public void startGame(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameView.fxml")); 
		
		try {  

			Parent root = (Parent)loader.load();          
			FXMLGameController controller = loader.<FXMLGameController>getController();

			Scene gameScene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			window.setScene(gameScene);
			window.alwaysOnTopProperty();
			window.show();
			
			gameScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					controller.movePlayer(event.getCode().toString());
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@FXML
    public void instruccionsView(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();

		AnchorPane instructionsViewParent;
		try {
			instructionsViewParent = (AnchorPane) 
					loader.load(getClass().getResource("/view/Instructions.fxml").openStream());

			Scene instructionsScene = new Scene(instructionsViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(instructionsScene);
			window.alwaysOnTopProperty();
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}

}
