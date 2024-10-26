package com.bptn.attendance.system.attendance_system.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {


    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {

        if (signInButton != null) {
            DisplayScreen(signInButton,"/com/bptn/attendance/system/attendance_system/login.fxml","Login");
        }

        if (signUpButton != null) {
            DisplayScreen(signUpButton,"/com/bptn/attendance/system/attendance_system/signup.fxml","Signup");
        }
    }

    public static void  DisplayScreen (Button button, String url, String pageTitle)
    {
        button.setOnAction(event -> {
            button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HomeController.class.getResource(url));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle(pageTitle);
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
