package com.jellerijk.aoc.aoc2025.main.dtos;

import com.jellerijk.aoc.aoc2025.main.domain.Solution;

import javafx.scene.Node;

public record SolutionDTO(int day, String name, Node gui) {
	public static SolutionDTO create(Solution solution) {
		return new SolutionDTO(solution.getDay(), solution.getTitle(), solution.getGUI());
	}
}
