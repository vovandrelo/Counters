package com.vovandrelo.counters;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IndicatorsComparator {
	public static Optional<Person> getMaxIndicator(List<Person> persons, Indicators indicator) {
		Stream<Person> personsStream = persons.stream();
		return personsStream
				.max(Comparator.comparingInt(x -> x.getIndicators().getIndicator(indicator)));
	}

	public static Optional<Person> getMinIndicator(List<Person> persons, Indicators indicator) {
		Stream<Person> personsStream = persons.stream();
		return personsStream
				.min(Comparator.comparingInt(x -> x.getIndicators().getIndicator(indicator)));
	}

	public static List<Person> getIndicatorsSegment(List<Person> persons, Indicators indicator, int moreThan, int lessThan) {
		Stream<Person> personsStream = persons.stream();
		return personsStream
				.filter(x -> x.getIndicators().getIndicator(indicator) > moreThan &&
						x.getIndicators().getIndicator(indicator) < lessThan)
				.collect(Collectors.toList());
	}
}
