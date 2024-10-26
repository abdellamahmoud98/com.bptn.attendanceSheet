package com.bptn.attendance.system.attendance_system.models;

import java.time.LocalDate;
import java.util.Scanner;

class AttendanceSheet {
    private final boolean[] attendance;
    private final String[] studentNames;
    private final String subject;

    public AttendanceSheet() {
        attendance = new boolean[20];
        studentNames = new String[]{
                "Sarah Mahmoud", "David Mahmoud", "Laura Mahmoud", "Lee Lee", "Amani Rodriguez",
                "Towfiq Walker", "Jennifer Mahmoud", "William Mahmoud", "Jessica Lee",
                "Charles King", "King Charles", "Thomas Mahmoud", "Mary Mahmoud",
                "Abdella Mahmoud", "Emmanuel Gam"
        };
        subject = "Java-06-BPTN";
    }

    //----------------------------------------------------------------------------
    // Method to take attendance
    public void takeAttendance() {

        System.out.println("Attendance Sheet for " + subject + " on " + LocalDate.now());
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < studentNames.length; i++) {
            System.out.print("Is " + studentNames[i] + " present (yes/no/late)? ");
            String response = scanner.nextLine().toLowerCase();


            //--------------------------------
            switch (response) {
                case "yes":
                case "late":
                    attendance[i] = true;
                    break;
                case "no":
                    attendance[i] = false;
                    break;
                default:
                    System.out.println("Invalid input! Enter only 'yes', 'no', or 'late'.");
                    i--; // Repeat if invalid input
            }
        }
    }

    // Method to generate attendance report
    public String generateReport() {
        int presentCount = 0;
        StringBuilder report = new StringBuilder("Attendance Report:\n");

        for (int i = 0; i < studentNames.length; i++) {
            report.append(studentNames[i])
                    .append(": ")
                    .append(attendance[i] ? "Present" : "Absent")
                    .append("\n");
            if (attendance[i]) {
                presentCount++;
            }
        }

        report.append("\nTotal Present: ").append(presentCount);
        report.append("\nTotal Absent: ").append(studentNames.length - presentCount);
        return report.toString();
    }
}



