package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Box;
import model.Chronometer;
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
	
	
	public FXMLGameController() {
		this.map = new Map();
		this.gameGrid = new GridPane();
	}
	
	public void movePlayer(String event) {
		if (event.equals("UP")) {
			map.movePlayer(Player.UP);
			refresh();
		} else if (event.equals("DOWN")) {
			map.movePlayer(Player.DOWN);
			refresh();
		} else if (event.equals("LEFT")) {
			map.movePlayer(Player.LEFT);
			refresh();
		} else if (event.equals("RIGHT")) {
			map.movePlayer(Player.RIGHT);
			refresh();
		}else if(event.equals("SPACE")) {
			String temp = map.boom();
			refresh();
			boolean stop = false;
			
			Chronometer chrono = new Chronometer();
			chrono.start();
			
			while(!stop) {
				if(chrono.getSeconds() > 2) {
					stop = true;
					chrono.stop();
				}
				System.out.println(chrono.getSeconds() + "");
			}

			map.getBomberman().setImage(temp);
			refresh();
			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.map.createLevelOne();
		fillLabelMatrix();
		refresh();
	}

	public void refresh() {
		gameGrid.getChildren().clear();
		for (int i = 0; i < Map.ROWS; i++) {
			for (int j = 0; j < Map.ROWS; j++) {
				this.labelImage(labels[i][j], i, j);
				gameGrid.add(labels[i][j], j, i);
			}
		}
		lbNumSteps.setText(map.getBomberman().getSteps() + "");
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
		} else {
			Image image = new Image(getClass().getResourceAsStream("/data/Pasto1.png"));
			label.setGraphic(new ImageView(image));
		}
	}
}
