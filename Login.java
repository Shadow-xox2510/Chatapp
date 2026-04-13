/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author user
 */
public class Login {
    private String username;
    private String password;
    private String cellNumber;

    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() >= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()-_=+[{]}|;:',<.>/?`~";

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (specialChars.indexOf(c) >= 0) hasSpecial = true;
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber.startsWith("+27") && cellNumber.length() == 12) {
            return cellNumber.substring(3).matches("[0-9]{9}");
        } else if (cellNumber.startsWith("0") && cellNumber.length() == 10) {
            return cellNumber.substring(1).matches("[0-9]{9}");
        }
        return false;
    }

    public boolean register(String username, String password, String cellNumber) {
        if (!checkUsername(username)) {
            System.out.println("Invalid username: Must contain an underscore and be at least 5 characters.");
            return false;
        }
        if (!checkPasswordComplexity(password)) {
            System.out.println("Invalid password: Must be at least 8 characters and include a capital letter, a number, and a special character.");
            return false;
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            System.out.println("Invalid cell number: Must start with +27 or 0 and have 9 digits after.");
            return false;
        }

        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;

        System.out.println("Registration successful!");
        return true;
    }

    public boolean login(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }
}
    


