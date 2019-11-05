package top.xuxuzhaozhao.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于打印计划，并在切入点方法（就是业务方法）之前执行
 */
public class Logger {
    public void beforePrintLog() {
        System.out.println("Logger中的beforePrintLog开始记录日志了。。。");
    }

    public void afterReturningPrintLog() {
        System.out.println("Logger中的afterReturningPrintLog开始记录日志了。。。");
    }

    public void afterThrowingPrintLog() {
        System.out.println("Logger中的afterThrowingPrintLog开始记录日志了。。。");
    }

    public void afterPrintLog() {
        System.out.println("Logger中的afterPrintLog开始记录日志了。。。");
    }

    /**
     * 环绕通知
     * 配置了环绕通知后，切入点方法没有执行，但是通知方法执行了
     * 解决：ProceedingJointPoint
     * <p>
     * <p>
     * 环绕通知：spring框架可以在代码中手动控制增强方法在何时执行的方法
     */
    public Object aroundPrintLog(ProceedingJoinPoint pdjp) {
        Object returnValue = null;
        try {
            Object[] args = pdjp.getArgs();

            System.out.println("Logger中的aroundPrintLog开始记录日志了。。。前置");
            returnValue = pdjp.proceed(args);//明确调用切入点方法
            System.out.println("Logger中的aroundPrintLog开始记录日志了。。。后置");

            return returnValue;
        } catch (Throwable t) {
            System.out.println("Logger中的aroundPrintLog开始记录日志了。。。异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("Logger中的aroundPrintLog开始记录日志了。。。最终");
        }
    }
}
