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

    public People() {
    }

    public People(int age) {
        this.age = age;
        this.name = createName();
    }

    protected Name createName() {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Name.class);
        return (Name) Enhancer.create(Name.class,new LazyLoaderImpl());
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
}
