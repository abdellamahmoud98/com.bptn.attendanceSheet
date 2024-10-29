package com.bptn.attendance.system.attendance_system.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

class FileHandler {

    public static void saveReportToFile(String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("attendance_report_" + LocalDate.now() + ".txt"))) {
            writer.write(report);
            System.out.println("Attendance report generated and saved!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the report: " + e.getMessage());
        }
    }
}
