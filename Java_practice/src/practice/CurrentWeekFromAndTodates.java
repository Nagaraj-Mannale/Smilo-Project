package practice;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

public class CurrentWeekFromAndTodates {
    public static void main(String[] args) {
        // Get today's date
        LocalDate today = LocalDate.now();
        
        // Find the Monday of the current week
        LocalDate monday = today.with(DayOfWeek.MONDAY);
        
        // Format dates as needed (e.g., "yyyy-MM-dd")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String mondayFormatted = monday.format(formatter);
        String todayFormatted = today.format(formatter);
        
        // Output the range (Monday to today)
        System.out.println("Week Start (Monday): " + mondayFormatted);
        System.out.println("Current Day: " + todayFormatted);
    }
}