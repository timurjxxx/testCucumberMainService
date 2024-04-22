package com.gypApp_main.aspect;

import com.gypApp_main.utils.TransactionIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TransactionLoggingAspect {


    @AfterReturning(pointcut = "execution(* com.gypApp_main.service.*.*(..))", returning = "result")
    public void logTransaction(JoinPoint joinPoint, Object result) {
        String transactionId = TransactionIdGenerator.generateTransactionId();
        log.info("Transaction ID: {}", transactionId);
        log.debug("Detailed information about the transaction can be added here.");
    }
}
