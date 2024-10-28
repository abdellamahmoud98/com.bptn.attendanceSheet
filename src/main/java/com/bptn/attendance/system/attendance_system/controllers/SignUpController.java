package com.bptn.attendance.system.attendance_system.controllers;
import com.bptn.attendance.system.attendance_system.models.SignUp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    @FXML
    private PasswordField confirmNewPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Button signupButton;

    @FXML
    private TextField userNameNew;

    @FXML
    void initialize() {
       signupButton.setOnAction(event -> {
           String password = newPassword.getText().trim();
           String confirmPass = confirmNewPassword.getText().trim();
           String userName = userNameNew.getText().trim();

           if (!password.equals(confirmPass)) {
               confirmNewPassword.setStyle("-fx-text-fill: red;");
               return;
           }

           if (password.length() < 6) {
               confirmNewPassword.setStyle("-fx-text-fill: red;");
               return;
           }



           SignUp signupUser = new SignUp(password,userName);
           signupUser.signUpUser();
           displayLoginScreen(signupButton,"/com/bptn/attendance/system/attendance_system/login.fxml","Login");
       });


    }


    private void displayLoginScreen(Button button,String path,String fxml) {

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
