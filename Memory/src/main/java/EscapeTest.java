import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghw
 * @Description 逃逸分析（如果创建的变量只在当前代码块使用，java内存会在栈中生成该对象，也就是说，内存不用创建该对象，减少了GC的次数）
 * @create 2020-09-22 9:40
 */
public class EscapeTest {

    public static void main(String[] args) {

        while (true) {
            Integer integer = new Integer(111);
        }

    }

}
