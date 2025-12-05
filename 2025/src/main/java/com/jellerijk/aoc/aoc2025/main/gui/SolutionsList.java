package com.jellerijk.aoc.aoc2025.main.gui;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2025.main.dtos.SolutionDTO;
import com.jellerijk.aoc.aoc2025.util.interfaces.Publisher;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessage;
import com.jellerijk.aoc.aoc2025.util.interfaces.PublisherMessageType;
import com.jellerijk.aoc.aoc2025.util.interfaces.Subscriber;

import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class SolutionsList extends ListView<SolutionDTO> implements Publisher {
	private final List<Subscriber> subscribers;
	private final List<SolutionDTO> solutions;

	public SolutionsList(List<SolutionDTO> solutions) {
		this.solutions = solutions;
		subscribers = new ArrayList<Subscriber>();
		defineCells();
		buildGUI();
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subscribers;
	}

	private void defineCells() {
		this.setCellFactory(listView -> new ListCell<SolutionDTO>() {
			@Override
			protected void updateItem(SolutionDTO item, boolean empty) {
				super.updateItem(item, empty);

				if (empty || item == null) {
					setText(null);
					setGraphic(null);
				} else {
					setText(String.format("Day %d - %s", item.day(), item.name()));
				}
			}
		});
	}

	private void buildGUI() {
		// Add the cells
		solutions.forEach(solution -> {
//			String solutionView = buildSolutionView(solution);
			getItems().add(solution);
		});

		this.getSelectionModel().selectedIndexProperty().addListener(e -> onSelectionChange());

		this.setWidth(USE_COMPUTED_SIZE);

	}

	private void onSelectionChange() {
		notifySubscribers(new PublisherMessage(this, PublisherMessageType.SELECTION_CHANGED, null));
	}

	public Node getSelectedGUI() {
		return this.getSelectionModel().getSelectedItem().gui();
	}

}
