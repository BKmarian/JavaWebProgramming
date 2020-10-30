package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AroundAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* service.BookService.*(..))")
    public Object afterReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        logger.info("Before executing " + methodName + " with params: " + arguments[0].toString());
        String result = joinPoint.proceed(arguments).toString();
        logger.info("After executing " + methodName + " for book with name " + arguments[0].toString() + " the status was " + result);
        return result;
    }
}
