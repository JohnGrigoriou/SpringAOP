package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundHandleExceptionDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        
        TrafficFortuneService traffic = context.getBean("trafficFortuneService", TrafficFortuneService.class);
 
        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        boolean tripWire = true;
        String data = traffic.getFortune(tripWire);
        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");
        
        
        
        context.close();
    }
}
