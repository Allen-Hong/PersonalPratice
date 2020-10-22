import com.allen.PayService;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-09 19:35
 */
public class SPITest {

    public static void main(String[] args) {
        ServiceLoader<PayService> load = ServiceLoader.load(PayService.class);
        Iterator<PayService> iterator = load.iterator();
        while (iterator.hasNext()) {
            iterator.next().run();
        }

        DriverManager.getDriver()
    }
}
