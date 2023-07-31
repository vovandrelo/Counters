package com.vovandrelo.counters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Person {
	private final int id;
	private final String firstName;
	private final String lastName;
	private final int age;
	private final CounterIndicators indicators;
}
