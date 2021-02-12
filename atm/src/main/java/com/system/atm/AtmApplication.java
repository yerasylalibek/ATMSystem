package com.system.atm;

import com.system.atm.model.user.User;
import com.system.atm.model.Bank;
import com.system.atm.model.user.UserFactory;
import com.system.atm.model.user.UserType;
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

        UserFactory uf = context.getBean("userFactory", UserFactory.class);



        User user1 = uf.createUser(UserType.Single, 1, "Erasyl", 19,
                "eraskaz", "12345", 200000);

        List<User> users = new ArrayList<>();
        users.add(user1);

        //Creating Bank
        Bank bank = context.getBean("bank", Bank.class);
        bank.setId(1);
        bank.setName("Kaspi");
        bank.setUsers(users);


        //Entering to the system
        System.out.println("Enter username: ");
        String username = in.next();
        System.out.println("Enter password: ");
        String password = in.next();

        for(int i = 0; i < bank.getUsers().size(); i++){
            if(bank.getUsers().get(i).getUsername().equalsIgnoreCase(username) &&
                bank.getUsers().get(i).getPassword().equals(password)){

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
                            bankService.checkBalance(bank.getUsers().get(i));
                            break;
                        case 2:
                            bankService.withdraw(bank.getUsers().get(i));
                            break;
                        case 3:
                            bankService.topUp(bank.getUsers().get(i));
                            break;
                        case 4:
                            bankService.changePinCode(bank.getUsers().get(i));
                            break;
                        default:
                            break;
                    }
                }

            }
        }
        context.close();
    }

}
