package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
        
        Account account = new Account();
        accountDao.addAccount(account, true);
        accountDao.doWork();
        
        accountDao.setName("foobar");
        accountDao.setServiceCode("silver");
        
        String name = accountDao.getName();
        String code = accountDao.getServiceCode();
        
        
        membershipDao.addSlliyMember();
        membershipDao.goToSleep();
        
        
        
        context.close();
    }
}
