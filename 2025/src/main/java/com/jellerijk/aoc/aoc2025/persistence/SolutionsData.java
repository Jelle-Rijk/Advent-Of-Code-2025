package com.jellerijk.aoc.aoc2025.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2025.domains.main.Solution;
import com.jellerijk.aoc.aoc2025.domains.main.impl.SolutionImpl;

import javafx.scene.Node;

public class SolutionsData {
	public static List<Solution> getSolutions() {
		List<Solution> solutions = new ArrayList<Solution>();

		addSolution(solutions, 1);
		addSolution(solutions, 2);
		addSolution(solutions, 3);
		addSolution(solutions, 4);
		addSolution(solutions, 5);
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
