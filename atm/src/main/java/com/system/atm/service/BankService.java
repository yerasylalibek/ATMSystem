package com.system.atm.service;

import com.system.atm.model.Client;
import org.springframework.stereotype.Component;

@Component
public interface BankService {
    public void checkBalance(Client client);
    public void withdraw(Client client);
    public void topUp(Client client);
    public void changePinCode(Client client);
}
