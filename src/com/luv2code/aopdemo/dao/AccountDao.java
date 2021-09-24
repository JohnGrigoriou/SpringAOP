package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    private String name;
    private String serviceCode;
    
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }
        
        List<Account> myAccounts = new ArrayList<>();
        Account a1 = new Account("John", "Silver");
        Account a2 = new Account("Madhu", "Platinum");
        Account a3 = new Account("luca", "Gold");
        
        myAccounts.add(a1);
        myAccounts.add(a2);
        myAccounts.add(a3);
        
        return myAccounts;
    } 
    
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT");
    }
    
    public boolean doWork() {
        System.out.println(getClass() + ":doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ":in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ":in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ":in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ":in setServiceCode()");
        this.serviceCode = serviceCode;
    }
    
    
}
