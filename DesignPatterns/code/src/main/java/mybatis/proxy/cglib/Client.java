package mybatis.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 19:23 2023/3/6
 */
public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(People.class);
        enhancer.setCallback(new PeopleProxyInterceptor1());
        People people = (People) enhancer.create();
        people.speak("hello");
        people.work("world");
        System.out.println("————————————————————————————————\n");

        Enhancer enhancer1 = new Enhancer();
        enhancer1.setSuperclass(People.class);
        PeopleCallbackFilter peopleCallbackFilter = new PeopleCallbackFilter();
        enhancer1.setCallbackFilter(peopleCallbackFilter);
        Callback callback1 = new PeopleProxyInterceptor1();
        Callback callback2 = new PeopleProxyInterceptor2();
        Callback resultFixed = new TargetResultFixed();
        // (1)callback1、callback1：方法拦截器
        // (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
        // (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
        Callback[] callbacks = new Callback[]{callback1, callback2, NoOp.INSTANCE, resultFixed};
        enhancer1.setCallbacks(callbacks);

        People targetObject = (People) enhancer1.create();
        System.out.println("————————————————————————————————\n");
        targetObject.speak("hello");
        System.out.println("————————————————————————————————\n");
        targetObject.work("code");
        System.out.println("————————————————————————————————\n");
        targetObject.eat("tomato");
        System.out.println("————————————————————————————————\n");
        targetObject.fly("dream");

        System.out.println("————————————————————————————————\n");
        People lazyPeople = new People(35);
        System.out.println(lazyPeople.getAge());
        //访问LazyLoader延迟加载对象
        Name name = lazyPeople.getName();
        System.out.println(name.getFirstName());
        System.out.println(name.getLastName());
        System.out.println("after...");
        //当再次访问延迟加载对象时,就不会再执行回调了
        System.out.println(name.getFirstName());

        System.out.println("————————————————————————————————\n");
        People alwaysLazyPeople = new People(35);
        System.out.println(lazyPeople.getAge() + "\n");
        //访问Dispatcher延迟加载对象
        Address address = alwaysLazyPeople.getAddress();
        System.out.println(address.getCounty() + "\n");
        System.out.println(address.getCity() + "\n");
        System.out.println("after...");
        //当再次访问延迟加载对象时,依然执行回调
        System.out.println(address.getCounty() + "\n");
    }

}
