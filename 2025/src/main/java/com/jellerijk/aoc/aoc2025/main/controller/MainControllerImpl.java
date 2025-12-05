package com.jellerijk.aoc.aoc2025.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.jellerijk.aoc.aoc2025.main.domain.Solution;
import com.jellerijk.aoc.aoc2025.main.dtos.SolutionDTO;
import com.jellerijk.aoc.aoc2025.main.persistence.SolutionsData;

import javafx.scene.Node;

public class MainControllerImpl implements MainController {
	private static MainControllerImpl instance;
	private final List<Solution> solutions;

	private MainControllerImpl() {
		this.solutions = SolutionsData.getSolutions();
	};

	public static MainController getInstance() {
		if (instance == null)
			instance = new MainControllerImpl();
		return instance;
	}

	public List<SolutionDTO> getSolutions() {
		List<SolutionDTO> dtos = new ArrayList<SolutionDTO>(solutions.size());
		solutions.forEach(solution -> dtos.add(SolutionDTO.create(solution)));
		return dtos;
	}

	@Override
	public Node getGUI(int day) throws NoSuchElementException {
		Solution solution = solutions.stream().filter(sol -> sol.getDay() == day).findFirst().orElseThrow();
		return solution.getGUI();
	}
}
