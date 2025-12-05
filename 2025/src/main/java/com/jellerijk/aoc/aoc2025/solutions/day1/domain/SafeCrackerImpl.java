package com.jellerijk.aoc.aoc2025.solutions.day1.domain;

import com.jellerijk.aoc.aoc2025.util.enums.RelativeDirection;

public class SafeCrackerImpl implements SafeCracker {
	private final Safe safe;
	private int zeroes;
	private int clicks;

	public SafeCrackerImpl(Safe safe) {
		if (safe == null)
			throw new IllegalArgumentException("Cannot crack a null safe.");
		this.safe = safe;
	}

	@Override
	public int getZeroes() {
		return zeroes;
	}

	@Override
	public void execute(String instruction) {
		RelativeDirection dir = switch (instruction.charAt(0)) {
		case 'L' -> RelativeDirection.LEFT;
		case 'R' -> RelativeDirection.RIGHT;
		default -> throw new IllegalArgumentException(
				String.format("Instruction \"%s\" is not formatted correctly.", instruction));
		};

		int amount = Integer.parseInt(instruction.substring(1));

		countClicks(dir, amount, safe.getDial(), safe.getDialSize());

		safe.turnDial(dir, amount);
		if (safe.getDial() == 0)
			incrementZeroes();
	}

	private void countClicks(RelativeDirection dir, int amount, int curDial, int dialSize) {
		int clicks = 0;
		if (dir == RelativeDirection.LEFT) {
			int newDial = curDial - amount;
			if (newDial <= 0) {
				clicks = (int) Math.floor(newDial / -dialSize) + 1;
				if (curDial == 0)
					clicks -= 1;
			}
		} else {
			int newDial = curDial + amount;
			if (newDial >= dialSize) {
				clicks = (int) Math.floor(newDial / dialSize);
			}
		}
//		System.out.println(String.format("Counted %d clicks, starting from %d and moving %d spots to the %s", clicks,
//				curDial, amount, dir == RelativeDirection.LEFT ? "left" : "right"));
		setClicks(getClicks() + clicks);
	}

	private void setZeroes(int zeroes) {
		if (zeroes < 0)
			throw new IllegalArgumentException("Zeroes cannot be a negative number.");
		this.zeroes = zeroes;
	}

	private void incrementZeroes() {
		setZeroes(getZeroes() + 1);
	}

	public int getClicks() {
		return clicks;
	}

	private void setClicks(int clicks) {
		if (clicks < 0)
			throw new IllegalArgumentException("Zeroes cannot be a negative number.");
		this.clicks = clicks;
	}

}
