package com.jellerijk.aoc.aoc2025.solutions.day1.domain;

public interface SafeCracker {
	/**
	 * Returns how many zeroes were encountered during the cracking of the safe.
	 * 
	 * @return amount of zeroes encountered
	 */
	public int getZeroes();

	public void execute(String instruction);

	public int getClicks();
}
