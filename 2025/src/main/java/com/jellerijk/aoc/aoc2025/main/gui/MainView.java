package com.jellerijk.aoc.aoc2025.main.gui;

import com.jellerijk.aoc.aoc2025.main.controller.MainController;
import com.jellerijk.aoc.aoc2025.main.controller.MainControllerImpl;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessage;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessageType;
import com.jellerijk.aoc.aoc2025.util.interfaces.Subscriber;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane implements Subscriber {
	private final static double MAX_SIDEMENU_WIDTH = 150;
	private MainController controller;

	private SolutionsList sideMenu;

	public MainView() {
		this.controller = MainControllerImpl.getInstance();
		buildGUI();
	}

	private void buildGUI() {
		sideMenu = new SolutionsList(controller.getSolutions());
		sideMenu.subscribe(this);
		sideMenu.setMaxWidth(MAX_SIDEMENU_WIDTH);

		setLeft(sideMenu);
		updateSelectedGUI(new Label("Please select a solution."));
	}

	private void updateSelectedGUI(Node gui) {
		if (gui == null) {
			setCenter(new Label("The UI has not been implemented yet."));
		} else {
			setCenter(gui);
		}
		setMargin(getCenter(), new Insets(15));
	}

	public void update(PublisherMessage message) {
		if (message.source() == sideMenu && message.type() == PublisherMessageType.SELECTION_CHANGED) {
			updateSelectedGUI(sideMenu.getSelectedGUI());
		}
	}
}
