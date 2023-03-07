package proxy.statics;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 11:38 2023/3/7
 */
public class Worker implements People {
    @Override
    public void speak(String word) {
        System.out.println("a worker speak " + word);
    }

    @Override
    public String work(String order) {
        System.out.println("work 996 follow: " + order);
        return order;
    }
}
