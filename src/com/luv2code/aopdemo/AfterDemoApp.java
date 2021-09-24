package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        
        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            accounts = accountDao.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program ... caught exception : " + exc);
        }
        
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");
        System.out.println(accounts);
        System.out.println("\n");
        
        
        context.close();
    }
}
