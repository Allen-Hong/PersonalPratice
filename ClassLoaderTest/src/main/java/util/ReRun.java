package util;

import loader.ReCL;

import java.lang.reflect.Method;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-04 19:05
 */
public class ReRun {

    public static void reRun(String classPath,String mainClass,String[] args) throws Exception {
        ReCL reCL = new ReCL(classPath);
        Class<?> aClass = reCL.loadClass(mainClass);
        Method main = aClass.getMethod("main", String[].class);
        Method setFlag = aClass.getDeclaredMethod("setFlag", null);
        setFlag.invoke(null);
        main.invoke(null,(Object) args);
        System.exit(0);
    }
}
