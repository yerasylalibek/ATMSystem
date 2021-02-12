package com.system.atm.service;

import com.system.atm.model.user.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ATM implements BankService{
    private final String url = "jdbc:postgresql://localhost/atm";
    private final String username = "postgres";
    private final String password = "postgres";

    Scanner in = new Scanner(System.in);
    void init(){
        System.out.println("Connect has been done successfully!");
        ATM atm = new ATM();
        atm.connect();
    }

    @Override
    public void checkBalance(User user) {
        System.out.println("Your balance: " + user.getBalance());
    }

    @Override
    public void withdraw(User user) {
        System.out.println("How many balance you want to withdraw ? ");
        int money = in.nextInt();
        user.setBalance(user.getBalance() - money);
        System.out.println("Done!");
        System.out.println("You have " + user.getBalance());

    }

    @Override
    public void topUp(User user) {
        System.out.println("How many balance you want to top up ? ");
        int money = in.nextInt();
        user.setBalance(user.getBalance() + money);
        System.out.println("Done!");
        System.out.println("you have " + user.getBalance());
    }

    @Override
    public void changePinCode(User user) {
        System.out.println("Enter old password: ");
        String oldPassword = in.next();
        System.out.println("Enter new Password: ");
        String newPassword = in.next();
        System.out.println("Confirm Password: ");
        String confirm = in.next();

        if(user.getPassword().equals(oldPassword)){
            if(newPassword.equals(confirm)){
                user.setPassword(newPassword);
                System.out.println("Password has been changed!");
            }else{
                System.out.println("Incorrect confirming! ");
            }
        }else{
            System.out.println("Incorrect old password! ");
        }
    }


    void destroy(){
        System.out.println("Connect has been rejected successfully!");
    }

    public Connection connect() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connection to the PostgreSQL has been finished successfully!");
            } else {
                System.out.println("Error!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
