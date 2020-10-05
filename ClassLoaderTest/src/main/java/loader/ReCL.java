package loader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-04 18:48
 */
public class ReCL extends ClassLoader {

    private String classPath;

    public ReCL(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if (name.startsWith("em")) {
            try {
                byte[] date = getDate(name);
                if (date == null) {
                } else {
                    //defineClass方法将字节码转化为类
                    Class<?> c = defineClass(name, date, 0, date.length, null);
                    return c;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (name.equals("com.allen.A")) {
            MyCL myCLA = new MyCL("H:\\Program\\JetBrains\\IDEAProject\\PersonalPratice\\A\\target\\A-1.0.0-SNAPSHOT.jar", "A.jar");
            return myCLA.loadClass("com.allen.A");
        }
        if (name.equals("com.allen.B")) {
            MyCL myCLB = new MyCL("H:\\Program\\JetBrains\\IDEAProject\\PersonalPratice\\B\\target\\B-1.0.0-SNAPSHOT.jar", "B.jar");
            return myCLB.loadClass("com.allen.B");
        }
        return super.loadClass(name);
    }

    private byte[] getDate(String name) throws IOException {

        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path=classPath;
        try {
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }
}
