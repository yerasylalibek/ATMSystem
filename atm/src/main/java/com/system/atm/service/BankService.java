package com.system.atm.service;

import com.system.atm.model.user.User;

public interface BankService {
    public void checkBalance(User user);
    public void withdraw(User user);
    public void topUp(User user);
    public void changePinCode(User user);
}
