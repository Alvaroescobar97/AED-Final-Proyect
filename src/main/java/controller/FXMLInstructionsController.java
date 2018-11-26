package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLInstructionsController {
	@FXML
	private Button btnBack;

	@FXML
	void backMenu(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();

		AnchorPane gameViewParent;
		try {
			gameViewParent = (AnchorPane) loader.load(getClass().getResource("/view/MainView.fxml").openStream());
			FXMLMainController gameController = (FXMLMainController) loader.getController();
			Scene gameScene = new Scene(gameViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(gameScene);
			window.alwaysOnTopProperty();
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
