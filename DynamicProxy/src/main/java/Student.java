/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-10 9:55
 */
public class Student implements People {
    @Override
    public People work(String str) {
        System.out.println("工作内容是: "+str);
        return this;
    }
}
