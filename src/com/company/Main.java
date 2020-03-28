package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
    }

    public static long calculateDaysBetween(LocalDate initialDate, LocalDate finalDate)  {
        if(initialDate.isAfter(finalDate)) return -1;
        return ChronoUnit.DAYS.between(initialDate, finalDate) + 1; //doesn't include final day so we add 1
    }

    public static String getDateByDayOfYear(Year initialYear, int dayOfYear) {
        if(initialYear.isLeap()){
            if(dayOfYear < 1 | dayOfYear > 366) return "error";
        } else {
            if(dayOfYear < 1 | dayOfYear > 365) return "error";
        }
        LocalDate finalDate = initialYear.atDay(dayOfYear);
        return finalDate.getDayOfMonth() + " " + finalDate.getMonthValue();
    }

    public static int howManyTimes(LocalTime startTime, LocalTime finishTime, int numberToSeek) {
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


