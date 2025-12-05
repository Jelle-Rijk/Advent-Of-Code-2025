package com.jellerijk.aoc.aoc2025.solutions.day1.domain;

import com.jellerijk.aoc.aoc2025.util.enums.RelativeDirection;

public interface Safe {
	/**
	 * Changes the Safe's dial's position by the set amount in the set dir.
	 * 
	 * @param dir    - left or right
	 * @param amount - amount of change
	 */
	public void turnDial(RelativeDirection dir, int amount);

	/**
	 * Returns the current position of the Safe's dial.
	 * 
	 * @return dial's current position
	 */
	public int getDial();

	public int getDialSize();
}
