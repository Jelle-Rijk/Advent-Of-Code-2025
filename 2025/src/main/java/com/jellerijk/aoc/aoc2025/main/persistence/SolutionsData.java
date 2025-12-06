package com.jellerijk.aoc.aoc2025.main.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2025.main.domain.Solution;
import com.jellerijk.aoc.aoc2025.main.domain.SolutionImpl;
import com.jellerijk.aoc.aoc2025.solutions.day1.gui.Day1GUI;
import com.jellerijk.aoc.aoc2025.solutions.day2.gui.Day2GUI;
import com.jellerijk.aoc.aoc2025.solutions.day3.gui.Day3GUI;

import javafx.scene.Node;

public class SolutionsData {
	public static List<Solution> getSolutions() {
		List<Solution> solutions = new ArrayList<Solution>();

		addSolution(solutions, 1, "Secret Entrance", new Day1GUI());
		addSolution(solutions, 2, "Gift Shop", new Day2GUI());
		addSolution(solutions, 3, "Lobby", new Day3GUI());
		addSolution(solutions, 4, "Printing Department");
		addSolution(solutions, 5, "Cafeteria");
		addSolution(solutions, 6);
		addSolution(solutions, 7);
		addSolution(solutions, 8);
		addSolution(solutions, 9);
		addSolution(solutions, 10);
		addSolution(solutions, 11);
		addSolution(solutions, 12);

		return solutions;
	}

	private static void addSolution(List<Solution> list, int day) {
		addSolution(list, day, "No title yet");
	}

	private static void addSolution(List<Solution> list, int day, String title) {
		addSolution(list, day, title, null);
	}

	private static void addSolution(List<Solution> list, int day, String title, Node gui) {
		Solution solution = new SolutionImpl(day, title, gui);
		list.add(solution);
	}

}
