package com.jellerijk.aoc.aoc2025.solutions.day1.domain;

public interface SafeController {
	/**
	 * Cracks the password for the first piece of the puzzle.
	 * 
	 * @param instructions - String containing the lines with instructions.
	 * @return int[] {password, clicks}
	 */
	public int[] crackPassword(String instructions);
}
