package com.vovandrelo.counters;

import com.vovandrelo.counters.enums.Indicators;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class App {
	private static final String FILE_PATH = "/Users/vladimir/Desktop/FinalProject/src/main/resources/data.csv";

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(Paths.get(FILE_PATH)).useDelimiter("\\||\\s\\n");
		List<Person> persons = new ArrayList<>();

		while (scanner.hasNext()) {
			persons.add(
					new Person(scanner.nextInt(), scanner.next(), new CounterIndicators(
							scanner.nextInt(),
							scanner.nextInt(),
							scanner.nextInt(),
							scanner.nextInt(),
							scanner.nextInt())));
		}
		scanner.close();

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
