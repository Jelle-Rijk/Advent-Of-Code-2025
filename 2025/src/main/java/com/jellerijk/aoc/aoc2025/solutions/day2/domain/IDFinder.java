package com.jellerijk.aoc.aoc2025.solutions.day2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public abstract class IDFinder {
	/**
	 * Searches all ints between from and to (inclusive) with two repeated
	 * sequences.
	 * 
	 * @param from
	 * @param to
	 * @return Array of two long values containing the calculation for both parts of
	 *         the puzzle.
	 */
	public static long[] searchRange(long from, long to) {

		List<Long> repeatingSequences = LongStream.rangeClosed(from, to).filter(id -> checkRepeatingSequence(id))
				.boxed().collect(Collectors.toList());

		// Part1
		long part1 = repeatingSequences.stream().filter(input -> checkDoubleSequence(input)).reduce(0L,
				(subtotal, element) -> subtotal + element);
		long part2 = repeatingSequences.stream().reduce(0L, (subtotal, element) -> subtotal + element);
		return new long[] { part1, part2 };
	}

	private static boolean checkDoubleSequence(long input) {
		String id = Long.toString(input);
		if (id.length() % 2 != 0)
			return false;
		int mid = id.length() / 2;
		return id.substring(0, mid).equals(id.substring(mid));
	}

	private static boolean checkRepeatingSequence(long input) {
		String id = Long.toString(input);
		return (id.matches("\\b(\\d+)\\1+\\b"));
	}
}
