package com.jellerijk.aoc.aoc2025.solutions.day1.domain;

public class SafeControllerImpl implements SafeController {
	private Safe safe;

	@Override
	public int[] crackPassword(String instructions) {
		safe = new SafeImpl();
		SafeCracker sc = new SafeCrackerImpl(safe);

		for (String line : instructions.split("\n"))
			sc.execute(line);
		return new int[] { sc.getZeroes(), sc.getClicks() };
	}

}
