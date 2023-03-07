package mybatis.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 19:18 2023/3/6
 */
public class People {
    private int age;
    private Name name;
    private Address address;

    public People() {
    }

    public People(int age) {
        this.age = age;
        this.name = createName();
        this.address = createAddress();
    }

    protected Name createName() {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Name.class);
        return (Name) Enhancer.create(Name.class,new LazyLoaderImpl());
    }

    private Address createAddress() {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Address.class);
        return (Address) Enhancer.create(Address.class,new DispatcherImpl());
    }

    public void speak(String word) {
        System.out.println("people speak: " + word);
    }
    public void work(String order) {
        System.out.println("work 996 follow: " + order);
    }
    public void eat(String food) {
        System.out.println("hunger always eat: " + food);
    }
    public void fly(String wing) {
        System.out.println("fly with: " + wing);
    }

    public int getAge() {
        return age;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
