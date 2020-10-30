package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class ExceptionAspect {
    private final Logger logger = Logger.getLogger(getClass().getName());


    @AfterThrowing(pointcut = "execution(* service.BookService.*(..))", throwing = "e")
    public void handleException(JoinPoint joinPoint, Throwable e) {
       String methodName = joinPoint.getSignature().getName();
       Object [] arguments = joinPoint.getArgs();
       logger.info("After executing " + methodName + " with params: " + Arrays.asList(arguments) + " error was " + e.getMessage());
    }

}
