package com.bptn.attendance.system.attendance_system.models;


import java.util.List;

public class AttendanceSheet implements Attendance{
    private List<Student> students;
    private long numberOfStudentsPresent = 0;
    private long numberOfStudentsAbsent = 0;
    private List<Student> studentsAbsent = null;
    private List<Student> studentsPresent = null;

    public AttendanceSheet(List<Student> students){
        this.students = students;

    }

    @Override
    public String toString() {
        return "AttendanceSheet{" +
                "students=" + students +
                '}';
    }

    @Override
    public void GenerateReport() {
        StringBuilder report = new StringBuilder();
        numberOfStudentsPresent = students.stream().filter(student -> student.isPresent()).count();
        numberOfStudentsAbsent = students.stream().filter(student -> !student.isPresent()).count();

        studentsPresent = students.stream().filter(student -> student.isPresent()).toList();
        studentsAbsent  = students.stream().filter(student -> student.isPresent()).toList();

        String r = String.format("Today we have %d students present and %d number of students absent ", numberOfStudentsPresent,numberOfStudentsAbsent);
        FileHandler.saveReportToFile(r);


//        FileHandler.saveReportToFile("AttendanceSheet{" +
//                "students=" + studentsPresent +
//                '}');
//        FileHandler.saveReportToFile("AttendanceSheet{" +
//                "students=" + students +
//                '}');
    }
}
