package com.jellerijk.aoc.aoc2025.main.controller;

import java.util.List;

import com.jellerijk.aoc.aoc2025.main.dtos.SolutionDTO;
import com.jellerijk.aoc.aoc2025.util.interfaces.Controller;

import javafx.scene.Node;

public interface MainController extends Controller {
	/**
	 * Returns a list of DTOs for all currently loaded Solutions.
	 * 
	 * @return ArrayList of SolutionDTOs
	 */
	public List<SolutionDTO> getSolutions();

	/**
	 * Returns a Node specifying the GUI for the given day.
	 * 
	 * @param day - the day for which the GUI will be returned.
	 * @return a Node containing the GUI.
	 */
	public Node getGUI(int day);
}
