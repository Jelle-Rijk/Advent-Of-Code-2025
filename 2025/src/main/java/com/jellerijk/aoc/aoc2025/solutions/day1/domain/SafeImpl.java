package com.jellerijk.aoc.aoc2025.solutions.day1.domain;

import com.jellerijk.aoc.aoc2025.util.enums.RelativeDirection;

public class SafeImpl implements Safe {
	private final static int DEFAULT_DIAL_SIZE = 100;
	private final static int DEFAULT_STARTING_DIAL = 50;

	private final int dialSize;

	private int dial;

	public SafeImpl(int dialSize, int startingPos) {
		this.dialSize = dialSize;
		setDial(startingPos);
	}

	/**
	 * Creates a new Safe using the default size (100) and default starting position
	 * (50).
	 */
	public SafeImpl() {
		this(DEFAULT_DIAL_SIZE, DEFAULT_STARTING_DIAL);
	}

	@Override
	public void turnDial(RelativeDirection dir, int amount) {
		if (dir == RelativeDirection.LEFT)
			amount = -amount;
		int newDial = ((getDial() + amount) % dialSize + dialSize) % dialSize;
		setDial(newDial);
	}

	private void setDial(int dial) {
		if (dial < 0 || dial >= dialSize)
			throw new IllegalArgumentException(String.format("Not a valid dial value - %d", dial));
		this.dial = dial;
	}

	public int getDial() {
		return dial;
	}

	public int getDialSize() {
		return dialSize;
	}

}
