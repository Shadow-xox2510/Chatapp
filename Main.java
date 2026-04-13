/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author user
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        System.out.println("=== Registration ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell number: ");
        String cellNumber = scanner.nextLine();

        boolean registered = loginSystem.register(username, password, cellNumber);
        if (!registered) {
            System.out.println("Registration failed.");
            return;
        }

        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        if (loginSystem.login(loginUsername, loginPassword)) {
            System.out.println("Login successful");
            System.out.println("Welcome " + loginUsername);
        } else {
            System.out.println("Login failed.");
        }

        scanner.close();
    }
}
