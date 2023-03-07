package proxy.cglib;

import net.sf.cglib.proxy.FixedValue;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description: 表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
 * @date 20:05 2023/3/6
 */
public class TargetResultFixed implements FixedValue {
    @Override
    public Object loadObject() {
        System.out.println("you are locked the result!");
        return null;
    }
}
