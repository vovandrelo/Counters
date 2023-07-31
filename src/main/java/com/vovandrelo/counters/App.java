package com.vovandrelo.counters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
	public static void main(String[] args) {
		Person pers1 = new Person(1, "Анатолий", "Носов", 20, new CounterIndicators(45, 0, 567, 200, 789));
		Person pers2 = new Person(4, "Роман", "Успенский", 31, new CounterIndicators(12, 15, 17, 400, 300));
		Person pers3 = new Person(17, "Анфиса", "Рыжкова", 31, new CounterIndicators(6, 78, 789, 66, 55));
		Person pers4 = new Person(20, "Злата", "Аксёнова", 31, new CounterIndicators(189, 56, 76, 54, 34));
		Person pers5 = new Person(2, "Влад", "Корнев", 31, new CounterIndicators(45, 34, 45, 76, 67));

		List<Person> persons = new ArrayList<>(List.of(pers1, pers2, pers3, pers4, pers5));

		System.out.println("Поучение максимальных значений:");
		Optional<Person> maxWaterIndicator = IndicatorsComparator.getMaxIndicator(persons, Indicators.WATER);
		Optional<Person> maxGasIndicator = IndicatorsComparator.getMaxIndicator(persons, Indicators.GAS1);
		System.out.println(maxWaterIndicator.orElseThrow(RuntimeException::new));
		System.out.println(maxGasIndicator.orElseThrow(RuntimeException::new));

		System.out.println("Поучение минимальных значений:");
		Optional<Person> minWaterIndicator = IndicatorsComparator.getMaxIndicator(persons, Indicators.WATER);
		Optional<Person> minElectroIndicator = IndicatorsComparator.getMaxIndicator(persons, Indicators.ELECTRO2);
		System.out.println(minWaterIndicator.orElseThrow(RuntimeException::new));
		System.out.println(minElectroIndicator.orElseThrow(RuntimeException::new));

		System.out.println("Поучение значений в указанном промежутке:");
		List<Person> waterSegment = IndicatorsComparator.getIndicatorsSegment(persons, Indicators.WATER, 40, 50);
		List<Person> gasSegment = IndicatorsComparator.getIndicatorsSegment(persons, Indicators.GAS2, 100, 200);
		System.out.println(waterSegment);
		System.out.println(gasSegment);
	}
}
