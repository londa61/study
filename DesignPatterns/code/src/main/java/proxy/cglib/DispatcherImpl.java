package proxy.cglib;

import net.sf.cglib.proxy.Dispatcher;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 11:10 2023/3/7
 */
public class DispatcherImpl implements Dispatcher {
    @Override
    public Object loadObject() {
        System.out.println("before Dispatcher...");
        Address address = new Address();
        address.setCounty("China");
        address.setCity("Chengdu");
        System.out.println("after Dispatcher...");
        return address;
    }
}
