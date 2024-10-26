package com.bptn.attendance.system.attendance_system.models;

import java.io.*;

public class SignUp {
    String userName;
    String password;


    public SignUp(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void signUpUser() {

        System.out.println("Sign Up User" + this.userName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"))) {
            writer.write(this.userName + "\n" + this.password);
        } catch (IOException e) {
            System.out.println("An error occurred, please try again: " + e.getMessage());
        }
    }
}
