package proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 19:32 2023/3/6
 */
public class PeopleCallbackFilter implements CallbackFilter {
    /**
     * 过滤方法
     * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
     */
    @Override
    public int accept(Method method) {
        if ("speak".equals(method.getName())) {
            System.out.println("filter speak == 0");
            return 0;
        }
        if ("work".equals(method.getName())) {
            System.out.println("filter work == 1");
            return 1;
        }
        if ("eat".equals(method.getName())) {
            System.out.println("filter eat == 2");
            return 2;
        }
        return 3;
    }
}
