package com.system.atm.service;

import com.system.atm.model.Account;

import java.util.Scanner;

public class ATM implements BankService{
    Scanner in = new Scanner(System.in);

    @Override
    public void checkBalance(Account account) {
        System.out.println("Your balance: " + account.getBalance());
    }

    @Override
    public void withdraw(Account account) {
        System.out.println("How many balance you want to withdraw ? ");
        int money = in.nextInt();
        account.setBalance(account.getBalance() - money);
        System.out.println("Done!");
        System.out.println("You have " + account.getBalance());

    }

    @Override
    public void topUp(Account account) {
        System.out.println("How many balance you want to top up ? ");
        int money = in.nextInt();
        account.setBalance(account.getBalance() + money);
        System.out.println("Done!");
        System.out.println("you have " + account.getBalance());
    }

    @Override
    public void changePinCode(Account account) {
        System.out.println("Enter old password: ");
        String oldPassword = in.next();
        System.out.println("Enter new Password: ");
        String newPassword = in.next();
        System.out.println("Confirm Password: ");
        String confirm = in.next();

        if(account.getPassword().equals(oldPassword)){
            if(newPassword.equals(confirm)){
                account.setPassword(newPassword);
                System.out.println("Password has been changed!");
            }else{
                System.out.println("Incorrect confirming! ");
            }
        }else{
            System.out.println("Incorrect old password! ");
        }

    }
}
