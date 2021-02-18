package com.system.atm;

import com.system.atm.model.Bank;
import com.system.atm.model.Client;
import com.system.atm.service.ATM;
import com.system.atm.service.BankService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AtmApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Scanner in = new Scanner(System.in);
        //context.refresh();

        Client client = context.getBean("client", Client.class);

        List<Client> clients = new ArrayList<>();
        clients.add(client);

        Bank bank = context.getBean("bank", Bank.class);
        bank.setClients(clients);
        System.out.println(bank.getBankName());


        //Entering to the system
        System.out.println("Enter username: ");
        String username = in.next();
        System.out.println("Enter password: ");
        String password = in.next();

        for(int i = 0; i < bank.getClients().size(); i++){
            if(bank.getClients().get(i).getUsername().equalsIgnoreCase(username) &&
                bank.getClients().get(i).getPassword().equals(password)){

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
                            bankService.checkBalance(bank.getClients().get(i));
                            break;
                        case 2:
                            bankService.withdraw(bank.getClients().get(i));
                            break;
                        case 3:
                            bankService.topUp(bank.getClients().get(i));
                            break;
                        case 4:
                            bankService.changePinCode(bank.getClients().get(i));
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
