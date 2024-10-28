package com.bptn.attendance.system.attendance_system.models;
import com.bptn.attendance.system.attendance_system.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCrud {
    private static final String SELECT_ALL_STUDENTS = "SELECT id, \"firstName\", \"lastName\", sex, email, phone, \"isPresent\" FROM public.student;";


    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = PostgreSql.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setFirstname(rs.getString("firstName"));
                student.setLastname(rs.getString("lastName"));
                student.setSex(rs.getString("sex"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setPresent(rs.getBoolean("isPresent"));
                student.setStudentId(rs.getInt("id"));

                students.add(student);
            }

        } catch (SQLException e) {
            System.err.println("SQL error occurred during select:");
            e.printStackTrace();
        }

        return students;
    }


    public boolean updateIspresent(boolean present, int studentId) {
        String UPDATE_STUDENT_ISPRESENT = "UPDATE student SET \"isPresent\" = ?  WHERE id = ?;";

        boolean isUpdated = false;

        try (Connection connection = PostgreSql.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_ISPRESENT)) {

            preparedStatement.setBoolean(1, present);
            preparedStatement.setInt(2, studentId);

            int rowsAffected = preparedStatement.executeUpdate();

            isUpdated = rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("SQL error occurred during update:");

        }
        return isUpdated;
    }
}





