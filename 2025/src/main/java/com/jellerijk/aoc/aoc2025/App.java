package com.jellerijk.aoc.aoc2025;

import com.jellerijk.aoc.aoc2025.main.gui.MainView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
	private final static double WINDOW_WIDTH = 1040;
	private final static double WINDOW_HEIGHT = 768;

	@Override
	public void start(Stage stage) {

		Scene scene = new Scene(new MainView(), WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}