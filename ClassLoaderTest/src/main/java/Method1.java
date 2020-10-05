import com.sun.xml.internal.ws.api.model.MEP;
import loader.MyCL;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-04 16:56
 */
public class Method1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        MyCL myCLA = new MyCL("H:\\Program\\JetBrains\\IDEAProject\\PersonalPratice\\A\\target\\A-1.0.0-SNAPSHOT.jar", "A.jar");
        Class<?> aClass = myCLA.loadClass("com.allen.A");

        MyCL myCLB = new MyCL("H:\\Program\\JetBrains\\IDEAProject\\PersonalPratice\\B\\target\\B-1.0.0-SNAPSHOT.jar", "B.jar");
        Class<?> bClass = myCLB.loadClass("com.allen.B");

        Object objectA = aClass.newInstance();
        Method methodA = aClass.getMethod("run", null);
        methodA.invoke(objectA,null);

        Object objectB = bClass.newInstance();
        Method methodB = bClass.getMethod("run", null);
        methodB.invoke(objectB,null);
    }
}
