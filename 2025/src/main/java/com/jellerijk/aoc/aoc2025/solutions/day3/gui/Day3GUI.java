package com.jellerijk.aoc.aoc2025.solutions.day3.gui;

import com.jellerijk.aoc.aoc2025.solutions.day3.domain.BatteryController;
import com.jellerijk.aoc.aoc2025.solutions.day3.domain.impl.BatteryControllerImpl;
import com.jellerijk.aoc.aoc2025.util.guicomponents.TextAreaSubmit;
import com.jellerijk.aoc.aoc2025.util.guicomponents.TextFieldOutput;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessage;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessageType;
import com.jellerijk.aoc.aoc2025.util.interfaces.Subscriber;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day3GUI extends HBox implements Subscriber {
	private TextAreaSubmit input;
	private VBox output;
	private TextFieldOutput output1;
	private TextFieldOutput output2;

	private BatteryController controller;

	public Day3GUI() {
		this.controller = new BatteryControllerImpl();
		buildGUI();
	}

	private void buildGUI() {
		input = new TextAreaSubmit("Input battery data", "Calculate Joltage");
		input.subscribe(this);

		output = new VBox();
		output1 = new TextFieldOutput("Max Joltage");
		output2 = new TextFieldOutput("Part 2");
		output.getChildren().addAll(output1, output2);

		getChildren().addAll(input, output);
	}

	@Override
	public void update(PublisherMessage message) {
		if (message.source() == input && message.type() == PublisherMessageType.SUBMIT) {
			try {
				controller.submitData(message.payload());
				output1.setOutput(controller.getMaxJoltage());
			} catch (Exception e) {
				output2.setError(String.format("%s - %s", e.getClass(), e.getMessage()));
				e.printStackTrace();
			}
		}
	}

}
