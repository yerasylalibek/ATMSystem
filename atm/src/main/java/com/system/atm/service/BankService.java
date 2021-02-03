package com.system.atm.service;

import com.system.atm.model.Account;

public interface BankService {
    public void checkBalance(Account account);
    public void withdraw(Account account);
    public void topUp(Account account);
    public void changePinCode(Account account);
}
