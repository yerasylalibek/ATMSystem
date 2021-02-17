package com.system.atm.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("userFactory")
public class UserFactory {

    @Autowired
    public static User createUser(@Value("{$user.type}") UserType userType,
                                  @Value("{$user.id}") int id,
                                  @Value("{$user.name}") String name,
                                  @Value("{$user.age}") int age,
                                  @Value("{$user.username}") String username,
                                  @Value("{$user.password}") String password,
                                  @Value("{$user.balance}") int balance){

        User u = null;

        switch (userType){
            case Single:
                u = new Single(id, name, age, username, password, balance);
                break;
            case Retiree:
                u = new Retiree(id, name, age, username, password, balance);
                break;
            case Children:
                u = new Children(id, name, age, username, password, balance);
                break;
        }
        return u;
    }

}
