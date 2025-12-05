package com.jellerijk.aoc.aoc2025.util.guicomponents;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TextFieldOutput extends VBox {
	private Label label;
	private TextField txfOutput;
	private Label errorLabel;

	private final String lblText;
	private final String placeholder;

	public TextFieldOutput(String lblText, String placeholder) {
		this.lblText = lblText;
		this.placeholder = placeholder;
		buildGUI();
	}

	public TextFieldOutput(String lblText) {
		this(lblText, "N/A");
	}

	public TextFieldOutput() {
		this("Result");
	}

	public void setError(String error) {
		errorLabel.setText(error);
	}

	public void setOutput(int output) {
		setOutput(Integer.toString(output));
	}

	public void setOutput(String output) {
		errorLabel.setText("");
		txfOutput.setText(output);
	}

	private void buildGUI() {
		label = new Label(lblText);

		txfOutput = new TextField();
		txfOutput.setEditable(false);
		txfOutput.setPromptText(placeholder);

		errorLabel = new Label();
		errorLabel.setStyle("-fx-font-weight: bold;");
		errorLabel.setTextFill(Color.RED);

		getChildren().addAll(label, txfOutput, errorLabel);
	}

}
