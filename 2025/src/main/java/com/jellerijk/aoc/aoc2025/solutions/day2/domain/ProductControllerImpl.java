package com.jellerijk.aoc.aoc2025.solutions.day2.domain;

public class ProductControllerImpl implements ProductController {
	private long invalidIDPart1;
	private long invalidIDPart2;

	public ProductControllerImpl() {
	}

	@Override
	public void inputRanges(String ranges) {
		setInvalidIDPart1(0);
		setInvalidIDPart2(0);

		for (String range : ranges.split(",")) {
			if (!range.matches("\\d+-\\d+"))
				throw new IllegalArgumentException(String.format("Invalid format for range: %s", range));

			String[] fromTo = range.split("-");
			long from = Long.parseLong(fromTo[0]);
			long to = Long.parseLong(fromTo[1]);

			long[] results = IDFinder.searchRange(from, to);
			setInvalidIDPart1(getInvalidIDPart1() + results[0]);
			setInvalidIDPart2(getInvalidIDPart2() + results[1]);
		}
	}

	public long getInvalidIDPart1() {
		return invalidIDPart1;
	}

	private void setInvalidIDPart1(long invalidIDPart1) {
		this.invalidIDPart1 = invalidIDPart1;
	}

	public long getInvalidIDPart2() {
		return invalidIDPart2;
	}

	private void setInvalidIDPart2(long invalidIDPart2) {
		this.invalidIDPart2 = invalidIDPart2;
	}

}
