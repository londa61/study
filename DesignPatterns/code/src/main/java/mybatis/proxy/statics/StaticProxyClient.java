package mybatis.proxy.statics;

/**
 * zlz
 *
 * @author flz
 * @version 1.0
 * @description:
 * @date 11:43 2023/3/7
 */
public class StaticProxyClient {
    public static void main(String[] args) {
        People worker = new Worker();
        WorkerProxy workerProxy = new WorkerProxy(worker);
        workerProxy.speak("hello");
        workerProxy.work("code");
    }
}
