package strategy;

import java.util.HashMap;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 14:46 2023/3/7
 */
public class StrategyClient {

    private static final HashMap<String, Law> LAW_MAP;

    static {
        LAW_MAP = new HashMap<String, Law>();
        LAW_MAP.put("good", new LawGoodForMe());
        LAW_MAP.put("bad", new LawBadForMe());
    }

    public static void main(String[] args) {
        System.out.println("————————————————————————————");
        Judgment judgment1 = new Judgment(LAW_MAP.get("good"));
        judgment1.judge();
        System.out.println("————————————————————————————");
        Judgment judgment2 = new Judgment(LAW_MAP.get("bad"));
        judgment2.judge();
        System.out.println("————————————————————————————\n");
    }
}
