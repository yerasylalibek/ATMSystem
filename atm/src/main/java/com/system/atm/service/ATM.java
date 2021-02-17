package com.system.atm.service;

import com.system.atm.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

@Service
@Component
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
    public void checkBalance(Client client) {
        System.out.println("Your balance: " + client.getBalance());
    }

    @Override
    public void withdraw(Client client) {
        System.out.println("How many balance you want to withdraw ? ");
        int money = in.nextInt();
        client.setBalance(client.getBalance() - money);
        System.out.println("Done!");
        System.out.println("You have " + client.getBalance());

    }

    @Override
    public void topUp(Client client) {
        System.out.println("How many balance you want to top up ? ");
        int money = in.nextInt();
        client.setBalance(client.getBalance() + money);
        System.out.println("Done!");
        System.out.println("you have " + client.getBalance());
    }

    @Override
    public void changePinCode(Client client) {
        System.out.println("Enter old password: ");
        String oldPassword = in.next();
        System.out.println("Enter new Password: ");
        String newPassword = in.next();
        System.out.println("Confirm Password: ");
        String confirm = in.next();

        if(client.getPassword().equals(oldPassword)){
            if(newPassword.equals(confirm)){
                client.setPassword(newPassword);
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
