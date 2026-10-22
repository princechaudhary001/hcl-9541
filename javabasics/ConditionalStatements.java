package javabasics;

/** Module 1: if / else-if / else, switch (classic + modern arrow form). */
public class ConditionalStatements {
    static String grade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "F";
    }

    static String dayType(int day) {
        switch (day) {            // classic switch: break prevents fall-through
            case 1: case 2: case 3: case 4: case 5:
                return "Weekday";
            case 6: case 7:
                return "Weekend";
            default:
                return "Invalid";
        }
    }

    static int daysInMonth(int month) {
        return switch (month) {   // switch expression (Java 14+)
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    public static void main(String[] args) {
        System.out.println("85 -> " + grade(85));
        System.out.println("35 -> " + grade(35));
        System.out.println("day 6 -> " + dayType(6));
        System.out.println("month 4 -> " + daysInMonth(4) + " days");

        // Fall-through demo
        int n = 2;
        switch (n) {
            case 1: System.out.println("one");
            case 2: System.out.println("two");   // runs
            case 3: System.out.println("three"); // also runs (no break)
        }
    }
}
