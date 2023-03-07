package proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 18:44 2023/3/6
 */
public class JdkProxyClient {
    public static void main(String[] args) {
        People worker = new Worker();
        PeopleProxyHandler workerProxyHandler = new PeopleProxyHandler(worker);
        People workInstance = (People) Proxy.newProxyInstance(workerProxyHandler.getClass().getClassLoader()
                , worker.getClass().getInterfaces()
                , workerProxyHandler);
        System.out.println("——————————————————————————————————————————");
        workInstance.speak("hello");
        System.out.println("——————————————————————————————————————————");
        String workResult = workInstance.work("code");
        System.out.println("——————————————————————————————————————————\n");
        System.out.println(workResult);

        People child = new Child();
        PeopleProxyHandler childProxyHandler = new PeopleProxyHandler(child);
        People childInstance = (People) Proxy.newProxyInstance(childProxyHandler.getClass().getClassLoader()
                , worker.getClass().getInterfaces()
                , childProxyHandler);
        System.out.println("——————————————————————————————————————————");
        childInstance.speak("aba");
        System.out.println("——————————————————————————————————————————");
        String childResult = childInstance.work("code");
        System.out.println("——————————————————————————————————————————");
        System.out.println(childResult);
    }
}
