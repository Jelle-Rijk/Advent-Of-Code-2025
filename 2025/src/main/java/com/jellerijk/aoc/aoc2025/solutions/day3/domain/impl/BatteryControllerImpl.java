package com.jellerijk.aoc.aoc2025.solutions.day3.domain.impl;

import com.jellerijk.aoc.aoc2025.solutions.day3.domain.BatteryBankRepo;
import com.jellerijk.aoc.aoc2025.solutions.day3.domain.BatteryController;

public class BatteryControllerImpl implements BatteryController {
	private BatteryBankRepo bankRepo;

	public BatteryControllerImpl() {
		this.bankRepo = new BatteryBankRepoImpl();
	}

	@Override
	public void addBank(String batteries) {
		bankRepo.add(new BatteryBankImpl(batteries));
	}

	@Override
	public int getMaxJoltage() {
		return bankRepo.calculateMaxJoltage();
	}

	@Override
	public void submitData(String data) {
		bankRepo.clear();
		for (String line : data.split("\n"))
			addBank(line);
	}

}
