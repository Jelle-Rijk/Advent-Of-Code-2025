package com.jellerijk.aoc.aoc2025.util.guicomponents;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2025.util.interfaces.Publisher;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessage;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessageType;
import com.jellerijk.aoc.aoc2025.util.interfaces.Subscriber;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class TextAreaSubmit extends VBox implements Publisher {
	private String prompt;
	private String buttonText;

	private List<Subscriber> subscribers;

	private Label lblPrompt;
	private TextArea txaInput;
	private Button btnSubmit;

	public TextAreaSubmit(String prompt, String buttonText) {
		setPrompt(prompt);
		setButtonText(buttonText);

		subscribers = new ArrayList<Subscriber>();

		buildGUI();
	}

	private void buildGUI() {
		lblPrompt = new Label(getPrompt());
		txaInput = new TextArea();
		txaInput.setPromptText(getPrompt());
		btnSubmit = new Button(getButtonText());

		btnSubmit.setOnAction(
				e -> notifySubscribers(new PublisherMessage(this, PublisherMessageType.SUBMIT, txaInput.getText())));

		getChildren().addAll(lblPrompt, txaInput, btnSubmit);
		this.setSpacing(10);
	}

//	GETTERS - SETTERS

	private String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	private String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subscribers;
	}

}
