package loader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-04 16:56
 */
public class MyCL extends ClassLoader {

    private HashMap<String,Class> classes = new HashMap<String, Class>();
    private String classPath;
    private String className;

    public MyCL(String classPath, String className) {
        this.classPath = classPath;
        this.className = className;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if (!name.startsWith("com.allen")) {
            return super.loadClass(name);
        }
        if (classes.containsKey(name)) {
            return classes.get(name);
        }

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
        return super.loadClass(name);
    }

    private byte[] getDate(String name) throws IOException {

        String tmp = name.replaceAll("\\.","/");
        JarFile jar = new JarFile(classPath);
        JarEntry jarEntry = jar.getJarEntry(tmp + ".class");
        InputStream is = jar.getInputStream(jarEntry);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int nextValue = is.read();
        while (nextValue != -1) {
            byteArrayOutputStream.write(nextValue);
            nextValue = is.read();
        }

        return byteArrayOutputStream.toByteArray();
    }
}
