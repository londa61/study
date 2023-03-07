package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 18:42 2023/3/6
 */
public class PeopleProxyHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private Object obj;

    public PeopleProxyHandler() {
    }

    /**
     * 构造函数，给我们的真实对象赋值
     * @param obj obj
     */
    public PeopleProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("PeopleProxyHandler before");
        Object invoke = method.invoke(obj, args);
        System.out.println("PeopleProxyHandler after");
        return invoke;
    }
}
