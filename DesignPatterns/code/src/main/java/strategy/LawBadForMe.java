package strategy;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 14:40 2023/3/7
 */
public class LawBadForMe implements Law {

    @Override
    public void interpret() {
        System.out.println("law is imperfect");
    }

    @Override
    public void execution() {
        System.out.println("We need selective enforcement");
    }
}
