package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    
    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @Around on method: " + method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace(); //THELEI LOGGER GIA NA TREKSEI... TREXOUN SE DIAFORETIKA STREAMS TO SPRING KAI TO SYSTEM
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("\n======> Duration: " + duration / 1000.0 + " seconds");        
        return result;
    }
    
    @After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @After (finally) on method: " + method);

    }
    
    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))", 
                   throwing = "myExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable myExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @AfterThrowing on method: " + method);
        
        System.out.println("\n=========>>> The exception is: " + myExc);
             
    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))", 
                    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @AfterReturning on method: " + method);
        
        System.out.println("\n=========>>> result is: " + result);
        
        convertAccountNamesToUpperCase(result);
        
        System.out.println("\n=========>>> result is: " + result);
  
    }
    
    private void convertAccountNamesToUpperCase(List<Account> result) {
        
        for (Account account : result) {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
        
    }
    
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
        
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSig);
        
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }
    
}
