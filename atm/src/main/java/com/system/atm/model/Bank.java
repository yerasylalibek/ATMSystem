package com.system.atm.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int id;
    private String bankName;
    private List<Account> accounts = new ArrayList();

    public Bank(int id, String bankName, List<Account> accounts) {
        this.id = id;
        this.bankName = bankName;
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }
    public void deleteAccount(Account account){
        accounts.remove(account);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return bankName;
    }

    public void setName(String name) {
        this.bankName = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
