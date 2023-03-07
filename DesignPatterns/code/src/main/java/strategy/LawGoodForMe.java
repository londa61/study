package strategy;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 14:40 2023/3/7
 */
public class LawGoodForMe implements Law {

    @Override
    public void interpret() {
        System.out.println("laws are important");
    }

    @Override
    public void execution() {
        System.out.println("we must implement");
    }
}
