package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import model.Box;
import model.Map;
import model.Player;

public class FXMLGameController implements Initializable{

	 private Map map;
	
	 private Label[][] labels;
	 
	 @FXML
	 private GridPane gameGrid;
	 
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
		 		refresh();
		 		break;
		 	case DOWN:
		 		map.movePlayer(Player.DOWN);
		 		refresh();
		 		break;
		 	case LEFT: 
		 		map.movePlayer(Player.LEFT);
		 		refresh();
		 		break;
		 	case RIGHT: 
		 		map.movePlayer(Player.RIGHT);
		 		refresh();
		 		break;
		 	default:
		 		break;
		 } 
	 }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		map =  new Map();
		map.createLevelOne();
		fillLabelMatrix();
		refresh();
	}
	
	public void refresh(){
		for(int i = 0; i < Map.ROWS; i++) {
			for(int j = 0; j <  Map.ROWS; j++) {
				labelImage(labels[i][j], i, j);
				gameGrid.add(labels[i][j], j, i);
			}
		}
	}
	
	public void fillLabelMatrix() {
		labels = new Label[Map.ROWS][Map.ROWS];
		
		for(int i = 0; i < Map.ROWS; i++) {
			for(int j = 0; j <  Map.ROWS; j++) {
				labels[i][j] = new Label("[" + i + "]" + "[" + j + "]");
			}
		}
	}
	 
	public void labelImage(Label label, int i, int j) {
		
		Box box = map.getBoxes()[i][j];
		
		if(map.getBoxes()[i][j].isBomberman()) {
			String path = map.getBomberman().getImage();
			Image image = new Image(getClass().getResourceAsStream(path));
		    label.setGraphic(new ImageView(image));
		}else if(!box.isBreakable() && box.isOccupied() && !box.isFinish() && !box.isStart()) {
			Image image = new Image(getClass().getResourceAsStream("/data/Bloque.jpg"));
		    label.setGraphic(new ImageView(image));
		}else if(box.isBreakable() && box.isOccupied() && !box.isFinish() && !box.isStart()) {
			Image image = new Image(getClass().getResourceAsStream("/data/Caja.jpg"));
		    label.setGraphic(new ImageView(image));
		}else if(box.isStart()){
			label.setStyle("-fx-background-color: black;");
		}else if(box.isFinish()) {
			label.setStyle("-fx-background-color: blue;");
		}else {
			Image image = new Image(getClass().getResourceAsStream("/data/Pasto.jpg"));
		    label.setGraphic(new ImageView(image));
		}
	}
	 
}
