package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import model.Box;
import model.Map;
import model.Player;

public class FXMLGameController implements Initializable {

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
		
		if (event.getCode() == KeyCode.UP) {
			
			map.movePlayer(Player.UP);
			refresh();
		} else if (event.getCode() == KeyCode.DOWN) {
			
			map.movePlayer(Player.DOWN);
			refresh();

		} else if (event.getCode() == KeyCode.LEFT) {
			
			map.movePlayer(Player.LEFT);
			refresh();
			
		} else if (event.getCode() == KeyCode.RIGHT) {
			
			map.movePlayer(Player.RIGHT);
			refresh();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		map = new Map();
		map.createLevelOne();
		fillLabelMatrix();
		refresh();	
		
		gameGrid.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        public void handle(KeyEvent ke) {
	            if (ke.getCode() == KeyCode.ENTER) {
	                System.out.println("Key Pressed: " + ke.getCode());
	            }
	        }
	    });
	}

	public void refresh() {
		for (int i = 0; i < Map.ROWS; i++) {
			for (int j = 0; j < Map.ROWS; j++) {
				labelImage(labels[i][j], i, j);
				gameGrid.add(labels[i][j], j, i);
			}
		}
	}

	public void fillLabelMatrix() {
		labels = new Label[Map.ROWS][Map.ROWS];

		for (int i = 0; i < Map.ROWS; i++) {
			for (int j = 0; j < Map.ROWS; j++) {
				labels[i][j] = new Label();
			}
		}
	}

	public void labelImage(Label label, int i, int j) {

		Box box = map.getBoxes()[i][j];

		if (map.getBoxes()[i][j].isBomberman()) {
			String path = map.getBomberman().getImage();
			Image image = new Image(getClass().getResourceAsStream(path));
			label.setGraphic(new ImageView(image));
		} else if (!box.isBreakable() && box.isOccupied() && !box.isFinish() && !box.isStart()) {
			Image image = new Image(getClass().getResourceAsStream("/data/Bloque1.png"));
			label.setGraphic(new ImageView(image));
		} else if (box.isBreakable() && box.isOccupied() && !box.isFinish() && !box.isStart()) {
			Image image = new Image(getClass().getResourceAsStream("/data/Caja1.png"));
			label.setGraphic(new ImageView(image));
		} else if (box.isStart()) {
			label.setStyle("-fx-background-color: black;");
		} else if (box.isFinish()) {
			label.setStyle("-fx-background-color: blue;");
		} else {
			Image image = new Image(getClass().getResourceAsStream("/data/Pasto1.png"));
			label.setGraphic(new ImageView(image));
		}
	}

}
