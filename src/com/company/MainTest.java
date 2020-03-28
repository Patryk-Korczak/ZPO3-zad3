package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

import static org.junit.Assert.assertEquals;

class MainTest {
    /*
    We assume all dates are already validated.
    For example by using LocalDateFormatter.

     */

    @org.junit.jupiter.api.Test
    void calculateDaysBetween() {
        assertEquals(2077, Main.calculateDaysBetween(LocalDate.parse("1939-09-01"), LocalDate.parse("1945-05-08")));
        assertEquals(-1, Main.calculateDaysBetween(LocalDate.parse("2022-02-02"), LocalDate.parse("1945-05-08")));
        assertEquals(1, Main.calculateDaysBetween(LocalDate.parse("1939-09-01"), LocalDate.parse("1939-09-01")));
        assertEquals(2, Main.calculateDaysBetween(LocalDate.parse("1939-09-01"), LocalDate.parse("1939-09-02")));
    }

    @org.junit.jupiter.api.Test
    void getDateByDayOfYear() {
        assertEquals("1 1", Main.getDateByDayOfYear(Year.parse("2020"), 1));
        assertEquals("error", Main.getDateByDayOfYear(Year.parse("2020"), 0));
        assertEquals("8 3", Main.getDateByDayOfYear(Year.parse("2016"), 68));
        assertEquals("29 2", Main.getDateByDayOfYear(Year.parse("2020"), 60));
        assertEquals("1 3", Main.getDateByDayOfYear(Year.parse("2021"), 60));
        assertEquals("error", Main.getDateByDayOfYear(Year.parse("2021"), -1));
    }

    @org.junit.jupiter.api.Test
    void howManyTimes() {
        assertEquals(50, Main.howManyTimes(LocalTime.parse("11:45"), LocalTime.parse("22:30"), 15));
        assertEquals(0, Main.howManyTimes(LocalTime.parse("11:45"), LocalTime.parse("11:45"),15));
        assertEquals(1, Main.howManyTimes(LocalTime.parse("21:39"), LocalTime.parse("21:39"),15));
        assertEquals(-1, Main.howManyTimes(LocalTime.parse("22:31"), LocalTime.parse("22:30"),15));
    }

    @org.junit.jupiter.api.Test
    void howManyLeapYears() {
        assertEquals(6, Main.howManyLeapYears(LocalDate.parse("1998-06-02")));
        assertEquals(1, Main.howManyLeapYears(LocalDate.parse("2020-02-29")));
        assertEquals(0, Main.howManyLeapYears(LocalDate.parse("2020-03-01")));
        assertEquals(-1, Main.howManyLeapYears(LocalDate.parse("2099-03-01")));
    }
}