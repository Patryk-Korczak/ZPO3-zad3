package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;

import static java.util.Objects.isNull;

public class Main {

    public static void main(String[] args) {
    }

    public static long calculateDaysBetween(LocalDate initialDate, LocalDate finalDate)  {
        /*
        calculateDaysBetween - returns number of days between dates including last day.
        Example: 2019-01-01 : 2019-01-02 returns 2.
        If parameters are incorrect returns -1.
         */

        if(isNull(initialDate) | isNull(finalDate)) return -1;
        if(initialDate.isAfter(finalDate)) return -1;
        return ChronoUnit.DAYS.between(initialDate, finalDate) + 1;
    }

    public static String getDateByDayOfYear(Year initialYear, int dayOfYear) {
        /*
        getDateByDayOfYear returns String containing number of day and month that is X-th day of given year.
        Example: Year 2000 and day 2 will return "2 1".
        Returns "error" if parameters are invalid.
         */
        if(isNull(initialYear)) return "error";
        if(initialYear.isLeap()){
            if(dayOfYear < 1 | dayOfYear > 366) return "error";
        } else {
            if(dayOfYear < 1 | dayOfYear > 365) return "error";
        }
        LocalDate finalDate = initialYear.atDay(dayOfYear);
        return finalDate.getDayOfMonth() + " " + finalDate.getMonthValue();
    }

    public static int howManyTimes(LocalTime startTime, LocalTime finishTime, int numberToSeek) {
        /*
        howManyTimes returns how many times in period of time sum of digits in time were equal to numberToSeek.
        Example: From 21:38 to 21:39 sum of digits is equal to 15 only once at 21:39.
        Returns -1 if parameters are invalid.
         */
        if(isNull(startTime) | isNull(finishTime)) return -1;
        if(startTime.isAfter(finishTime)) return -1;
        int count = 0;

        do {
            String hours = String.valueOf(startTime.getHour());
            String minutes = String.valueOf(startTime.getMinute());
            int digitsValue = 0;

            for(char c : hours.toCharArray()){
                digitsValue += Character.getNumericValue(c);
            }

            for(char c : minutes.toCharArray()){
                digitsValue += Character.getNumericValue(c);
            }

            if(digitsValue == numberToSeek) {
                //System.out.println(hours + ":" + minutes);
                count++;
            }
            startTime = startTime.plusMinutes(1);
        } while(startTime.isBefore(finishTime) | startTime.equals(finishTime));

        return count;
    }

    public static int howManyLeapYears(LocalDate birthDate) {
        /*
        Returns number of 29th days of February from given date until current date.
        Example: Since 1998-06-02 there were 6 days of 29th February (6 leap years).
        Returns -1 if parameters are invalid.
         */
        if(isNull(birthDate)) return -1;
        LocalDate currentDate = LocalDate.now();
        if(birthDate.isAfter(currentDate)) return -1;
        int countedLeapYears = 0;

        while(birthDate.isBefore(currentDate) | birthDate.isEqual(currentDate)) {
            if(birthDate.getMonthValue() == 2) {
                if(birthDate.getDayOfMonth() == 29){
                    countedLeapYears++;
                }
            }
            birthDate = birthDate.plusDays(1);
        }

        return countedLeapYears;
    }
}


