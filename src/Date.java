/**
 * This class represents the date based off of the Gregorian Calendar
 *
 * @author David Ha, Andrew McAvoy
 */

import java.util.StringTokenizer;
import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;

    final int JANUARY = 1;
    final int FEBRUARY = 2;
    final int MARCH = 3;
    final int APRIL = 4;
    final int MAY = 5;
    final int JUNE = 6;
    final int JULY = 7;
    final int AUGUST = 8;
    final int SEPTEMBER = 9;
    final int OCTOBER = 10;
    final int NOVEMBER = 11;
    final int DECEMBER = 12;

    /**
     * Constructor for the date
     *
     * @param date takes in the date and creates Date object with format mm/dd/yyyy
     */
    public Date(String date) {
        StringTokenizer tokenizer = new StringTokenizer(date, "/");
        month = Integer.parseInt(tokenizer.nextToken());
        day = Integer.parseInt(tokenizer.nextToken());
        year = Integer.parseInt(tokenizer.nextToken());
    }

    /**
     * Default constructor for the date based off of today's date
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1; //Add 1 to correct for Calendar class Zero-Indexing
        this.day = calendar.get(Calendar.DATE);
    }

    /**
     * Checks if the date is valid
     *
     * @return boolean value for validity of date
     */
    public boolean isValid() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        if ((year < 1900) || (year > currentYear)) {
            return false;
        }
        if ((month < JANUARY) || (month > DECEMBER)) {
            return false;
        }
        if ((month == JANUARY) || (month == MARCH) || (month == MAY) ||
                (month == JULY) || (month == AUGUST) || (month == OCTOBER) || (month == DECEMBER)) {
            if ((day < 0) || (day > 31)) {
                return false;
            }
        } else if ((month == APRIL) || (month == JUNE) || (month == SEPTEMBER) || (month == NOVEMBER)) {
            if ((day < 0) || (day > 30)) {
                return false;
            }
        } else {
            if (isLeapYear(year)) {
                if ((day < 0) || (day > 29)) {
                    return false;
                }
            } else if ((day < 0) || (day > 28)) { //Assumes isLeapYear has returned false
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if given year is a leap year
     *
     * @param year input from isValid method
     * @return boolean value True if year is a leap year
     */
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Turns date into a String in the following format mm/dd/yyyy
     *
     * @return date in String form
     */
    @Override
    public String toString() {
        String dateToString = "";
        if (month < 10) { //adds zero in front of month if less than 10
            dateToString += "0" + month + "/";
        } else {
            dateToString += month + "/";
        }
        if (day < 10) {//adds zero in front of day if less than 10
            dateToString += "0" + day + "/";
        } else {
            dateToString += day + "/";
        }
        return dateToString + year;
    }

    /**
     * This method is used as testbed method for the Date class
     */
    public static void main(String[] args) {
        Date test = new Date();
        Date test2 = new Date("02/03/1984");
        System.out.println(test.month);
        System.out.println(test.day);
        System.out.println(test.year);
        System.out.println(test);
        System.out.println(test2);
    }
}
