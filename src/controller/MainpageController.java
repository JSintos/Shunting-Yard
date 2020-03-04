package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ShuntingYard;

public class MainpageController {
	@FXML private Button convertBtn, helpBtn;
	@FXML private Label postfixL;
	@FXML private TextField infixTF;
	
	@FXML
	private void convert() {
		postfixL.setText(ShuntingYard.evaluateExpression(infixTF.getText()));
	}
	
	@FXML
	private void showHelp() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help");
		alert.setHeaderText("Help");
		alert.setContentText("When inputting an expression, for best results, put a space between and after each and every character. "
				+ "Even for parenthesis i.e. '( A + B )'.");
		
		alert.showAndWait();
	}
}