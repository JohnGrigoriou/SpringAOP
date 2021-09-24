package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public boolean addSlliyMember() {
        System.out.println(getClass() + ":DOING STUFF: ADDING MEMBERSHIP ACCOUNT");
        return true;
    }
    
    public void goToSleep() {
        System.out.println(getClass() + "I'm going to sleep now...");
    }
}
