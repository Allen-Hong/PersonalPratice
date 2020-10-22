import java.util.concurrent.Phaser;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-06 9:51
 */
public class PhaserTest {

    public static void main(String[] args) {
        test();
    }

    private static void test() {

        Phaser p = new Phaser(4);

        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"线程到达");
                p.arriveAndAwaitAdvance();
                if (p.getPhase() == 1) {
                    if (p.getArrivedParties() < 3) {
                        System.out.println(Thread.currentThread().getName()+"线程到达");
                        p.arriveAndAwaitAdvance();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程到达");
                }
                if (p.getPhase() == 2) {
                    if (p.getArrivedParties() < 2) {
                        System.out.println(Thread.currentThread().getName()+"线程到达");
                        p.arriveAndAwaitAdvance();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程到达");
                }
            }).start();
        }


    }

}
