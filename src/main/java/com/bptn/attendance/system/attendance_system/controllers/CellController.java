
package com.bptn.attendance.system.attendance_system.controllers;

import com.bptn.attendance.system.attendance_system.models.StudentCrud;
import com.bptn.attendance.system.attendance_system.models.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CellController extends ListCell<Student> {

    @FXML
    private RadioButton isPresent;

    @FXML
    private Label studentName;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private Label studentID;

    private FXMLLoader fxmlLoader;

    private List<Student> studentsPresent = new ArrayList<>();

    @FXML
    void initialize() {
    }

    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {
            setText(null);
            setGraphic(null);
        }else {
            if (fxmlLoader == null){
                fxmlLoader = new FXMLLoader(getClass().getResource("/com/bptn/attendance/system/attendance_system/cell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            studentName.setText(student.getFirstname() + " " + student.getLastname());
            studentID.setText(String.valueOf(student.getStudentId()));

            if (!student.isPresent()){
                isPresent.setSelected(false);
            }else
                isPresent.setSelected(true);


            isPresent.setOnAction(event -> {
                StudentCrud studentCrud = new StudentCrud();
                if (isPresent.isSelected()) {
                    System.out.println(student.getStudentId());
                    var _ = studentCrud.updateIspresent(true,student.getStudentId());
                }else if (!isPresent.isSelected()){
                    var _ = studentCrud.updateIspresent(false,student.getStudentId());
                }


            });

        }
        setText(null);
        setGraphic(rootAnchorPane);
    }

}


