package com.prs.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeCRUDAspect {

    @Before("execution(* com.prs.aop.springaop.service.EmployeeManager.get*(..))")
    public void logBeforeV1(JoinPoint joinPoint)
    {
        System.out.println("Before : " + joinPoint.getSignature().getName());
    }

   /* @Before("execution(* com.prs.aop.springaop.service.EmployeeManager.create*(..))")
    public void logBeforeV2(JoinPoint joinPoint)
    {
        System.out.println("Before create " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.prs.aop.springaop.service.EmployeeManager.get*(..))")
    public void logAfterV1(JoinPoint joinPoint)
    {
        System.out.println("After : " + joinPoint.getSignature().getName());
    }*/

    @After("execution(* com.prs.aop.springaop.service.EmployeeManager.create*(..))")
    public void logAfterV2(JoinPoint joinPoint)
    {
        System.out.println("After create) : " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.prs.aop.springaop.service.EmployeeManager.delete*(..))")
    public void logDelete(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start delete : "+proceedingJoinPoint.getSignature().getName());
        proceedingJoinPoint.proceed();
        System.out.println("end delete : "+proceedingJoinPoint.getSignature().getName());
    }

    @Around("execution(* com.prs.aop.springaop.service.EmployeeManager.update*(..))")
    public void logUpdate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start update : "+proceedingJoinPoint.getSignature().getName());
        proceedingJoinPoint.proceed();
        System.out.println("end update : "+proceedingJoinPoint.getSignature().getName());
    }

    @Around("@annotation(LogExecutionTime)")
    public void logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis()-start;
        System.out.println(proceedingJoinPoint.getSignature().getName()+" executed in "+executionTime/60+" seconds");

    }
}
