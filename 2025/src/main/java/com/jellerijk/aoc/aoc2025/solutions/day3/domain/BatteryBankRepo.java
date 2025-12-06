package com.jellerijk.aoc.aoc2025.solutions.day3.domain;

import java.util.List;

public interface BatteryBankRepo {
	/**
	 * Returns all banks.
	 * 
	 * @return
	 */
	public List<BatteryBank> getBanks();

	/**
	 * Adds a bank to the repo.
	 * 
	 * @param bank
	 */
	public void add(BatteryBank bank);

	/**
	 * Calculates maxJoltage of every bank in the repo.
	 * 
	 * @return
	 */
	public int calculateMaxJoltage();

	public void clear();
}
