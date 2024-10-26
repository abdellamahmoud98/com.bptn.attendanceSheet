package com.bptn.attendance.system.attendance_system.models;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    private String username;
    private String password;

    // Save login information to a file
    public void saveLoginInfo(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("save-database.txt"))) {
            writer.write(username + "\n" + password);
        } catch (IOException e) {
            System.out.println("An error occurred, please try again: " + e.getMessage());
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean validateLogin(String userName, String password) {
        boolean isUserValid =false;
        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
            String storedUsername = reader.readLine();
            String storedPassword = reader.readLine();

            System.out.println(storedUsername + "db");
            System.out.println(storedPassword + "db");

            if (storedUsername.equals(userName) && storedPassword.equals(password)) {
                isUserValid = true;
            }else
                isUserValid = false;

        } catch (IOException e) {
            System.out.println("An error occurred while reading login information: " + e.getMessage());
        }
       return isUserValid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
