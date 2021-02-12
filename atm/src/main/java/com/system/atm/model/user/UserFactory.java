package com.system.atm.model.user;

public class UserFactory {

    public UserFactory(int id, String name, String age, String username, String password, String balance) {
    }

    public static User createUser(UserType userType, int id, String name, int age,
                                  String username, String password, int balance){

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
