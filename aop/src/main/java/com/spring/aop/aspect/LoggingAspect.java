package com.spring.aop.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // methods of Aspect class become advice.

    @Before("execution(public * com.spring.aop..get*(..))")
    public void loggingAdvice(){
        System.out.println("Logger running");
    }

    @Before("allGetters() && allCircleMethods()")
    public void secondAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget());
    }

    @Around("@annotation(com.spring.aop.aspect.Loggable)")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnValue = null;
        try {
            System.out.println("Before advice");
            returnValue=proceedingJoinPoint.proceed();
            System.out.println("after returning");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("After finally");
        return returnValue;
    }

    @AfterThrowing(pointcut = "allGetters()", throwing="ex")
    public void doRecoveryActions(Exception ex) {
        Thread.setDefaultUncaughtExceptionHandler((t, e1) ->
                System.out.println("Caught " + e1.getMessage()));
        }

//    @Before("args(String)")
//    public void setName(String name){
//        System.out.println("name is "+name);
//    }

    @Pointcut("execution(public * com.spring.aop..get*(..))")
    public void allGetters(){}

    @Pointcut("within(com.spring.aop.models.Circle)")
    public void allCircleMethods(){}
}
