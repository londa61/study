package proxy.jdk;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 18:40 2023/3/6
 */
public class Worker implements People {
    @Override
    public void speak(String word) {
        System.out.println("a worker speak " + word);
    }

    @Override
    public String work(String order) {
        System.out.println("a worker work " + order);
        return order + " with work";
    }
}
