package mybatis.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 18:44 2023/3/6
 */
public class Client {
    public static void main(String[] args) {
        People worker = new Worker();
        People child = new Child();
        PeopleProxyHandler workerProxyHandler = new PeopleProxyHandler(worker);
        People workInstance = (People) Proxy.newProxyInstance(workerProxyHandler.getClass().getClassLoader()
                , worker.getClass().getInterfaces()
                , workerProxyHandler);
        workInstance.speak("hello");
        System.out.println("——————————————————————————————————————————\n");
        PeopleProxyHandler childProxyHandler = new PeopleProxyHandler(child);
        People childInstance = (People) Proxy.newProxyInstance(childProxyHandler.getClass().getClassLoader()
                , worker.getClass().getInterfaces()
                , childProxyHandler);
        childInstance.speak("aba");
    }
}
