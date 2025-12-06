package com.jellerijk.aoc.aoc2025.solutions.day2.gui;

import com.jellerijk.aoc.aoc2025.solutions.day2.domain.ProductController;
import com.jellerijk.aoc.aoc2025.solutions.day2.domain.ProductControllerImpl;
import com.jellerijk.aoc.aoc2025.util.guicomponents.TextAreaSubmit;
import com.jellerijk.aoc.aoc2025.util.guicomponents.TextFieldOutput;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessage;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessageType;
import com.jellerijk.aoc.aoc2025.util.interfaces.Subscriber;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day2GUI extends HBox implements Subscriber {
	private TextAreaSubmit input;
	private VBox output;

	private TextFieldOutput output1;
	private TextFieldOutput output2;

	private ProductController controller;

	public Day2GUI() {
		this.controller = new ProductControllerImpl();
		buildGUI();
	}

	private void buildGUI() {
		input = new TextAreaSubmit("Enter ID ranges", "Check IDs");
		input.subscribe(this);

		output = new VBox();
		output1 = new TextFieldOutput("Invalid ID total");
		output2 = new TextFieldOutput();
		output.getChildren().addAll(output1, output2);

		getChildren().addAll(input, output);
	}

	@Override
	public void update(PublisherMessage message) {
		if (message.source() == input && message.type() == PublisherMessageType.SUBMIT) {
			try {
				controller.inputRanges(message.payload());
				output1.setOutput(controller.getInvalidIDPart1());
				output2.setOutput(controller.getInvalidIDPart2());
			} catch (Exception e) {
				output2.setError(String.format("%s - %s", e.getClass(), e.getMessage()));
			}
		}

	}
}
