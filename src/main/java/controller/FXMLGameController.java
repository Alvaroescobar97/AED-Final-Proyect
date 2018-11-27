package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import model.Map;
import model.Player;

public class FXMLGameController implements Initializable{

	 private Map map;
	
	 @FXML
	 private Label lbTime;
	
	 @FXML
	 private Label lbNumTime;
	 
	 @FXML
	 private Label lbSteps;
	 
	 @FXML
	 private Label lbNumSteps;
	 
	 @FXML
	 private Label lbMaxSteps;
	
	 @FXML
	 private Label lbNumMaxSteps;
	
	 
	 @FXML
	 public void movePlayer(KeyEvent event) {
		 switch(event.getCode()) {
		 	case UP: 
		 		map.movePlayer(Player.UP);
		 		break;
		 	case DOWN:
		 		map.movePlayer(Player.DOWN);
		 		break;
		 	case LEFT: 
		 		map.movePlayer(Player.LEFT);
		 		break;
		 	case RIGHT: 
		 		map.movePlayer(Player.RIGHT);
		 		break;
		 } 
	 }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		map =  new Map();
		map.createLevelOne();
		//fillGui();
	}
	
	public void fillGui(){
		
	}
	 
	 
	 
	 
	 
	 
	 
}
