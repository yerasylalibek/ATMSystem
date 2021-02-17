package com.system.atm.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bank {
    private String id;
    private String bankName;
    private List<Client> clients;

    @Autowired
    public Bank(@Value("${bank.id}") String id, @Value("${bank.name}") String bankName, List<Client> clients) {
        this.id = id;
        this.bankName = bankName;
        this.clients = clients;
    }

    public Bank() {
    }

    public void addAccount(Client client){
        clients.add(client);
    }
    public void deleteAccount(Client client){
        clients.remove(client);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return bankName;
    }

    public void setName(String name) {
        this.bankName = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
