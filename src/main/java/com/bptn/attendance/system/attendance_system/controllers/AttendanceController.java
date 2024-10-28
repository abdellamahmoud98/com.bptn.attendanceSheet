package com.bptn.attendance.system.attendance_system.controllers;

import java.io.IOException;

import java.sql.SQLException;


import com.bptn.attendance.system.attendance_system.models.StudentCrud;
import com.bptn.attendance.system.attendance_system.models.Attendance;
import com.bptn.attendance.system.attendance_system.models.AttendanceSheet;
import com.bptn.attendance.system.attendance_system.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class AttendanceController {

    @FXML
    private ListView<Student> listView;

    private ObservableList<Student> studentsList;

    private StudentCrud studentCrud = new StudentCrud();

    @FXML
    private Button submitAttendance;

    @FXML
    private Button logout;

    @FXML
    void initialize() throws SQLException {
        var students = studentCrud.getAllStudents();
        studentsList = FXCollections.observableArrayList(students);
        listView.setItems(studentsList);
        listView.setCellFactory(CellController -> new CellController());

        submitAttendance.setOnAction(event -> {
            var studentA = studentCrud.getAllStudents();
            Attendance attendance = new AttendanceSheet(studentA);
            attendance.GenerateReport();

            try {
                initialize();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });





        logout.setOnAction(event -> {
            displayHomeScreen(logout,"/com/bptn/attendance/system/attendance_system/home-view.fxml","Attendance Sheet");
        });

    }


    private void displayHomeScreen(Button button,String path,String fxml) {

        button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HomeController.class.getResource(path));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle(fxml);
        stage.setScene(new Scene(root));
        stage.show();
    }

}