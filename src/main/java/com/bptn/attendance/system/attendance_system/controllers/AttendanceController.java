package com.bptn.attendance.system.attendance_system.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class AttendaceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> attName;
    Observablelist<String> listview = FXCollections.observableArrayList(
            "Sarah Mahmoud",
            "David Mahmoud",
            "Laura Mahmoud",
            "Lee Lee",
            "Amani Rodriguez",
            "Towfiq Walker",
            "Jennifer Mahmoud",
            "William Mahmoud",
            "Jessica Lee",
            "Charles King",
            "King Charles",
            "Thomas Mahmoud",
            "Mary Mahmoud",
            "Abdella Mahmoud",
            "Emmanuel Gam"
    );





    @FXML
    private ListView<?> attStatus;
    Observablelist<String> listvie = FXCollections.observableArrayList(
    "Present",
    "Absent"
    );
    @FXML
    private ListView<?> attSubject;

    @FXML
    private Button submitAttendaceButton;

    @FXML
    void initialize() {
    attName.setItems(listview);
    }

}

