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

public class FMXLMainController implements Initializable {

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
	public void eventExit(ActionEvent event) {

	}

	@FXML
	public void startGame(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();

		AnchorPane gameViewParent;
		try {
			gameViewParent = (AnchorPane) loader.load(getClass().getResource("/designs/Stats.fxml").openStream());
			FXMLGameController gameController = (FXMLGameController) loader.getController();

			Scene gameScene = new Scene(gameViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(gameScene);
			window.alwaysOnTopProperty();
			window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void showInstructions() {
	}

	@FXML
	public void exit() {

	}

}
