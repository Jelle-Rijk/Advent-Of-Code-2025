package com.jellerijk.aoc.aoc2025.controllers.main.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.jellerijk.aoc.aoc2025.controllers.main.MainController;
import com.jellerijk.aoc.aoc2025.domains.main.Solution;
import com.jellerijk.aoc.aoc2025.dtos.main.SolutionDTO;
import com.jellerijk.aoc.aoc2025.persistence.SolutionsData;

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
