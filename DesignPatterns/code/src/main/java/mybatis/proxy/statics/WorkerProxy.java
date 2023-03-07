package mybatis.proxy.statics;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 11:39 2023/3/7
 */
public class WorkerProxy implements People {
    private People target;

    public WorkerProxy(People people) {
        this.target = people;
    }

    @Override
    public void speak(String word) {
        System.out.println("WorkerProxy speak before");
        target.speak(word);
        System.out.println("WorkerProxy speak after");
    }

    @Override
    public String work(String order) {
        System.out.println("WorkerProxy work before");
        target.work(order);
        System.out.println("WorkerProxy work after");
        return order + "after proxy";
    }
}
