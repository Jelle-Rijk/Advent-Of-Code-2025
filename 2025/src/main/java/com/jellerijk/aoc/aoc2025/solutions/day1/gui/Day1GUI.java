package com.jellerijk.aoc.aoc2025.solutions.day1.gui;

import com.jellerijk.aoc.aoc2025.solutions.day1.domain.SafeController;
import com.jellerijk.aoc.aoc2025.solutions.day1.domain.SafeControllerImpl;
import com.jellerijk.aoc.aoc2025.util.guicomponents.TextAreaSubmit;
import com.jellerijk.aoc.aoc2025.util.guicomponents.TextFieldOutput;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessage;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessageType;
import com.jellerijk.aoc.aoc2025.util.interfaces.Subscriber;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day1GUI extends HBox implements Subscriber {
	private TextAreaSubmit input;
	private TextFieldOutput output1;
	private TextFieldOutput output2;

	private SafeController controller;

	public Day1GUI() {
		this.controller = new SafeControllerImpl();
		buildGUI();
	}

	private void buildGUI() {
		input = new TextAreaSubmit("Please input the instructions.", "Crack safe");
		input.subscribe(this);

		output1 = new TextFieldOutput("Password");
		output2 = new TextFieldOutput("method 0x434C49434B");
		VBox output = new VBox(output1, output2);
		output.setSpacing(10);

		getChildren().addAll(input, output);
		this.setSpacing(10);
	}

	private void submitData(String instructions) {
		System.out.println("Data submitted");
		try {
			int[] results = controller.crackPassword(instructions);
			int password = results[0];
			int clicks = results[1];
			output1.setOutput(password);
			output2.setOutput(clicks);
		} catch (Exception e) {
			output2.setError(e.getMessage());
		}
	}

	@Override
	public void update(PublisherMessage message) {
		if (message.source() == input && message.type() == PublisherMessageType.SUBMIT) {
			submitData(message.payload());
		}
	}
}
