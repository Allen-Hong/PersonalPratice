/**
 * @author huanghw
 * @Description TODO
 * @create 2020-09-15 9:22
 */
public class ThreadLocalTest {

    static ThreadLocal<Integer> threadLocal  = new ThreadLocal<>();
    static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            System.out.println(threadLocal.get());
            System.out.println(threadLocal2.get());
            threadLocal.set(1);
            threadLocal2.set(new String("123"));
            System.out.println(threadLocal.get());
            System.out.println(threadLocal2.get());
        },"A"
        ).start();

        new Thread(()->{
            System.out.println(threadLocal.get());
            System.out.println(threadLocal2.get());
            threadLocal.set(1);
            threadLocal2.set(new String("123"));
            System.out.println(threadLocal.get());
            System.out.println(threadLocal2.get());
        },"B"
        ).start();
    }

}
