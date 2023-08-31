package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Aspect
public class LoggingAspect {

    @Before("allMethods()") // one Advisor to many point(Use Wildcards)

    public void LoggingAdvice(JoinPoint joinPoint) {
//        System.out.println("Advice run.get method called");
        System.out.println(joinPoint.toString());
    }

    @Around("dummyAllMethodGetter()")
    public Object aroundAllGetters(ProceedingJoinPoint proceedingJoinPoint)
    {
        Object methodValue= null;
        try {
            System.out.println("Before the proceed  the target method is Called");
            methodValue=proceedingJoinPoint.proceed();
            System.out.println("After the target(all getters in this case) is executed");
        }
        catch (Throwable e)
        {
            System.out.println("This will be printed only if an exception is encountered");
        }
        System.out.println("This is Finally prineted after a try or catch block");
        System.out.println("The return value is"+ methodValue);
        return methodValue;

    }

    @Before("methodThatTakesCircleAsAParameter()")
    public void secondAdvice() {
        System.out.println("Second Advise");
    }

    @Before("allsetter()")
    public void setterAdvice() {
        System.out.println("Setters encountered");
    }

    @Before("args(name)")
    public void stringsAdvice(String name) {
        System.out.println("Methods containing string as argument is printed " + name);
    }

    @After("args(name)")
    public void afterStringAdvice(String name) {
        System.out.println("This is Called after the method that takes arguments.This will be executed if the " +
                "the method runs successfully or it throws an error");
    }

//    @AfterReturning("args(name)")
//    public void afterMethodReturns(String name) {
//        System.out.println("This is called only if the method is sucessufully returned ");
//    }

    @AfterReturning(pointcut = "args(name)", returning = "stringObject")
    public void ifMethodHasaReturnType(String name, String stringObject) {
        System.out.println("The return Object is" + stringObject);
    }


    @AfterThrowing("args(name)")
    public void runIfExceptionShown(String name) {
        System.out.println("This is executed only when an expection is thrown");
    }


    //    many Advisors having same point cut(use pointcut)
    @Pointcut("execution(public * model.Circle.get*(..))")
    public void dummyAllMethodGetter() {
    }

//    @Pointcut("exceution(* * *())")
//    public void allMethods(){}

    @Pointcut("within(model.Circle)")
    public void allMethods() {
    }

    @Pointcut("args(model.Circle)")
    public void methodThatTakesCircleAsAParameter() {
    }

    //    method that take Circle as a parameter
//
    @Pointcut("execution(* set*(..))")
    public void allsetter() {
    }


}
