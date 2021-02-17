package com.system.atm.model.user;

import org.springframework.stereotype.Component;

@Component
public interface User {
    int getId();
    String getName();
    int getAge();
    String getUsername();
    String getPassword();
    int getBalance();

    void setId(int id);
    void setName(String name);
    void setAge(int age);
    void setUsername(String username);
    void setPassword(String password);
    void setBalance(int balance);
}
