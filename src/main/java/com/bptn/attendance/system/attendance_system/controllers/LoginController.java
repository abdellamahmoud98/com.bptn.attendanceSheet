package com.bptn.attendance.system.attendance_system.controllers;

import com.bptn.attendance.system.attendance_system.models.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button loginButton;

    @FXML
    private PasswordField userPassword;

    @FXML
    private TextField userName;

    @FXML
    void initialize() {


       loginButton.setOnAction(event -> {
           String  password  = userPassword.getText().trim();
           String name = userName.getText().trim();
           System.out.println(password + " " + name);

           Login userLogin = new Login();

           boolean isUserValid = userLogin.validateLogin(name,password);



           if (!isUserValid) {
               userName.setStyle("-fx-text-fill: red;");
               userPassword.setStyle("-fx-text-fill: red;");
               return;
           }


              // Save user information
              userLogin.saveLoginInfo(password,name);
              displayAttendanceScreen(loginButton, "/com/bptn/attendance/system/attendance_system/attendance.fxml","Attendance Sheet");

       });





    }

    private void displayAttendanceScreen(Button button,String path,String fxml) {

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
