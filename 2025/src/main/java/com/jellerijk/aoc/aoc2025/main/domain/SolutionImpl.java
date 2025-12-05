package com.jellerijk.aoc.aoc2025.main.domain;

import javafx.scene.Node;

public class SolutionImpl implements Solution {
	private final int day;
	private final String title;
	private final Node gui;

	public SolutionImpl(int day, String title, Node gui) {
		this.day = day;
		this.title = title;
		this.gui = gui;
	}

	@Override
	public int getDay() {
		return day;
	}

	@Override
	public String getTitle() {

		return title;
	}

	@Override
	public Node getGUI() {
		return gui;
	}

}
