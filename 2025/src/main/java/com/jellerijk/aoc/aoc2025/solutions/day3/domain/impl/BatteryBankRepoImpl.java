package com.jellerijk.aoc.aoc2025.solutions.day3.domain.impl;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2025.solutions.day3.domain.BatteryBank;
import com.jellerijk.aoc.aoc2025.solutions.day3.domain.BatteryBankRepo;

public class BatteryBankRepoImpl implements BatteryBankRepo {
	private List<BatteryBank> banks;

	public BatteryBankRepoImpl() {
		this.banks = new ArrayList<BatteryBank>();
	}

	@Override
	public int calculateMaxJoltage() {
		return banks.stream().mapToInt(bank -> bank.calculateMaxJoltage()).reduce(0,
				(subtotal, element) -> subtotal + element);
	}

	@Override
	public List<BatteryBank> getBanks() {
		return banks;
	}

	@Override
	public void add(BatteryBank bank) {
		banks.add(bank);
	}

	@Override
	public void clear() {
		banks.clear();
	}

}
