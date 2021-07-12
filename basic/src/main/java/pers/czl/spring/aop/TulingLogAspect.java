package pers.czl.spring.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pers.czl.spring.aop.Introductions.ProgramCalculate;
import pers.czl.spring.aop.Introductions.SimpleProgramCalculate;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Created by xsls on 2019/6/10.
 */
@Aspect
@Order
@Slf4j
@Component
public class TulingLogAspect {
    private final static String LOG_FORMAT = "\n请求目标:\t[{}]\n请求参数:\t{}\n响应时间:\t[{}:ms]";

    /* 满足表达式的类会在运行时自动实现ProgramCalculate接口 */
    @DeclareParents(value="pers.czl.spring.aop.TulingCalculate",   // 动态实现的类
            defaultImpl = SimpleProgramCalculate.class)  // 引入的接口的默认实现
    public static ProgramCalculate programCalculate;    // 引入的接口

    @Pointcut("execution(* pers.czl.spring.aop.TulingCalculate.*(..))")
    public void pointCut(){};

    @Pointcut("execution(* pers.czl.spring.aop.Dog.*(..))")
    public void pointCut2(){};

/*    @Pointcut("execution(* com.qjdchina.web..*.*(..)) && !execution(* com.qjdchina.web.configuration..*.*(..))")
    public void pointCut3(){};*/

    @Before(value = "pointCut() || pointCut2()")
    public void methodBefore(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<前置通知>,入参"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<后置通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<返回通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<异常通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @SneakyThrows
    @Around("pointCut2()")
    public Object doAround(ProceedingJoinPoint point) {
        Long startTime = System.currentTimeMillis();
        try {
            return point.proceed();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            log.info(LOG_FORMAT, point.getSignature(), point.getArgs(), (endTime - startTime));
        }
    }

}
