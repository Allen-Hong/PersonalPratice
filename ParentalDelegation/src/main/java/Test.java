import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-09-20 11:02
 */
public class Test {

    public Test() {
        System.out.println(this.getClass().getClassLoader().toString());
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> test = Class.forName("Test");
        Constructor<?> constructor = test.getConstructor();
        Test test1 = (Test) constructor.newInstance();
        System.out.println(test.getClassLoader().toString());
    }
}
