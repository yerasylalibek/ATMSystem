package com.system.atm.model;

import com.system.atm.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int id;
    private String bankName;
    private List<User> users = new ArrayList();

    public Bank(int id, String bankName, List<User> users) {
        this.id = id;
        this.bankName = bankName;
        this.users = users;
    }

    public Bank(String id, String bankName) {
    }

    public void addAccount(User user){
        users.add(user);
    }
    public void deleteAccount(User user){
        users.remove(user);
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
