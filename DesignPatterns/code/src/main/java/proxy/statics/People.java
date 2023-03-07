package proxy.statics;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 18:39 2023/3/6
 */
public interface People {
    /**
     * speak
     * @param word word
     */
    void speak(String word);

    /**
     * work
     * @param order order
     * @return order
     */
    String work(String order);
}
