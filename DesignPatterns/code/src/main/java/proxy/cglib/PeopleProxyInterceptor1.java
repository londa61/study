package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 19:19 2023/3/6
 */
public class PeopleProxyInterceptor1 implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("PeopleProxyInterceptor1 before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("PeopleProxyInterceptor1 after");
        return result;
    }
}
