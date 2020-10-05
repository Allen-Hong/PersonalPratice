import javafx.scene.Parent;

import java.io.*;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-09-20 11:03
 */
public class TestClassLoader extends ClassLoader {

    private String name;

    public TestClassLoader(ClassLoader Parent,String name){
        super(Parent);
        this.name = name;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int c;
            is = new FileInputStream(new File("H:\\Program\\JetBrains\\IDEAProject\\PersonalPratice\\ParentalDelegation\\src\\main\\java\\Test.java"));
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this.defineClass(name,data,0,data.length);
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        TestClassLoader testClassLoader = new TestClassLoader(TestClassLoader.class.getClassLoader(),"TestLoader");
        Class clazz;
        try {
            clazz = testClassLoader.loadClass("Test");
            Object object = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
