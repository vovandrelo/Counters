package com.vovandrelo.counters;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CounterIndicators {
	private final int waterCount;
	private final int gasCount1;
	private final int gasCount2;
	private final int electroCount1;
	private final int electroCount2;

	public int getIndicator(Indicators indicator) {
		switch (indicator) {
			case WATER:
				return waterCount;
			case GAS1:
				return gasCount1;
			case GAS2:
				return gasCount2;
			case ELECTRO1:
				return electroCount1;
			case ELECTRO2:
				return electroCount2;
			default:
				throw new RuntimeException();
		}
	}
}


enum Indicators {
	WATER,
	GAS1,
	GAS2,
	ELECTRO1,
	ELECTRO2,
}
