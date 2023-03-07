package proxy.jdk;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 18:57 2023/3/6
 */
public class Child implements People{
    @Override
    public void speak(String word) {
        System.out.println("a child speak "+ word);
    }

    @Override
    public String work(String order) {
        System.out.println("a child work " + order);
        return order + " with noting by child";
    }
}
