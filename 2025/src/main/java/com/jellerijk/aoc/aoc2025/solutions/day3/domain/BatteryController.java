package com.jellerijk.aoc.aoc2025.solutions.day3.domain;

public interface BatteryController {
	/**
	 * Adds a Bank to the repo.
	 * @param batteries
	 */
	public void addBank(String batteries);

	/**
	 * Calculates the max joltage and returns it.
	 * @return
	 */
	public int getMaxJoltage();
	
	/**
	 * Processes the puzzle input.
	 * @param data
	 */
	public void submitData(String data);
}
