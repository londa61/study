package mybatis.proxy.cglib;

import net.sf.cglib.proxy.LazyLoader;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 20:33 2023/3/6
 */
public class LazyLoaderImpl implements LazyLoader {
    @Override
    public Object loadObject() {
        System.out.println("LazyLoader loadObject() ...");
        Name bean = new Name();
        bean.setFirstName("Jack");
        bean.setLastName("Chen");
        return bean;
    }
}
