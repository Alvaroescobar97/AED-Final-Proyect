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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLInstructionsController implements Initializable{
	
	@FXML
    private ImageView imgKey, imgSpace, imgBackground;

    @FXML
    private Button btnBack;

	@FXML
	void backMenu(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();

		AnchorPane gameViewParent;
		try {
			gameViewParent = (AnchorPane) loader.load(getClass().getResource("/view/MainView.fxml").openStream());
			Scene gameScene = new Scene(gameViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(gameScene);
			window.alwaysOnTopProperty();
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources){
		
        
	}
}
