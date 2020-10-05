package em;

import com.allen.A;
import com.allen.B;
import loader.ReCL;
import util.ReRun;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-04 18:48
 */
public class Method2 {

    private static boolean flag = true;

    public static void setFlag(){
        flag = false;
    }

    public static void main(String[] args) throws Exception {
        if (flag) {
            ReRun.reRun("H:\\Program\\JetBrains\\IDEAProject\\PersonalPratice\\ClassLoaderTest\\target\\classes\\em\\Method2.class",Method2.class.getName(),args);
        }
        new A().run();
        new B().run();
    }
}
