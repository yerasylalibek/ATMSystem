package com.system.atm;

import com.system.atm.model.Account;
import com.system.atm.model.Bank;
import com.system.atm.service.ATM;
import com.system.atm.service.BankService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AtmApplication {

    public static void main(String[] args) { //        SpringApplication.run(AtmApplication.class, args);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Scanner in = new Scanner(System.in);

        //Creating Account
        Account account1 = context.getBean("account", Account.class);
        account1.setId(1);
        account1.setUsername("erasyl");
        account1.setPassword("12345");
        account1.setBalance(200000);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);

        //Creating Bank
        Bank bank = context.getBean("bank", Bank.class);
        bank.setId(1);
        bank.setName("Kaspi");
        bank.setAccounts(accounts);


        //Entering to the system
        System.out.println("Enter username: ");
        String username = in.next();
        System.out.println("Enter password: ");
        String password = in.next();

        for(int i = 0; i < bank.getAccounts().size(); i++){
            if(bank.getAccounts().get(i).getUsername().equalsIgnoreCase(username) &&
                bank.getAccounts().get(i).getPassword().equals(password)){

                System.out.println("Welcome " + username + "!");
                BankService bankService = new ATM();
                int choice = -1;

                while(choice != 0){

                    System.out.println("1. Check Balance");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Top Up");
                    System.out.println("4. Change Pin Code");
                    System.out.println("0. Exit");

                    choice = in.nextInt();

                    switch (choice){
                        case 1:
                            bankService.checkBalance(bank.getAccounts().get(i));
                            break;
                        case 2:
                            bankService.withdraw(bank.getAccounts().get(i));
                            break;
                        case 3:
                            bankService.topUp(bank.getAccounts().get(i));
                            break;
                        case 4:
                            bankService.changePinCode(bank.getAccounts().get(i));
                            break;
                        case 0:
                            System.out.println("Exit");
                            return;
                        default:
                            System.out.println("Incorrect choice! Please try again!");
                            break;
                    }
                }

            }
        }

        context.close();
    }

}
