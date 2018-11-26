package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

		FXMLLoader loader = new FXMLLoader();

		AnchorPane gameViewParent;
		try {
			gameViewParent = (AnchorPane) loader.load(getClass().getResource("/view/GameView.fxml").openStream());
			FXMLGameController gameController = (FXMLGameController) loader.getController();

			Scene gameScene = new Scene(gameViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(gameScene);
			window.alwaysOnTopProperty();
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@FXML
    public void instruccionsView(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();

		AnchorPane instructionsViewParent;
		try {
			instructionsViewParent = (AnchorPane) loader.load(getClass().getResource("/view/Instructions.fxml").openStream());
			FXMLInstructionsController instructionsController = (FXMLInstructionsController) loader.getController();

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
