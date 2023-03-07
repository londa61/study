package strategy;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 14:38 2023/3/7
 */
public interface Law {

    /**
     * 解读
     */
    void interpret();

    /**
     * 执行
     */
    void execution();
}
