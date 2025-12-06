package com.jellerijk.aoc.aoc2025.solutions.day3.domain.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.jellerijk.aoc.aoc2025.solutions.day3.domain.Battery;
import com.jellerijk.aoc.aoc2025.solutions.day3.domain.BatteryBank;

public class BatteryBankImpl implements BatteryBank {
	List<Battery> batteries;

	public BatteryBankImpl(String batteriesString) {
		this.batteries = new ArrayList<Battery>();

		for (String batteryStr : batteriesString.split("")) {
			this.batteries.add(new Battery(Integer.parseInt(batteryStr)));
		}
	}

	@Override
	public int calculateMaxJoltage() {
		Battery maxBattery = batteries.stream().max(Comparator.comparing(Battery::joltage)).orElseThrow();
		System.out.println(String.format("MaxBattery was calculated as %d", maxBattery.joltage()));
		int maxBatteryIndex = batteries.indexOf(maxBattery);

		int firstOption = -1, secondOption = -1;
		
		if (maxBatteryIndex > 0) {
		Battery leftMax = batteries.subList(0, maxBatteryIndex).stream().max(Comparator.comparing(Battery::joltage))
				.orElseThrow();

		System.out.println(String.format("LeftMax was calculated as %d", leftMax.joltage()));
		firstOption = Integer.parseInt(String.format("%d%d", leftMax.joltage(), maxBattery.joltage()));
		}

		if (maxBatteryIndex < batteries.size() - 1) {
			Battery rightMax = batteries.subList(maxBatteryIndex + 1, batteries.size()).stream()
					.max(Comparator.comparing(Battery::joltage)).orElseThrow();
			System.out.println(String.format("RightMax was calculated as %d", rightMax.joltage()));
			secondOption = Integer.parseInt(String.format("%d%d", maxBattery.joltage(), rightMax.joltage()));			
		}

		return Math.max(secondOption, firstOption);
	}

}
