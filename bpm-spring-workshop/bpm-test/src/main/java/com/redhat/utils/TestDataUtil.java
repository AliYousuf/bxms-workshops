package com.redhat.utils;

import org.joda.time.LocalDate;

import com.redhat.approval.entities.Employee;
import com.redhat.approval.entities.VacationRequest;

public class TestDataUtil {

	private static Employee mary = new Employee("msmith", "Mary", "Smith", null);
	private static Employee tom = new Employee("tbrown", "Thomas", "Brown", mary);
	private static LocalDate startDate = new LocalDate(2015, 7, 6);
	private static LocalDate shortEndDate = new LocalDate(2015, 7, 7);
	private static LocalDate longEndDate = new LocalDate(2015, 7, 10);
	private static VacationRequest shortVacationRequest = new VacationRequest(tom, startDate, shortEndDate);
	private static VacationRequest longVacationRequest = new VacationRequest(tom, startDate, longEndDate);

	
	public static Employee getMary() {
		return mary;
	}

	public static Employee getTom() {
		return tom;
	}

	public static LocalDate getStartDate() {
		return startDate;
	}

	public static LocalDate getShortEndDate() {
		return shortEndDate;
	}

	public static LocalDate getLongEndDate() {
		return longEndDate;
	}

	public static VacationRequest getShortVacationRequest() {
		return shortVacationRequest;
	}

	public static VacationRequest getLongVacationRequest() {
		return longVacationRequest;
	}


}
