package mio68.lab.tryit.dynproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * Прокси который просто логирует имена вызываемых методов.
 *
 */
@Slf4j
public class LoggerProxy implements InvocationHandler {

    public static Object newInstance(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LoggerProxy(target));
    }

    private final Object target;

    private LoggerProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke method [" + method.getName() + "]");
        Object result;
        try {
            log.info("target object class is " + target.getClass().getName());
            result = method.invoke(target, args);
            log.info("invoke method [" + method.getName() + "] success");
        } catch (InvocationTargetException e) {
            log.info("invoke method [" + method.getName() + "] failed. Exception " + e.getCause().getClass().getName());
            throw e.getCause();
        } catch (Exception e) {
            log.info("invoke method [" + method.getName() + "] failed. Exception " + e.getClass().getName());
            throw e;
        }
        return result;
    }
}
