package strategy;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 14:43 2023/3/7
 */
public class Judgment {

    private final Law law;

    public Judgment(Law law) {
        this.law = law;
    }

    public void judge() {
        law.interpret();
        law.execution();
    }
}
